import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class SimulatedAnnealing {
	public ArrayList<Activity> A; // all activities
	private ArrayList<Activity> AP; // activities in progress
	private ArrayList<Activity> AD; // done activities
	private ArrayList<Activity> AL; // activities left
	public boolean[] R; // ressources 1 - available, 0 - non available
	int totalTime;
	public static int loopCount;
	private int counter;
	private int bestEnergy;
	
	public int getBestSolutionCounter() {
		return bestSolutionCounter;
	}

	public ArrayList<Activity> getBestSolution() {
		return bestSolution;
	}
	
	public int getBestEnergy() {
		return bestEnergy;
	}

	public static int getLoopCount() {
		return loopCount;
	}

	private int bestSolutionCounter;
	public ArrayList<Activity> bestSolution;
	

	public SimulatedAnnealing(ArrayList<Activity> activities,
			boolean[] ressources, int totalTime) {
		this.A = activities;
		this.AL = new ArrayList(activities);
		this.AP = new ArrayList();
		this.AD = new ArrayList();
		this.bestSolution = new ArrayList();
		R = ressources;
		this.totalTime = totalTime;
		bestEnergy = 0;
		loopCount = 0;
		bestSolutionCounter = 0;
		counter = 0;
	}
	
    // Calculate the acceptance probability
    public static double acceptanceProbability(int energy, int newEnergy, double temperature) {
        // If the new solution is better, accept it
        if (newEnergy < energy) {
            return 1.0;
        }
        // If the new solution is worse, calculate an acceptance probability
        return Math.exp((energy - newEnergy) / temperature);
    }

	private boolean activityDone(int id) {
		for (Activity a : AD) {
			if (a.id == id)
				return true;
		}
		return false;
	}

	private int getAvailableRessource() {
		for (int i = 1; i <= R.length; i++) {
			if (R[i - 1] == true) {
				R[i - 1] = false;
				return i;
			}
		}
		return -1;
	}

	private boolean availableRessources() {
		for (boolean r : R)
			if (r == true)
				return true;

		return false;
	}
	
	private void reinitializeRessources() {
		for (int i = 0; i < R.length; i++) 
			R[i] = true;
	}

	public boolean checkOrder(ArrayList<Activity> activities) {
		boolean isCorrect = true;

		for (Activity a : activities) {
			loopCount += 1;
			if (a.hasPredecesors()) {
				for (int p : a.predecesors) {
					for (Activity ac : activities) {
						//loopCount += 1;
						if (ac.id == p) {
							if (ac.startTime + ac.duration > a.startTime) {
								isCorrect = false;
								//System.out.println("WRONG ORDER !!!!");
								return isCorrect;
							}

						}
					}
				}
			}

		}

		return isCorrect;
	}

	public Activity getAvailableActivity(ArrayList<Activity> activities) {
		for (Activity a : activities) {
			if (!a.flag) {
				if (!a.hasPredecesors())
					return a;
				else {
					boolean toReturn = true;
					for (int p : a.predecesors) {
						if (!activityDone(p))
							toReturn = false;
					}
					if (toReturn)
						return a;
					else
						continue;
				}
			} else
				continue;
		}
		return null;
	}

	private int generateInitialSolution() {
		//System.out.println("Activities: " + A.toString());
		
		int time = 0;
		int order = 1;
		
		for (time = 0; time < this.totalTime; time++) {

			if (this.AL.isEmpty() && this.AP.isEmpty())
				break;

			while (availableRessources()) {
				Activity a = getAvailableActivity(A);
				
				if (a != null) {
					a.flag = true;
					a.resourceId = getAvailableRessource();
					a.startTime = time;
					a.order = order;
					AP.add(a);
					AL.remove(a);
					order++;

				} else
					break;
			}

			for (Iterator<Activity> iterator = AP.iterator(); iterator
					.hasNext();) {
				Activity a = iterator.next();
				a.timeLeft -= 1;
				if (a.timeLeft == 0) {
					R[a.resourceId - 1] = true; // make ressource available
					iterator.remove();
					AD.add(a);
				}
			}
		}
		
		//Reinitialization of variables
		reinitializeRessources();
		this.AL = new ArrayList();
		this.AP = new ArrayList();
		this.AD = new ArrayList();
		
//		System.out.println("Initial solution: ");
//		Collections.sort(A, new CustomComparator());
//		System.out.println("Activities: " + A.toString());
//		System.out.println("Time: " + time);
		
		this.counter++;
		return time;
	}

	private int getNeighbourhoodRand(ArrayList<Activity> activities) {
		
		int rand1 = 0 + (int)(Math.random() * activities.size()); 
		int rand2 = 0 + (int)(Math.random() * activities.size()); 
		
		while(rand1==rand2){
			rand2 = 0 + (int)(Math.random() * activities.size()); 
		}
		
		Activity ac1 = activities.get(rand1);
		Activity ac2 = activities.get(rand2);
		
		int tempStart = ac1.startTime;
		ac1.startTime = ac2.startTime;
		ac2.startTime = tempStart;
		
		int tempOrder = ac1.order;
		ac1.order = ac2.order;
		ac2.order = tempOrder;
		
		if(checkOrder(activities))
		{
			this.counter+=1;
			Collections.sort(activities, new CustomComparator());
			
			this.AL = new ArrayList(activities);
			int time = 0;
			
			for (time = 0; time < this.totalTime; time++) {
				
				if (this.AL.isEmpty() && this.AP.isEmpty())
					break;

				while (availableRessources()) {
					Activity a = getAvailableActivity(activities);
					
					if (a != null) {
						a.flag = true;
						a.resourceId = getAvailableRessource();
						a.startTime = time;
						//a.order = order;
						AP.add(a);
						AL.remove(a);
					}
					else
						break;
				}

				for (Iterator<Activity> iterator = AP.iterator(); iterator
						.hasNext();) {
					Activity a = iterator.next();
					a.timeLeft -= 1;
					if (a.timeLeft == 0) {
						R[a.resourceId - 1] = true; // make ressource available
						iterator.remove();
						AD.add(a);
					}
				}
			}
			//Reinitialization of variables
			reinitializeRessources();
			this.AL = new ArrayList();
			this.AP = new ArrayList();
			this.AD = new ArrayList();
			
			System.out.println("Solution no: "+counter);
			Collections.sort(activities, new CustomComparator());
			System.out.println("Activities: " + activities.toString());
			System.out.println("Time: " + time);
			
			return time;
		}
		else{
			return -1;
		}
		
	}
	
	
private int getNeighbourhood2(ArrayList<Activity> activities) {
		
		int rand = 0 + (int)(Math.random() * activities.size()-1); 
		
		Activity ac1 = activities.get(rand);
		Activity ac2 = activities.get(rand+1);
		
		int tempStart = ac1.startTime;
		ac1.startTime = ac2.startTime;
		ac2.startTime = tempStart;
		
		int tempOrder = ac1.order;
		ac1.order = ac2.order;
		ac2.order = tempOrder;
		
		if(checkOrder(activities))
		{
			this.counter+=1;
			Collections.sort(activities, new CustomComparator());
			
			this.AL = new ArrayList(activities);
			int time = 0;
			
			for (time = 0; time < this.totalTime; time++) {
				
				if (this.AL.isEmpty() && this.AP.isEmpty())
					break;

				while (availableRessources()) {
					Activity a = getAvailableActivity(activities);
					
					if (a != null) {
						a.flag = true;
						a.resourceId = getAvailableRessource();
						a.startTime = time;
						//a.order = order;
						AP.add(a);
						AL.remove(a);
					}
					else
						break;
				}

				for (Iterator<Activity> iterator = AP.iterator(); iterator
						.hasNext();) {
					Activity a = iterator.next();
					a.timeLeft -= 1;
					if (a.timeLeft == 0) {
						R[a.resourceId - 1] = true; // make ressource available
						iterator.remove();
						AD.add(a);
					}
				}
			}
			
			System.out.println("Solution no: "+counter);
			Collections.sort(activities, new CustomComparator());
			System.out.println("Activities: " + activities.toString());
			System.out.println("Time: " + time);
			
			//Reinitialization of variables
			reinitializeRessources();
			this.AL = new ArrayList();
			this.AP = new ArrayList();
			this.AD = new ArrayList();
			
			return time;
		}
		else{
			return -1;
		}
		
	}

private int getNeighbourhood3(ArrayList<Activity> activities) {
	
	int rand = 1 + (int)(Math.random() * (activities.size() -2)); 
	
	Activity ac1 = activities.get(rand-1);
	Activity ac2 = activities.get(rand);
	Activity ac3 = activities.get(rand+1);
	
	int tempStart = ac1.startTime;
	ac1.startTime = ac3.startTime;	
	ac3.startTime = ac2.startTime;
	ac2.startTime = tempStart;
	
	
	int tempOrder = ac1.order;
	ac1.order = ac3.order;
	ac3.order = ac2.order;
	ac2.order = tempOrder;
	
	if(checkOrder(activities))
	{
		this.counter+=1;
		Collections.sort(activities, new CustomComparator());
		
		this.AL = new ArrayList(activities);
		int time = 0;
		
		for (time = 0; time < this.totalTime; time++) {
			
			if (this.AL.isEmpty() && this.AP.isEmpty())
				break;

			while (availableRessources()) {
				Activity a = getAvailableActivity(activities);
				
				if (a != null) {
					a.flag = true;
					a.resourceId = getAvailableRessource();
					a.startTime = time;
					//a.order = order;
					AP.add(a);
					AL.remove(a);
				}
				else
					break;
			}

			for (Iterator<Activity> iterator = AP.iterator(); iterator
					.hasNext();) {
				Activity a = iterator.next();
				a.timeLeft -= 1;
				if (a.timeLeft == 0) {
					R[a.resourceId - 1] = true; // make ressource available
					iterator.remove();
					AD.add(a);
				}
			}
		}
		//Reinitialization of variables
		reinitializeRessources();
		this.AL = new ArrayList();
		this.AP = new ArrayList();
		this.AD = new ArrayList();
		
		return time;
	}
	else{
		return -1;
	}
	
}
	
	public void simulatedAnnealingRand(){
		
		double temp = 100;
        double coolingRate = 0.003;
        
        int currentEnergy = generateInitialSolution();
        bestEnergy = currentEnergy;
        this.bestSolution = new ArrayList(A);
        
        int neighbourEnergy =-1;
        
        while (temp > 1) {
        	ArrayList<Activity> tempActivities = new ArrayList(A);
        	for(Activity t:tempActivities){
        		t.timeLeft = t.duration;
        		t.flag = false;
        	}
        	
        	while(neighbourEnergy==-1){      		
        		neighbourEnergy = getNeighbourhoodRand(tempActivities);
        		//this.counter++;
        	}
        	
        	if (acceptanceProbability(currentEnergy, neighbourEnergy, temp) > Math.random()) {
                this.A = tempActivities;
                currentEnergy = neighbourEnergy;
            }
        	//System.out.println("Energy: "+currentEnergy);
            // Keep track of the best solution found
            if (currentEnergy < bestEnergy) {
            	this.bestEnergy = currentEnergy;
                this.bestSolution = new ArrayList(tempActivities);
                bestSolutionCounter = counter;
            }
        	temp *= 1-coolingRate;
        	neighbourEnergy=-1;
        }
        
    	System.out.println("Best solution no: "+bestSolutionCounter);
		Collections.sort(A, new CustomComparator());
		System.out.println("Activities: " + A.toString());
		System.out.println("Time: " + bestEnergy);
		System.out.println("Loop counts: " + loopCount);
		
	}
	
public void simulatedAnnealing2(){
		
		double temp = 100;
        double coolingRate = 0.003;
        
        int currentEnergy = generateInitialSolution();
        bestEnergy = currentEnergy;
        this.bestSolution = new ArrayList(A);
        
        int neighbourEnergy =-1;
        
        while (temp > 1) {
        	ArrayList<Activity> tempActivities = new ArrayList(A);
        	for(Activity t:tempActivities){
        		t.timeLeft = t.duration;
        		t.flag = false;
        	}
        	
        	while(neighbourEnergy==-1){      		
        		neighbourEnergy = getNeighbourhood2(tempActivities);
        		//this.counter++;
        	}
        	
        	if (acceptanceProbability(currentEnergy, neighbourEnergy, temp) > Math.random()) {
                this.A = tempActivities;
                currentEnergy = neighbourEnergy;
            }
        	//System.out.println("Energy: "+currentEnergy);
            // Keep track of the best solution found
            if (currentEnergy < bestEnergy) {
            	this.bestEnergy = currentEnergy;
                this.bestSolution = new ArrayList(tempActivities);
                bestSolutionCounter = counter;
            }
        	temp *= 1-coolingRate;
        	neighbourEnergy=-1;
        }
		
	}


public void simulatedAnnealing3(){
	
	double temp = 100;
    double coolingRate = 0.003;
    
    int currentEnergy = generateInitialSolution();
    bestEnergy = currentEnergy;
    this.bestSolution = new ArrayList(A);
    
    int neighbourEnergy =-1;
    
    while (temp > 1) {
    	ArrayList<Activity> tempActivities = new ArrayList(A);
    	for(Activity t:tempActivities){
    		t.timeLeft = t.duration;
    		t.flag = false;
    	}
    	
    	while(neighbourEnergy==-1){      		
    		neighbourEnergy = getNeighbourhood3(tempActivities);
    		//this.counter++;
    	}
    	
    	if (acceptanceProbability(currentEnergy, neighbourEnergy, temp) > Math.random()) {
            this.A = tempActivities;
            currentEnergy = neighbourEnergy;
        }
    	//System.out.println("Energy: "+currentEnergy);
        // Keep track of the best solution found
        if (currentEnergy < bestEnergy) {
        	this.bestEnergy = currentEnergy;
            this.bestSolution = new ArrayList(tempActivities);
            bestSolutionCounter = counter;
        }
    	temp *= 1-coolingRate;
    	neighbourEnergy=-1;
    }
}
}
