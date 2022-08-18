//TODO : 0/1 Knapsack using dynamic programming (bottom up approach (tabulation))
//Author : Hyder Nabi
package DynamicProgramming;

public class O1_Knapsack_bottomUp {
	public static int w[];
	public static int p[];
	public static int dp[][];
	public static int n;
	public static int Knapsack(int m)
	{
		if(m == 0)
		{
			return 0;
		}
		for(int i=1;i<=n;i++)
		{
			//i = row
			for(int j=1;j<=m;j++)
			{
				//j = column ------ weight(m)
				if(j-w[i]<0)
				{
					dp[i][j] = max(dp[i-1][j],Integer.MIN_VALUE + p[i]);
				}else
				{
					dp[i][j] = max(dp[i-1][j] , dp[i-1][j-w[i]] + p[i]);
				}
			}
				
		}
		return dp[n][m];
	}
	public static int max(int a,int b)
	{
		if(a<=b)
		{
			return b;
		}else {
			return a;
		}
	}
	public static void main(String[] args) {
		int m = 10;
		w = new int[] {0,1,3,4,5};
		p = new int[] {0,20,30,10,50};
		n = 4;
		/*
		w = new int[] {0,1,1,2,3,4,5,7};
		p = new int[] {0,3,6,10,5,18,15,7};
		n = 7;
		int m = 15;
		
		w = new int[] {0,18,15,10};
		p = new int[] {0,25,24,15};
		n = 3;
		int m = 20;
		
		
		w = new int[] {0,3,4,6,5};
		p = new int[] {0,2,3,1,4};
		n = 4;
		int m = 8;
		*/
		dp = new int[n+1][m+1];
		for(int i=0;i<n+1;i++)
		{
			for(int j=0;j<m+1;j++)
			{
				dp[i][j] = 0;
			}
		}
		System.out.println(Knapsack(m));
		
		for(int i=0;i<n+1;i++)
		{
			for(int j=0;j<m+1;j++)
			{
				System.out.print(dp[i][j]+"\t");
				
			}
			System.out.println();
		}
		
		

	}

}
