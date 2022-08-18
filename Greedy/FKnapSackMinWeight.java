//TODO : Fractional Knapsack using Greedy Approach (item selection criteria is "Select item with Minimum Weight First")
//Author : Hyder Nabi
package Greedy;

public class FKnapSackMinWeight {
	public static double p[];
	public static double w[];
	public static double X[];
	public static int n;
	public static int capacity;
	public static void Quick_Sort(int low , int high)
	{
		if(low < high)
		{
			int j = HoarePartition(low,high);
			Quick_Sort(low,j);
			Quick_Sort(j+1,high);
		}
	}
	public static int HoarePartition(int low, int high)
	{
		double pivot = w[low];
		int i = low;
		int j = high;
		while(i<j)
		{
			do {
				i++;
			}while(i<high && w[i]<=pivot);
			do {
				j--;
			}while(j>low && w[j]>=pivot);
			if(i<j)
			{
				swap(i,j,w);
				swap(i,j,p);
			}
		}
		swap(low,j,w);
		swap(low,j,p);
		return j;
		
	}
	public static void swap(int i,int j,double arr[])
	{
		double temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	
	public static double KnapSack()
	{
		//Remaining Capacity
		int R_Capacity = capacity;
		double profit = 0;
		int i=0;
		while(i<n)
		{
			if(R_Capacity-w[i]>=0)
			{
				profit += p[i];
				R_Capacity -= w[i];
				X[i] = 1;
			}else { break;}
			i++;
		}
		if(i<n)
		{
			profit += (R_Capacity / w[i]) * p[i];
			X[i] = R_Capacity / w[i];
		}
		
		return profit;
	}
	
	public static void main(String[] args) {
		p = new double[] {5,10,15,7,8,9,4};
		w = new double[] {1,3,5,4,1,3,2};
		n = 7;
		capacity = 15;
		
		//p = new double[] {30,40,45,77,90};
		//w = new double[] {5,10,15,22,25};
		//n = 5;
		//capacity = 60;
		
		X = new double[n];
		for(int i = 0;i<n;i++)
		{
			X[i] = 0;
		}
		Quick_Sort(0, w.length);
		System.out.println("The Total Profit = "+KnapSack());
		for(int i = 0;i<n ;i++)
		{
			System.out.print(X[i]+" ");
		}
		
	}

}
