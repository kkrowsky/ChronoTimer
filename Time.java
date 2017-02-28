import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Time {
	public static Time systemTime = new Time();
	String[] time;
	private double hour;
	private double minute;
	private double second;
	private double clock;
	
	public void setTime(){
		clock=systemTime.toSeconds(new SimpleDateFormat("HH:mm:ss.SSS").format(Calendar.getInstance().getTime()));
	}
	public void setTime(double time){
		clock = time;
	}
	public double getClockTime(){
		return clock;
	}
	public double getRunningTime(){
		return clock;
	}
	public String toString(double time){
		int hour = (int) (time/3600);
		int min = (int) ((time-hour*3600)/60);
		double second = (double) (time-hour*3600-min*60);
		return String.format("%02d", hour)+":"+String.format("%02d", min)+":"+String.format("%.2f",second);
	}
	public double toSeconds(String time){		
		this.time= time.split(":");
		hour=Integer.parseInt(this.time[0]);
		minute=Integer.parseInt(this.time[1]);
		second=Float.parseFloat(this.time[2]);
		return (double) (hour*3600+minute*60+second);
	}
}
