package DivideAndConquer;
////TODO : Exponential Search Algorithm
//Author : Hyder Nabi
public class ExponentialSearch {
	public static int[] arr;
	public static int BSearch(int beg,int end,int key)
	{
	   if(beg==end) {
		   if(arr[beg] == key) {
			   return beg;
		   }else
		   {
			   return -1;
		   }
	   }else {
		int mid = (beg + end) / 2;
		if(arr[mid] == key)
		{
			return mid;
		}else if(key > arr[mid])
		{
			beg = mid + 1;
			return BSearch(beg, end, key);
		}else
		{
			end = mid - 1;
			return BSearch(beg, end, key);
		}
	   }
	}
	
	public static int ESearch(int length,int key)
	{
		if(length == 0)
		{
			return -1;
		}else
		{
			int LB = 0; // initially set to 0
			int UB = 2 ^ 0; //UB = (2 ^ k); where 0<=k<=n
			while(UB<=length && arr[UB]<key)
			{
				LB = UB;
				UB*=2;
			}
			UB = min(UB,length);
			return BSearch(LB,UB,key);
		}
	}
	public static int min(int a, int b)
	{
		if (a<b)
		{
			return a;
		}else {
			return b;
		}
	}
	public static void main(String[] args) {
		arr = new int[] {2,4,9,14,16,19,24,29,37,39,50,56,59,67};
		int n = arr.length;
		int key = 2;
		int result = ESearch(n-1,key);
		if(result == -1)
		{
			System.out.println("The Element is not Found !!!");
		}else
		{
			System.out.println("The Element is Found at index = "+result);
		}

	}

}
