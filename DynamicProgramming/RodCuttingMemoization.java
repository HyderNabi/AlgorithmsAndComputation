//TODO : Rod Cutting Problem dynamic programming ( Top Down Approach with memoizaton)
//Cutting the rod with given length L into pieces and finding out which combination of pieces gives the best price.
//Author : Hyder Nabi

package DynamicProgramming;

public class RodCuttingMemoization {
	public static int length[];
	public static int price[];
	public static int dp[];
	public static int count;
	public static int RodCut(int L)
	{
		count++;
		if(dp[L]!=-1) {
			return dp[L];
		}else if(L==0) {
			return 0;
		}else {
			int tempArr[] = new int[L];
			for(int i=0;i<tempArr.length;i++) {
				tempArr[i] = RodCut(L-length[i])+price[i]; 
			}
			dp[L] = max(tempArr);
			return dp[L];
		}
	}
	public static int max(int arr[])
	{
		int max = arr[0];
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]>max)
			{
				max = arr[i];
			}
		}
		return max;
	}
	public static void main(String[] args) {
		int L = 10;
		length = new int[]{1,2,3,4,5,6,7,8,9,10};
		price = new int[]{1,5,8,9,10,17,17,20,24,30};
		dp = new int[L+1];
		for(int i=0;i<dp.length;i++)
		{
			dp[i] = -1;
		}
		System.out.println("The optimal cost = "+RodCut(L));
		System.out.println("Total no. of calls = "+count);
	}

}
