import java.util.Scanner;
import java.util.concurrent.Semaphore;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Assignment2 {
	
	public static void main(String[] args) {
		Scanner  keyboard = new Scanner (System.in);
		
		//get required inputs from customer
		System.out.print("How many tellers working?  ");
		int tellerCount = keyboard.nextInt();

		System.out.print("Averagetime between customer arrivals : ");
		int avgTimeofArrival = keyboard.nextInt();
			    
		System.out.print("Average service time  ");
		int avgServiceTime = keyboard.nextInt();
		
		
		//most businesses operate for 8 hours,   time will be simulated 
		int hrs = 8;
		
		Customer[] customers=null;
		Teller[] tellers = null;
	
		
	//	Semaphore executor = new Semaphore(tellerCount,true);
		ExecutorService executor = Executors.newFixedThreadPool(Constants.NUMBER_OF_Customers);
		
		try{
			
			tellers=new Teller[Constants.NUMBER_OF_Tellers];
			customers=new Customer[Constants.NUMBER_OF_Customers];
			
			
			for(int i=0;i<Constants.NUMBER_OF_Tellers;i++){
				tellers[i]=new Teller(i);
			}
			
			for(int i=0;i<Constants.NUMBER_OF_Customers;i++){
				customers[i]=new Customer(i,tellers);
				((Executor) executor).execute(customers[i]);
			}						
		}catch(Exception e){
			e.printStackTrace();
			( executor).shutdown();
		}finally{
			( executor).shutdown();
		}
	}
}