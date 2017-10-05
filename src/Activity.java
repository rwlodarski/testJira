
import java.util.Arrays;


public class Activity {
	 
	public	int id;
	public	int duration;
	public	int timeLeft;
	public	int startTime;
	public	Integer order;
	public	int resourceId;
	public	int[] predecesors;
	public  boolean flag;
	
	public Activity(int id, int duration, int[] predecessors){
		this.id = id;
		this.duration = duration;
		this.predecesors = predecessors;
		this.timeLeft = duration;
		this.order = 0;
		this.resourceId = 0;
		this.flag = false;
	}
	
	public boolean hasPredecesors()
	{
		return this.predecesors.length > 0;
	}
	public String toString() {
		return "Activity: " + id + ", Duration: " + duration + ", Start time: " + startTime ;//+ "\n" + "Predecesors: " + Arrays.toString(predecesors);
	}

	@Override
	public boolean equals(Object obj) {
		    Activity activityObj = (Activity)obj;
		   if(activityObj.id== this.id)
			   return true;
		   else
			   return false;
	} 
	

}
