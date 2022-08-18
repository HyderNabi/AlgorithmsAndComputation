package DynamicProgramming;
//TODO : Traveling Salesperson Problem using Dynamic Programming [Memoization]
//Author : Hyder Nabi
public class TSP_Memoization {
	public static int cost[][];
	public static int n;
	public static int initial = 0;
	public static int count=0;
	public static int TSP_DP(int i,int[] S)
	{
		count++;
		if(S.length == 0)
		{
			return cost[i][initial];
		}
		else
		{
			int temp[] = new int[S.length];
			int result;
			for(int k=0;k<S.length;k++)
			{
				int new_S[] = make_S(S,k);
				temp[k] = TSP_DP(S[k],new_S) + cost[i][S[k]];
			}
			result = min(temp);
			
			return result;
		}
	}
	public static int min(int arr[])
	{
		int min;
		if(arr.length == 1)
		{
			min = arr[0];
			
		}
		else
		{
			min = arr[0];
			for(int i=0;i<arr.length;i++)
			{
				if(arr[i]<min)
				{
					min = arr[i];
				}
			}
		}
		return min;
	}
	public static int[] make_S(int S[],int k)
	{
		if(S.length == 1)
		{
			return new int[0];
		}
		int tempS[] = new int[S.length-1];
		System.arraycopy(S, 0, tempS, 0, k);
		System.arraycopy(S, k+1, tempS, k, S.length-k-1);
		return tempS;
		 
	}
	public static void main(String[] args) {
		int i = initial;
		int S[] = {1,2,3};
		n = 4;
		cost = new int[][]
		{
			{0,10,15,20},
			{5,0,9,10},
			{6,13,0,12},
			{8,8,9,0}
		}; 
		System.out.println("The Minimun cost of the path = "+TSP_DP(i,S));
		System.out.println("The Number of calls = "+count);
		//System.out.println(path);

	}

}
