//TODO : Number Sum Problem(find no of ways given number N can be expressed the sum of given set of numbers) using dynamic programming (Top Down Memoization Approach)
//Author : Hyder Nabi
package DynamicProgramming;

public class NumberSumMemoization {
	public static int Numbers[];
	public static int dp[];
	public static int count = 0;
	public static int N_Sum(int N)
	{
		count++;
		if(N<0) {
			return 0;
		}else if(dp[N] !=-1)
		{
			return dp[N];
		}else if(N==0)
		{
			return 1;
		}else
		{
			int sum = 0;
			for(int i=0;i<Numbers.length;i++)
			{
				sum += N_Sum(N-Numbers[i]);
			}
			dp[N] = sum;
			return sum;
			
		}
	}
	public static void main(String args[])
	{
		Numbers = new int[] {1,3,4};
		int N = 5;
		dp = new int[N+1];
		for(int i=0;i<dp.length;i++)
		{
			dp[i] = -1;
		}
		System.out.println("The No of ways = "+N_Sum(N));
		System.out.println("Total no. of calls = "+count);
	}
}
