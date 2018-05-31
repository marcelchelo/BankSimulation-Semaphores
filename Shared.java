
public class Shared{
	public static int customerID =0;
	public static int totalCustomers=0;
	// Synchronized Method

	
	static synchronized int nextCustomerID() {
		int v = customerID;
		// Here, Missing module to handle the limit of customerLine
		customerID++;
		totalCustomers++;
		return v;
	}
	
}