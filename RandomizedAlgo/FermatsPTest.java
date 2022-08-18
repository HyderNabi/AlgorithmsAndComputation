//TODO : PRIMALITY TESTING USING FERMATS LITTLE THEOREM
//Author : Hyder Nabi

package RandomizedAlgo;

public class FermatsPTest {
	static int n ;
	
	public static int gcd(int a, int b)
	{
		if(b == 0)
			return a;
		else
			return gcd(b,a%b);
	}
	
	public static boolean PTest()
	{
		int counter = 0;
		while(true)
		{
			int max = n-2;
			int min = 2;
			int a = (int)Math.floor(Math.random()*(max-min+1)+min);
			
			if(gcd(a,n) != 1)
			{
				return false;
			}
			long b = (long)Math.pow(a,(n-1));
			b = b % n;
			if(b != 1)
			{
				return false;
			}
			counter++;
			if(counter>10)
			{
				break;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		n = 91;
		if(PTest() == true)
		{
			System.out.println("Prime !");
		}else{
			System.out.println("Not Prime !");
		}
	}

}
