//TODO : Sum of Subsets Problem using backtracking
//Author : Hyder Nabi

package BackTracking;

public class SubsetSum {
	public static int W[];//Weights
	public static int S_Vector[];//x
	public static int m; // Given sum
	public static int n; //total no of instances
	public static int count;
	public static void SumOfSubsets(int k,int sum)
	{
		count++;
		if(sum + W[k] == m)
		{
			S_Vector[k] = 1;
			show(k);
		}else if(BoundingFunction(k))
		{
			S_Vector[k] = 1;
			SumOfSubsets(k+1,sum+W[k]);
		}
		if(BoundingFunction(k))
		{
			S_Vector[k] = 0;
			SumOfSubsets(k+1,sum);
		}
	}
	public static boolean BoundingFunction(int k)
	{
		int s = 0;
		int r = 0;
		for(int i=0;i<k;i++)
		{
			s += W[i] * S_Vector[i];
		}
		for(int i = k+1;i<n;i++)
		{
			r+=W[i];
		}
		if((s+r >= m) &&(s+W[k+1] <= m))
			return true;
		else
			return false;
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
		//W = new int[] {5,10,12,13,15,18};
	//	m = 30;
		W = new int[] {1,2,5,6,8};
		m = 9;
		n= W.length;
		S_Vector = new int[n];
		
		SumOfSubsets(0,0);//(k,sum)
		System.out.println("Total no of calls = "+count);

	}

}
