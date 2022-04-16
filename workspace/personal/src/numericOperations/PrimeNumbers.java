package numericOperations;

import java.util.ArrayList;

public class PrimeNumbers {

	public String Calculate() {
		ArrayList<Integer> primeNumberList = new ArrayList<Integer>();
		for(int i = 1;i<=100;i++) {
			if(i == 2 || i == 3 || i == 5 || i == 7) {
				primeNumberList.add(i);
			}
			else if(i%2 != 0 && i%3 != 0 && i%5 != 0 && i%7 != 0) {
			primeNumberList.add(i);
		}}
		primeNumberList.remove(0);
		String result = primeNumberList.toString();
		return result.substring(1, result.length()-1);
	}

	public static void main(String[] args) {

		PrimeNumbers pri = new PrimeNumbers();
		System.out.print("The prime numbers between 1 and 100 are: "
				+ "\n"+pri.Calculate()+".");
	}

}
