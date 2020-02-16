
public class Customer {
	
private int arrivalTime;
private int transactionTime;
private int customerNumber;

public  Customer(int clock, int transactionTime, int numberOfArrivals) {
	arrivalTime = clock;
	this.transactionTime = transactionTime;
	this.customerNumber = customerNumber;
	
}

public int getArrivalTime() {
	return arrivalTime;
}

public int getTransactionTime() {
	return transactionTime;
}

public int getCustomerNumber() {
	return customerNumber;
}

}
