//TODO : CHANGE COIN PROBLEM USING DYNAMIC PROGRAMMING [Top Down approach(recursive) Method 2]
//Author : Hyder Nabi
package DynamicProgramming;
interface dataII{
	public final int inf = 10000;
}
public class CoinChange_Simple_II implements dataII{
	public static int coins[];
	public static int count = 0;
	public static int minCoins(int n)
	{
		count++;
		if(n == 0)
		{
			return 0;
		}else {
			int temp[] = new int[coins.length];
			for(int i=0;i<temp.length;i++)
			{
				if(n>=coins[i])
					temp[i] = minCoins(n-coins[i]);
				else
					temp[i] = inf;
			}
			
			return min(temp) + 1;
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
		coins = new int[]{1,5,7};
		int n = 20;
		System.out.println("The min no of coins required = "+minCoins(n));
		System.out.println("The no of recursive calls = " +count);
	}
}
