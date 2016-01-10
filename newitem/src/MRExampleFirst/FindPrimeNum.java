package MRExampleFirst;

public class FindPrimeNum {
	
	public static void main(String args[])
	{
		int n=5;
		int num=3;
		int status=1;
		if(n>=1)
		{
			System.out.println(2 + ": is a prime number");
		}
		//loop as many times as prime numbers are to be printed
	      for(int count =2;count <=n;)
	      {
	    	  //check from 2 to square root of the number
	    	  for(int j=2;j<= Math.sqrt(num); j++)
	    	  {
	    		  if(num%j==0)
	    		  {
	    			  //System.out.println(num + ": is not a prime number");
	    			  status=0;
	    			  break;
	    		  }
	    		  
	    	  }
	    	  if(status==1)
	    	  {
	    	    System.out.println(num + ": is a prime number");
	    	    count++;
	    	  }
	    	  num++;
	    	  status=1;
	    	  
	      }
	}

}
