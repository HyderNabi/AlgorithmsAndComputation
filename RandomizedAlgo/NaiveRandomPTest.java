//TODO : Primality Testing using Random Numbers.
//Find a random number between the range (2 to square root of a number ) and divide the number with the random number and check the remainder:
// if the remainder is zero return false (number is not prime) else repeat the test for some random numbers
//Author : Hyder Nabi

package RandomizedAlgo;
import java.util.Random;
public class NaiveRandomPTest {
	public static boolean PTest(int n, Random random)
	{
		int large_t = 1;
		while(large_t<=500)
		{
			int i = (int)Math.floor(random.nextDouble() * Math.sqrt(n));
			
			if(i != 0 && i != 1 && i != n)
			{
				if(n%i == 0)
				{
					return false;
				}
			}
			large_t++;
		}
		return true;
	}

	public static void main(String[] args) {
		int n = 23;
		Random random = new Random();
		System.out.println(PTest(n,random));
		
		
		

	}

}
