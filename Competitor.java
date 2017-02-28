public class Competitor {
	
	int competitorNo;
	double startTime;
	double finishTime;
	boolean dnf;
	
	public Competitor(int competitorNo){
		this.competitorNo = competitorNo;
	}
	public void setStartTime(double time){
		startTime = time;
	}
	public void setFinishTime(double time){
		finishTime = time;
	}
	public double getStartTime(){
		return startTime;
	}
	public double getFinishTime(){
		return finishTime;
	}
	public double getRaceTime(){
		return finishTime-startTime;
	}
	public int getCompetitorNumber(){
		return competitorNo;
	}
}
