
public class Channel{
	public int channelNo;
	public boolean isArmed;
	public Channel(int channelNo){
		this.channelNo=channelNo;
		isArmed=false;
	}
	
	public boolean trig(){
		if(!isArmed)
			return false;
		else
			return true;
	}
	public boolean tog(){
		isArmed=!isArmed;
		return isArmed;
	}
	public void conn(String sensor){
		
	}
	public void disc(int channelNo){
		
	}
}