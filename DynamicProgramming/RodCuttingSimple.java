//TODO : Rod Cutting Problem using Recursion.
//Cutting the rod with given length L into pieces and finding out which combination of pieces gives the best price.
//Author : Hyder Nabi
package DynamicProgramming;

public class RodCuttingSimple {
	public static int length[];
	public static int price[];
	public static int count;
	public static int RodCut(int L)
	{
		count++;
		if(L==0) {
			return 0;
		}else {
			int tempArr[] = new int[L];
			for(int i=0;i<tempArr.length;i++) {
				tempArr[i] = RodCut(L-length[i])+price[i]; 
			}
			return max(tempArr);
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
		System.out.println("The optimal cost = "+RodCut(L));
		System.out.println("Total no. of calls = "+count);
	}

}
