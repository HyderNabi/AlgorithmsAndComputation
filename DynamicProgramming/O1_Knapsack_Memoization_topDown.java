//TODO : 0/1 Knapsack using dynamic programming (Top Down Approach with Memoization )[method 1]
//Author : Hyder Nabi
package DynamicProgramming;

public class O1_Knapsack_Memoization_topDown {
	public static int w[];
	public static int p[];
	public static int dp[];
	public static int n;
	public static int count = 0;
	public static int Knapsack(int m,int index)
	{
		count++;
		if(m<0)
		{
			return Integer.MIN_VALUE;
		}else if(dp[m] != -1)
		{
			return dp[m];
		}
		else if(m == 0)
		{ 
			return 0;
			
		}else if(index == n)
		{
			return 0; 
		}
		else
		{
			int a,b;
			int i = index + 1;
				a = Knapsack(m, i);
				b = Knapsack(m-w[index],i) + p[index];
				dp[m] = max(a,b);
				return dp[m];
		}
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
		/*int m = 10;
		w = new int[] {1,3,4,5};
		p = new int[] {20,30,10,50};
		n = 4;
		
		w = new int[] {1,1,2,3,4,5,7};
		p = new int[] {3,6,10,5,18,15,7};
		n = 7;
		int m = 15;
		

		w = new int[] {18,15,10};
		p = new int[] {25,24,15};
		n = 3;
		int m = 20;
		*/
		w = new int[] {3,4,6,5};
		p = new int[] {2,3,1,4};
		n = 4;
		int m = 8;
		dp = new int[m+1];
		for(int i=0;i<dp.length;i++)
		{
			dp[i] = -1;
		}
		System.out.println(Knapsack(m,0));
		System.out.println(count);
		
		

	}

}
