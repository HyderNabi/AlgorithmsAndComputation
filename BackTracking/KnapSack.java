//TODO : Knapsack problem using Backtracking
//Author : Hyder Nabi

package BackTracking;
public class KnapSack {
	public static int X[],Y[],W[],P[],m,n;
	public static int count = 0;
	
	public static int fp = -1;
	public static int fw = 0;
	public static void BNap(int k,int p,int w)
	{
		count ++;
		//Generate Left Child
		if(w+W[k] <= m)
		{
			X[k] = 1;
			if(k<n-1)
			{
				BNap(k+1,p+P[k],w+W[k]);
			}
			if(p+P[k]>fp && k==n-1)
			{
				fp = p+P[k];
				fw = w+W[k];
				for(int i=0;i<=k;i++)
				{
					Y[k] = X[k];
				}
			}
		}
		
		//Generate Right Child
		if(bound(k,p,w)>=fp)
		{
			X[k] = 0;
			if(k<n-1)
			{
				BNap(k+1, p, w);
			}
			if(p>fp && k==n-1)
			{
				fp = p;
				fw = w;
				for(int i=0;i<=k;i++)
				{
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
			a+=W[i];
			if(a<m)
			{
				b+=P[i];
			}else{
				return b+(1-(a-m)/W[i]) * P[i];
			}
		}
		return b;
	}
	public static void main(String[] args) {
		n = 4;
		m = 8;
		X = new int[n];
		Y = new int[n];
		W = new int[]{5,4,3,2};
		P = new int[] {14,9,6,3};
		BNap(0,0,0);
		
		for(int i=0;i<n;i++)
		{
			System.out.print(Y[i]);
		}
		System.out.println();
		System.out.println("Total Profit = "+fp);
		System.out.println("Total Weight = "+fw);
		System.out.println("Total calls = "+ count);
	}

}
