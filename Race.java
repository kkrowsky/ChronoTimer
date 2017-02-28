import java.util.ArrayDeque;
import java.util.Deque;

public class Race {
	
	String type;
	boolean runInProgress=true;
	int runNum=1;
	Deque<Competitor> startQueue = new ArrayDeque<Competitor>();
	Deque<Competitor> finishQueue = new ArrayDeque<Competitor>();
	Deque<Competitor> completed = new ArrayDeque<Competitor>();
	
	public Event setEvent(String type){
		switch (type) {
		case "IND":
			return new IndEvent();
		case "PARIND":
			break;
		case "GRP":
			break;
		case "PARGRP":
			break;
		}
		return null;
	}
	public boolean newRun(){
		if(!runInProgress){
			startQueue.clear();
			finishQueue.clear();
			completed.clear();
			runNum++;
			runInProgress=true;
			return runInProgress;
		}
		return !runInProgress;
	}
	public void endRun(){
		runInProgress=false;
	}
	public void print(){
		System.out.println("Run " +runNum+" Results");
		System.out.println("NUM\tTime");
		for(Competitor competitor:completed){
			System.out.print(competitor.getCompetitorNumber() + "\t");
			System.out.println(competitor.dnf ? "DNF" : String.format("%.2f", competitor.getRaceTime()));
		}
	}
	public void export(String run){
		
	}
	public boolean setNum(int competitorNo){
		return startQueue.add(new Competitor(competitorNo));
	}
	public void clear(int competitorNo){
		
	}
	public void swap(){
		
	}
	public void dnf(){
		Competitor temp;
		temp=finishQueue.remove();
		temp.dnf=true;
		completed.add(temp);
	}
	public void cancel(){
		startQueue.addFirst(finishQueue.removeLast());
	}
}
