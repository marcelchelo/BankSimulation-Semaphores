

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Teller {

	private int id;
	private Lock lock;

	public Teller(int id) {
		this.lock = new ReentrantLock();
		this.id = id;
	}
	
	public void service(Customer customer, long time) throws InterruptedException {
		lock.tryLock(10, TimeUnit.MINUTES);
		int servieTime =(1000 * Random_Int_Mean.random_int(7));
		System.out.println(customer + " starts being serviced by a teller @ time  " + time );
		
		Thread.sleep(servieTime);
		
		lock.unlock();
		System.out.println(customer + " has finished being serviced");
	}

	public String toString() {
		return "Teller " + id;
	}

}