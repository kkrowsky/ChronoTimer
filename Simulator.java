import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.Writer;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Simulator {
	public static void parse(String lineInput) throws Exception{
		
		String[] input;
		
		input=lineInput.split(" ");
        
		if(input.length==1){
			Method method = ChronoInterface.chronoTimer.getClass().getMethod(input[0].toLowerCase());
			method.invoke(ChronoInterface.chronoTimer);
		}
		else if(input.length==2){
			Method method = ChronoInterface.chronoTimer.getClass().getMethod(input[0].toLowerCase(), String.class);
			method.invoke(ChronoInterface.chronoTimer, input[1]);
		}
		else if(input.length==3){
			Method method = ChronoInterface.chronoTimer.getClass().getMethod(input[0].toLowerCase(), String.class, String.class);
			method.invoke(ChronoInterface.chronoTimer, input[1], input[2]);
		}
	}
	
	public static void main(String[] args) throws Exception{
		Scanner scIn;
		String stringInput;
		String stringTime;
		//Writer file= new FileWriter("Event Record.txt");
		//BufferedWriter buffer = new BufferedWriter(file);
		
		try{
			if (args.length > 0 ){
				scIn = new Scanner(new File(args[0]));
			}
			else{
				scIn = new Scanner(System.in);
			}
			loop:while(scIn.hasNextLine()){
				try{
					if(args.length>0){
						stringTime=scIn.next();
						Time.systemTime.setTime(Time.systemTime.toSeconds(stringTime));
						stringInput=scIn.nextLine().trim();
						Thread.sleep(1000); //wait 1 second before next line is executed
					}
					else{
						stringInput=scIn.nextLine();
						Time.systemTime.setTime();
					}
					if(stringInput.equals("EXIT")){
						System.out.println("Exited Simulator");
						buffer.close();
						scIn.close();
						break;
					}
					else if(stringInput.equals("RESET")){
						ChronoInterface.chronoTimer=new ChronoInterface();
						ChronoInterface.chronoTimer.power.powerStatus=true;
				//		file= new FileWriter("Event Record.txt");
				//		buffer = new BufferedWriter(file);
					}
					else if(stringInput.equals("POWER")&&!ChronoInterface.chronoTimer.power.powerStatus){
						ChronoInterface.chronoTimer=new ChronoInterface();
						ChronoInterface.chronoTimer.power();
				}
					else 
						parse(stringInput);
				}catch(Exception e){
					System.out.println("Illegal Input");
					continue loop;
				}
			}
		}catch(FileNotFoundException e){
			System.out.println("Invalid Input File");
		}
	}
}