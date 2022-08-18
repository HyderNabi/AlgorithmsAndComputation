//TODO : Sum of Subsets Problem using backtracking [Alternate way]
//Author : Hyder Nabi

package BackTracking;

public class SubsetSumIII {
	public static int W[];//Weights
	public static int S_Vector[];//x
	public static int m; // Given sum
	public static int n; //total no of instances
	public static int count;
	public static void SumOfSubsets(int sum,int k,int r)
	{
		count++;
		if(sum + W[k] == m)
		{
			S_Vector[k] = 1;
			show(k);
		}else if(k<n-1 && sum+W[k+1] <=m)
		{
			S_Vector[k] = 1;
			SumOfSubsets(sum+W[k],k+1,r-W[k]);
		}
		if(sum+r >= m && k<n-1 && sum+W[k+1] <= m)
		{
			S_Vector[k] = 0;
			SumOfSubsets(sum,k+1,r-W[k]);
		}
	}
	
	public static void show(int k)
	{
		for(int i=0;i<=k;i++)
		{
			System.out.print(S_Vector[i]);
		}
		System.out.println();
	}
	public static void main(String[] args) {
		W = new int[] {5,10,12,13,15,18};
		m = 30;
		n= W.length;
		S_Vector = new int[n];
		
		SumOfSubsets(0,0,73);//(sum,k,r)
		System.out.println("Total no of calls = "+count);

	}

}
