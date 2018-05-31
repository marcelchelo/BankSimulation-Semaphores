

public class Constants {
	//fields
	public static int tellerCount = (Integer) null ;
	public static int meanArrTime =(Integer) null;
	public static int meanwaitTime =(Integer) null;
	
	private Constants(int x, int y , int z){
		totalTellers(x);
		this.meanArrTime = y ;
		this.meanwaitTime =z;
	
		
	}
	public void totalTellers (int x ){
		this.tellerCount= (x*2);
	}
	
	
	public static final int NUMBER_OF_Customers = 20;
	public static final int NUMBER_OF_Tellers = 50;
}
