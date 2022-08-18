//TODO : Checking whether a number is prime or not
//Author : Hyder Nabi


package RandomizedAlgo;

public class PrimeNumberTesting {

	public static void main(String[] args) {
		int num = 7;
		int i;
		for(i=2;i<Math.floor(Math.sqrt(num));i++)
		{
			if(num % i == 0)
			{
				break;
			}
		}
		if(i == Math.floor(Math.sqrt(num)))
		{
			System.out.println(num +" is prime");
		}else {
			System.out.println(num +" isn't prime");
		}
	}

}
