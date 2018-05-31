import java.util.Timer;
import java.util.TimerTask;

public  class Time {
	
public static long secondspassed =0 ;


static Timer timer = new Timer();
static TimerTask task = new TimerTask () {
	
	public void run( ){
		secondspassed ++;
		//System.out.println(secondspassed);
	}
};


public static void start (){
	
	timer.scheduleAtFixedRate(task, 1000, 100) ;
	
}

//make class to wait 
//public  static void wait (int delay){
	//timer.schedule(task, delay *100);
//	secondspassed = secondspassed + (delay *100);
//}

public static void printTime (){
	System.out.println("The current time is " + getTime());
}

public static  long getTime (){
	
	return secondspassed;
}
}