//TODO : CHANGE COIN PROBLEM USING DYNAMIC PROGRAMMING [Top Down approach(Memoization) Method 3]
//Author : Hyder Nabi
package DynamicProgramming;
interface data{
	public final int inf = 10000;
}
public class CoinChange_topDownIII implements data {
	public static int coins[];
	public static int count = 0;
	public static int dp[];
	public static int minCoins(int n)
	{
		count ++;
		if(isEqual(n)) {
			return 1;
		}
		else
		{
			int temp[] = new int[coins.length];
			int result;
			for(int i=0;i<temp.length;i++)
			{
				if(n>=coins[i])
				{
					if(dp[n-coins[i]] != inf) {
						temp[i] = dp[n-coins[i]];
					}
					else {
						temp[i] = minCoins(n-coins[i]);
						dp[i] = temp[i];
					}
				}
				else
				{
					temp[i] = inf;
				}
				
			}
			result =  min(temp)+1;
			dp[n] = result;
			return result;
		}
	}
	public static int min(int a[]) {
		int m = a[0];
		for(int i:a) {
			if(i<m)
			{
				m = i;
			}
		}
		return m;
	}
	public static boolean isEqual(int n)
	{
		for(int i=0;i<coins.length;i++)
		{
			if(n == coins[i])
			{
				return true;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		coins = new int[]{1,5,7};
		//int n = 18;
		int n = 20;
		dp = new int[n+1];
		for(int i=0;i<dp.length;i++)
		{
			dp[i] = inf;
		}
		System.out.println("The min no of coins required = "+minCoins(n));
		System.out.println("The no of recursive calls = " +count);
		
	}

}
