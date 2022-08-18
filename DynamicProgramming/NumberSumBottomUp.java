//TODO : Number Sum Problem(find no of ways given number N can be expressed the sum of given set of numbers) using dynamic programming (bottom up approach (tabulation))
//Author : Hyder Nabi


package DynamicProgramming;

public class NumberSumBottomUp {
	public static int Numbers[];
	public static int dp[];

	public static int N_Sum(int N)
	{
		if(N==0)
		{
			return 0;
		}else
		{
			dp[0] = 1;
			for(int i=1;i<dp.length;i++)
			{
				int sum = 0;
				for(int j=0;j<Numbers.length;j++)
				{
					if(i-Numbers[j]>=0)
						sum += dp[i-Numbers[j]];
				}
				
				dp[i] = sum;
			}
		
			
			return dp[N];
			
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
	}
}