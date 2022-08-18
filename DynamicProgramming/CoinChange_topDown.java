//TODO : CHANGE COIN PROBLEM USING DYNAMIC PROGRAMMING [Top Down approach(memoization) Method 1]
//Author : Hyder Nabi
package DynamicProgramming;
interface dataII{
	public final int inf = 10000;
}
public class CoinChange_topDown implements dataII{
	public static int coins[];
	public static int dp[];
	public static int count = 0;
	public static int minCoins(int n)
	{
		count++;
		if(dp[n] != inf)
		{
			return dp[n];
		}else if(n == 0)
		{
			dp[n] = 0;
			return 0;
		}else {
			int temp[] = new int[coins.length];
			int result;
			for(int i=0;i<temp.length;i++)
			{
				if(n>=coins[i])
					temp[i] = minCoins(n-coins[i]);
				else
					temp[i] = inf;
			}
			
			result =  min(temp) + 1;
			dp[n] = result;
			return result;
		}
	}
	public static int min(int a[])
	{
		int m = a[0];
		for(int i:a)
		{
			if(i<m)
				m=i;
		}
		return m;
	}
	public static void main(String args[]) {
		int n = 20;
		coins = new int[]{1,5,7};
		dp = new int[n+1];
		for(int i=0;i<dp.length;i++)
		{
			dp[i] = inf;
		}
		System.out.println("The min no of coins required = "+minCoins(n));
		System.out.println("The no of recursive calls = " +count);
	}
}
