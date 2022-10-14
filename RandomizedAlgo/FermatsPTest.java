//TODO : PRIMALITY TESTING USING FERMATS LITTLE THEOREM
//Author : Hyder Nabi

package RandomizedAlgo;
class FermatsPrimalityTest{
	public FermatsPrimalityTest() {}
	//calculate GCD 
	private long gcd(long a, long b)
	{
		if(b == 0)
			return a;
		else
			return gcd(b,a%b);
	}
	
	public boolean PTest(long n)
	{
		int counter = 0;
		while(true)
		{
			long max = n-2;
			long min = 2;
			long a = (int)Math.floor(Math.random()*(max-min+1)+min); //generate a random number between 2 and n-2
			
			if(gcd(a,n) != 1) //check if a and n are co primes
			{
				return false;  //return non prime
			}
			long b= power(a,n-1,n);  //calculate a^(n-1)%n == 1
			if(b != 1)
			{
				return false; //return non prime
			}
			
			counter++;
			if(counter>10) //Threshold for no of iterations
			{
				break;
			}
		}
		return true; //return probable prime
	}
	
	//calculate a^(n-1)%n iteratively
	private long power(long a,long n, long p)
    {
        // Initialize result
        long res = 1;
         
        // Update 'a' if 'a' >= p
        a = a % p;
     
        while (n > 0)
        {
            // If n is odd, multiply 'a' with result
            if ((n & 1) == 1)
                res = (res * a) % p;
     
            // n must be even now
            n = n >> 1; // n = n/2
            a = (a * a) % p;
        }
        return res;
    }
}

public class FermatsPTest {
	
	
	public static void main(String[] args) {
		FermatsPrimalityTest o = new FermatsPrimalityTest();
		if(o.PTest(17)) {
			System.out.println("Yes");
		}else {
			System.out.println("no");
		}
		
		
	}

}
