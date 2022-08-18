//TODO : CHANGE COIN PROBLEM USING DYNAMIC PROGRAMMING [Bottom up approach (Tabulation)]
//Author : Hyder Nabi

package DynamicProgramming;
interface dataII{
	public final int inf = 10000;
}
public class CoinChange_bottomUp implements dataII {
	public static int coins[];
	public static int dp[];
	public static int minCoins(int n)
	{
		if(n == 0 || n == 1)
		{
			return 1;
		}
		else
		{
			dp[0] = 0;
			dp[1] = 1;
			for(int i=2;i<=n;i++) {
				int temp[] = new int[coins.length];
				int result; 
				for(int j=0;j<temp.length;j++)
				{
					if(i>=coins[j])
						temp[j] = dp[i-coins[j]];
					else
						temp[j] = inf;
					
				}
				dp[i] = min(temp) + 1;
			}
			return dp[n];
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
	
	public static void main(String[] args) {	
		coins = new int[]{1,5,7};
		int n = 7;
		dp = new int[n+1];
		System.out.println("The min no of coins required = "+minCoins(n));
		
	}

}
