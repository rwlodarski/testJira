import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class RunClass {

	/**
	 * @param args
	 * @throws UnsupportedEncodingException 
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		
		int c = 25;
		
		int solutionNo[]  = new int[c];
		int time[] = new int[c];
		int loopCount[] = new int[c];
		
		
//		for(int i=0;i<c;i++){
//			Activity a1 = new Activity(1,8, new int[]{});
//			Activity a2 = new Activity(2,12, new int[]{});
//			Activity a3 = new Activity(3,5, new int[]{});
//			Activity a4 = new Activity(4,10, new int[]{});
//			Activity a5 = new Activity(5,3, new int[]{1});
//			Activity a6 = new Activity(6,4, new int[]{1});
//			Activity a7 = new Activity(7,2, new int[]{5});
//			Activity a8 = new Activity(8,4, new int[]{6});
//			Activity a9 = new Activity(9,2, new int[]{3});
//			Activity a10 = new Activity(10,3, new int[]{4,6});
//			SimulatedAnnealing saRand = new SimulatedAnnealing(new ArrayList<>(Arrays.asList(a1,a9,a4,a5,a3,a6,a7,a8,a2,a10)), new boolean[]{true,true,true}, 50);
//			saRand.simulatedAnnealingRand();
//			solutionNo[i]=saRand.getBestSolutionCounter();
//			time[i]=saRand.getBestEnergy();
//			loopCount[i]=saRand.getLoopCount();
//			System.out.println("////////////////// "+i);
//		}
		int sSolutionNo = 0;
//        for (int e : solutionNo) sSolutionNo += e;
//        sSolutionNo/=c;
//        
        int sTime = 0;
//        for (int e : time) sTime += e;
//        sTime/=c;
//        
        BigInteger sLoopCount = BigInteger.valueOf(0);
//        for (int e : loopCount) sLoopCount = sLoopCount.add(sLoopCount.valueOf(e));
//        sLoopCount= sLoopCount.divide(sLoopCount.valueOf(c));
//        
		PrintWriter writer;
//		writer= new PrintWriter("saRand10.txt", "UTF-8");
//	    writer.println("Best solution no: "+sSolutionNo);
//	    writer.println("Time: "+sTime);
//	    writer.println("Loop counts: "+sLoopCount);
//	    writer.close();
		
		
		
		
//		solutionNo  = new int[c];
//		time = new int[c];
//		loopCount = new int[c];
//		
//		for(int i=0;i<c;i++){
//			Activity a1 = new Activity(1,8, new int[]{});
//			Activity a2 = new Activity(2,12, new int[]{});
//			Activity a3 = new Activity(3,5, new int[]{});
//			Activity a4 = new Activity(4,10, new int[]{});
//			Activity a5 = new Activity(5,3, new int[]{1});
//			Activity a6 = new Activity(6,4, new int[]{1});
//			Activity a7 = new Activity(7,2, new int[]{5});
//			Activity a8 = new Activity(8,4, new int[]{6});
//			Activity a9 = new Activity(9,2, new int[]{3});
//			Activity a10 = new Activity(10,3, new int[]{4,6});
//			Activity a11 = new Activity(11,4, new int[]{9,10});
//			Activity a12 = new Activity(12,8, new int[]{2,5});
//			Activity a13 = new Activity(13,10, new int[]{3,10});
//			Activity a14 = new Activity(14,5, new int[]{1,5,8});
//			Activity a15 = new Activity(15,8, new int[]{3,12});
//			Activity a16 = new Activity(16,2, new int[]{15});
//			Activity a17 = new Activity(17,8, new int[]{});
//			Activity a18 = new Activity(18,16, new int[]{3,11});
//			Activity a19 = new Activity(19,8, new int[]{18});
//			Activity a20 = new Activity(20,8, new int[]{});
//			
//			SimulatedAnnealing saRand = new SimulatedAnnealing(new ArrayList<>(Arrays.asList(a1,a9,a4,a5,a3,a6,a7,a8,a2,a10,a11,a12,a13,a14,a15)), new boolean[]{true,true,true}, 50);
//			saRand.simulatedAnnealingRand();
//			solutionNo[i]=saRand.getBestSolutionCounter();
//			time[i]=saRand.getBestEnergy();
//			loopCount[i]=saRand.getLoopCount();
//			
//			System.out.println("////////////////// "+i);
//		}
//		sSolutionNo = 0;
//        for (int e : solutionNo) sSolutionNo += e;
//        sSolutionNo/=c;
//        
//        sTime = 0;
//        for (int e : time) sTime += e;
//        sTime/=c;
//        
//        sLoopCount = BigInteger.valueOf(0);
//        for (int e : loopCount) sLoopCount = sLoopCount.add(sLoopCount.valueOf(e));
//        sLoopCount= sLoopCount.divide(sLoopCount.valueOf(c));
//        
//		writer = new PrintWriter("saRand20.txt", "UTF-8");
//	    writer.println("Best solution no: "+sSolutionNo);
//	    writer.println("Time: "+sTime);
//	    writer.println("Loop counts: "+sLoopCount);
//	    writer.close();
//	    
	    
	    
	    
//	    solutionNo  = new int[c];
//		time = new int[c];
//		loopCount = new int[c];
//		
//		
//		for(int i=0;i<c;i++){
//			Activity a1 = new Activity(1,8, new int[]{});
//			Activity a2 = new Activity(2,12, new int[]{});
//			Activity a3 = new Activity(3,5, new int[]{});
//			Activity a4 = new Activity(4,10, new int[]{});
//			Activity a5 = new Activity(5,3, new int[]{1});
//			Activity a6 = new Activity(6,4, new int[]{1});
//			Activity a7 = new Activity(7,2, new int[]{5});
//			Activity a8 = new Activity(8,4, new int[]{6});
//			Activity a9 = new Activity(9,2, new int[]{3});
//			Activity a10 = new Activity(10,3, new int[]{4,6});
//			SimulatedAnnealing sa2 = new SimulatedAnnealing(new ArrayList<>(Arrays.asList(a1,a9,a4,a5,a3,a6,a7,a8,a2,a10)), new boolean[]{true,true,true}, 50);
//			sa2.simulatedAnnealing2();
//			solutionNo[i]=sa2.getBestSolutionCounter();
//			time[i]=sa2.getBestEnergy();
//			loopCount[i]=sa2.getLoopCount();
//			System.out.println("////////////////// "+i);
//		}
//		sSolutionNo = 0;
//        for (int e : solutionNo) sSolutionNo += e;
//        sSolutionNo/=c;
//        
//        sTime = 0;
//        for (int e : time) sTime += e;
//        sTime/=c;
//        
//        sLoopCount = BigInteger.valueOf(0);
//        for (int e : loopCount) sLoopCount = sLoopCount.add(sLoopCount.valueOf(e));
//        sLoopCount= sLoopCount.divide(sLoopCount.valueOf(c));
//        
//		writer = new PrintWriter("sa2-10.txt", "UTF-8");
//	    writer.println("Best solution no: "+sSolutionNo);
//	    writer.println("Time: "+sTime);
//	    writer.println("Loop counts: "+sLoopCount);
//	    writer.close();
		
		solutionNo  = new int[c];
		time = new int[c];
		loopCount = new int[c];
		
		for(int i=0;i<c;i++){
			Activity a1 = new Activity(1,8, new int[]{});
			Activity a2 = new Activity(2,12, new int[]{});
			Activity a3 = new Activity(3,5, new int[]{});
			Activity a4 = new Activity(4,10, new int[]{});
			Activity a5 = new Activity(5,3, new int[]{1});
			Activity a6 = new Activity(6,4, new int[]{1});
			Activity a7 = new Activity(7,2, new int[]{5});
			Activity a8 = new Activity(8,4, new int[]{6});
			Activity a9 = new Activity(9,2, new int[]{3});
			Activity a10 = new Activity(10,3, new int[]{4,6});
			Activity a11 = new Activity(11,4, new int[]{9,10});
			Activity a12 = new Activity(12,8, new int[]{2,5});
			Activity a13 = new Activity(13,10, new int[]{3,10});
			Activity a14 = new Activity(14,5, new int[]{1,5,8});
			Activity a15 = new Activity(15,8, new int[]{3,12});
			Activity a16 = new Activity(16,2, new int[]{15});
			Activity a17 = new Activity(17,8, new int[]{});
			Activity a18 = new Activity(18,16, new int[]{3,11});
			Activity a19 = new Activity(19,8, new int[]{18});
			Activity a20 = new Activity(20,8, new int[]{});
			SimulatedAnnealing sa2 = new SimulatedAnnealing(new ArrayList<>(Arrays.asList(a1,a9,a4,a5,a3,a6,a7,a8,a2,a10,a11,a12,a13,a14,a15)), new boolean[]{true,true,true}, 50);
			sa2.simulatedAnnealing2();
			System.out.println("////////////////// "+i);
			solutionNo[i]=sa2.getBestSolutionCounter();
			time[i]=sa2.getBestEnergy();
			loopCount[i]=sa2.getLoopCount();
		}
		sSolutionNo = 0;
        for (int e : solutionNo) sSolutionNo += e;
        sSolutionNo/=c;
        
        sTime = 0;
        for (int e : time) sTime += e;
        sTime/=c;
        
        sLoopCount = BigInteger.valueOf(0);
        for (int e : loopCount) sLoopCount = sLoopCount.add(sLoopCount.valueOf(e));
        sLoopCount= sLoopCount.divide(sLoopCount.valueOf(c));
        
		writer = new PrintWriter("sa2-20.txt", "UTF-8");
	    writer.println("Best solution no: "+sSolutionNo);
	    writer.println("Time: "+sTime);
	    writer.println("Loop counts: "+sLoopCount);
	    writer.close();
//	    
//	    
//	    
//	    
//	    solutionNo  = new int[c];
//		time = new int[c];
//		loopCount = new int[c];
//		
//		
//		for(int i=0;i<c;i++){
//			Activity a1 = new Activity(1,8, new int[]{});
//			Activity a2 = new Activity(2,12, new int[]{});
//			Activity a3 = new Activity(3,5, new int[]{});
//			Activity a4 = new Activity(4,10, new int[]{});
//			Activity a5 = new Activity(5,3, new int[]{1});
//			Activity a6 = new Activity(6,4, new int[]{1});
//			Activity a7 = new Activity(7,2, new int[]{5});
//			Activity a8 = new Activity(8,4, new int[]{6});
//			Activity a9 = new Activity(9,2, new int[]{3});
//			Activity a10 = new Activity(10,3, new int[]{4,6});
//			SimulatedAnnealing sa3 = new SimulatedAnnealing(new ArrayList<>(Arrays.asList(a1,a9,a4,a5,a3,a6,a7,a8,a2,a10)), new boolean[]{true,true,true}, 50);
//			sa3.simulatedAnnealing3();
//			solutionNo[i]=sa3.getBestSolutionCounter();
//			time[i]=sa3.getBestEnergy();
//			loopCount[i]=sa3.getLoopCount();
//		}
//		sSolutionNo = 0;
//        for (int e : solutionNo) sSolutionNo += e;
//        sSolutionNo/=c;
//        
//        sTime = 0;
//        for (int e : time) sTime += e;
//        sTime/=c;
//        
//        sLoopCount = BigInteger.valueOf(0);
//        for (int e : loopCount) sLoopCount = sLoopCount.add(sLoopCount.valueOf(e));
//        sLoopCount= sLoopCount.divide(sLoopCount.valueOf(c));
//        
//		writer = new PrintWriter("sa3-10.txt", "UTF-8");
//	    writer.println("Best solution no: "+sSolutionNo);
//	    writer.println("Time: "+sTime);
//	    writer.println("Loop counts: "+sLoopCount);
//	    writer.close();
//		
		solutionNo  = new int[c];
		time = new int[c];
		loopCount = new int[c];
		
		for(int i=0;i<c;i++){
			Activity a1 = new Activity(1,8, new int[]{});
			Activity a2 = new Activity(2,12, new int[]{});
			Activity a3 = new Activity(3,5, new int[]{});
			Activity a4 = new Activity(4,10, new int[]{});
			Activity a5 = new Activity(5,3, new int[]{1});
			Activity a6 = new Activity(6,4, new int[]{1});
			Activity a7 = new Activity(7,2, new int[]{5});
			Activity a8 = new Activity(8,4, new int[]{6});
			Activity a9 = new Activity(9,2, new int[]{3});
			Activity a10 = new Activity(10,3, new int[]{4,6});
			Activity a11 = new Activity(11,4, new int[]{9,10});
			Activity a12 = new Activity(12,8, new int[]{2,5});
			Activity a13 = new Activity(13,10, new int[]{3,10});
			Activity a14 = new Activity(14,5, new int[]{1,5,8});
			Activity a15 = new Activity(15,8, new int[]{3,12});
			Activity a16 = new Activity(16,2, new int[]{15});
			Activity a17 = new Activity(17,8, new int[]{});
			Activity a18 = new Activity(18,16, new int[]{3,11});
			Activity a19 = new Activity(19,8, new int[]{18});
			Activity a20 = new Activity(20,8, new int[]{});
			
			SimulatedAnnealing sa3 = new SimulatedAnnealing(new ArrayList<>(Arrays.asList(a1,a9,a4,a5,a3,a6,a7,a8,a2,a10,a11,a12,a13,a14,a15)), new boolean[]{true,true,true}, 50);
			sa3.simulatedAnnealing3();
			solutionNo[i]=sa3.getBestSolutionCounter();
			time[i]=sa3.getBestEnergy();
			loopCount[i]=sa3.getLoopCount();
		}
		sSolutionNo = 0;
        for (int e : solutionNo) sSolutionNo += e;
        sSolutionNo/=c;
        
        sTime = 0;
        for (int e : time) sTime += e;
        sTime/=c;
        
        sLoopCount = BigInteger.valueOf(0);
        for (int e : loopCount) sLoopCount = sLoopCount.add(sLoopCount.valueOf(e));
        sLoopCount= sLoopCount.divide(sLoopCount.valueOf(c));
        
		writer = new PrintWriter("sa3-20.txt", "UTF-8");
	    writer.println("Best solution no: "+sSolutionNo);
	    writer.println("Time: "+sTime);
	    writer.println("Loop counts: "+sLoopCount);
	    writer.close();
		
	}

}
