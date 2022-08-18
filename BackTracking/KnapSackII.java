
//TODO : Knapsack problem using Backtracking (Alternate way)
//Author : Hyder Nabi

package BackTracking;

public class KnapSackII {
	public static int P[],W[],X[],Y[];
	public static int n,m,FP=-1,FW=0;
	public static int count = 0;
	public static void BT_knap(int k,int p,int w)
	{
		count ++;
		if(w+W[k] <= m) {
			X[k] = 1;
			if(k<n-1) {
				BT_knap(k+1, p+P[k], w+W[k]);
			}
			if(k == n-1 && p+P[k] > FP)
			{
				FP = p+P[k];
				FW = w+W[k];
				for(int i=0;i<=k;k++)
				{
					//save state
					Y[i] = X[i];
				}
			}
		}
		
		if(bound(k,p,w)>=FP) {
			X[k] = 0;
			if(k<n-1) {
				BT_knap(k+1, p, w);
			}
			if(k == n-1 && p > FP)
			{
				FP = p;
				FW = w;
				for(int i=0;i<=k;i++)
				{
					//save state
					Y[i] = X[i];
				}
			}
		
	}
}
		
	
public static float bound(int k,int p,int w)
{
	int a = w;
	int b = p;
	for(int i=k+1;i<n;i++)
	{
		//a+=W[i];
		if(a+W[i]<m)
		{
			b+=P[i];
			a+=W[i];
		}else{
			return b + ((m-a) / W[i] )* P[i];
		}
	}
	return b;
}
	public static void main(String args[])
	{
		P = new int[] {14,9,6,3};
		W = new int[] {5,4,3,2};
		m = 8;
		n = 4;
		
		Y = new int[n];
		X = new int[n];
		
		
		BT_knap(0,0,0);
		
		for(int i=0;i<n;i++)
		{
			System.out.print(Y[i]);
		}
		System.out.println();
		System.out.println("Total Profit = "+FP);
		System.out.println("Total Weight = "+FW);
		System.out.println("Total calls = "+ count);
	}
}
