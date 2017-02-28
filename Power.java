
public class Power {
	
	boolean powerStatus=false;
	
	public boolean power(){
		for(int i=0;i<9;i++)
			ChronoInterface.chronoTimer.channels.get(i).isArmed=false;
		ChronoInterface.chronoTimer.race.startQueue.clear();
		ChronoInterface.chronoTimer.race.finishQueue.clear();
		ChronoInterface.chronoTimer.race.completed.clear();
		powerStatus=!powerStatus;
		return powerStatus;
	}
}
