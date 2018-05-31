
import java.util.Random;

public class Customer implements Runnable {

	private int id =0;
	private Teller[] teller;
	public int meanTime = 0;
	public Customer(int id, Teller[] teller) {
		this.teller = teller;
		this.id = id;
	}

	@Override
	public void run() {
		Time.start();
		while (true) {
			long time = Time.getTime();
			
			try {
				int id = Shared.nextCustomerID();
				//teller service this customer
				teller[id].service(this, time);
				this.id++;
				//sleep for a random amount of time 
				int sleepTime =(1000 * Random_Int_Mean.random_int(3));
				Thread.sleep(sleepTime);
				System.out.println( this + " was service for" + sleepTime/1000 +" Seconds" );
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public String toString() {
		return "Customer" + id;
	}
}
