package DivideAndConquer;
//TODO : Quick Sort Algorithm
//Author : Hyder Nabi
public class QuickSort {
	public static int r[];
	
	public static void Quick_Sort(int low , int high)
	{
		if(low < high)
		{
			int j = HoarePartition(low,high);
			Quick_Sort(low,j);
			Quick_Sort(j+1,high);
		}
	}
	public static int  HoarePartition(int low, int high)
	{
		int pivot = r[low];
		int i = low;
		int j = high;
		while(i<j)
		{
			do {
				i++;
			}while(i<high && r[i]<pivot);
			do {
				j--;
			}while(j>low && r[j]>pivot);
			if(i<j)
			{
				swap(i,j);
			}
		}
		swap(low,j);
		return j;
		
	}
	public static void swap(int i,int j)
	{
		int temp = r[i];
		r[i] = r[j];
		r[j] = temp;
	}
	public static void main(String[] args) {
		r = new int[] {2,5,3,0,9,12,34,-9,-87};
		Quick_Sort(0, r.length);
		
	}

}
