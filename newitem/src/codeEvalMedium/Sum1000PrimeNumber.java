package codeEvalMedium;

import java.util.*;

public class Sum1000PrimeNumber {
	public static void main(String[] args)
	{
		System.out.println("Enter a number to get sum of first those many prime numbers");
		//Scanner sc = new Scanner(System.in);
		//int n= Integer.parseInt(sc.nextLine());
		int n=1000;
		int num=3;
		boolean flagPrime=true;
		ArrayList<Integer> listOfPrimes = new ArrayList<Integer>();
		listOfPrimes.add(2);
		//repeat to get n prime numbers
		while(listOfPrimes.size()<n)
		{
			//get one prime number
			for(int j=2;j<=Math.sqrt(num);j++)
			{
				//not prime
				if(num%j==0)
				{
					flagPrime=false;
					break;
				}
					
			}
			if(flagPrime==true)
			{
				listOfPrimes.add(num);
			}
			num++;
			flagPrime=true;
		}
		long sumOfPrimes=0;
		for(int i:listOfPrimes)
		{
			sumOfPrimes += i;
		}
		//System.out.println(listOfPrimes);
		System.out.println("Sum of " + n + "Prime numbers =" + sumOfPrimes);
	}
}
