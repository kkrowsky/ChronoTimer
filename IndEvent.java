public class IndEvent implements Event{//extends ChronoInterface implements Event{
	
	public IndEvent(){
		
	}
	Competitor temp;
	@Override
	public void start() {
		if(!ChronoInterface.chronoTimer.race.startQueue.isEmpty()){
			temp=ChronoInterface.chronoTimer.race.startQueue.remove();
			temp.setStartTime(Time.systemTime.getRunningTime());
			ChronoInterface.chronoTimer.race.finishQueue.add(temp);
		}
	}

	@Override
	public void finish() {
		if(!ChronoInterface.chronoTimer.race.finishQueue.isEmpty()){
			temp=ChronoInterface.chronoTimer.race.finishQueue.remove();
			temp.setFinishTime(Time.systemTime.getRunningTime());
			ChronoInterface.chronoTimer.race.completed.add(temp);
		}
	}	
}
