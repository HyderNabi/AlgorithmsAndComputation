//TODO : nth Fibbonacci number using Dynamic Programming (recursive (top down appraoch))
//Author : Hyder Nabi
package DynamicProgramming;

public class fibbo_Simple {
	public static int count = 0;
	public static  int fib(int n)
	{
		count++;
		if(n == 0)
			return 0;
		else if(n==1)
			return 1;
		else
			return fib(n-2)+fib(n-1);
			
	}
	public static void main(String args[])
	{
		System.out.println(fib(40));
		System.out.println("No of calls = " + count);
		
	}
}
