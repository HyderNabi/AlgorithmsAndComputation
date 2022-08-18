package DivideAndConquer;
//TODO : Recursive MaxMin Algorithm
//Author : Hyder Nabi
class Result
{
	int min,max;
}
public class MaxMin {
	public static int arr[];
	
	public static void Max_Min(int i,int j,Result result)
	{
		if(i == j)
		{
			result.max = arr[i];
			result.min = arr[j];
		}else if(i == j-1)
		{
			if(arr[i]<arr[j])
			{
				result.min = arr[i];
				result.max = arr[j];
			}else
			{
				result.min = arr[j];
				result.max = arr[i];
			}
		}
		else
		{
			int mid = (i + j) / 2;
			
			Result result1 = new Result();
			Max_Min(i, mid,result);
			Max_Min(mid+1,j,result1);
			
			if(result.max < result1.max){ result.max = result1.max;}
			if(result.min>result1.min) {result.min = result1.min;}
		}
	}
	public static void main(String[] args) {
		arr = new int[] {4,6,9,1,0,-2,45,78,90,-56,100,67,456,-78,321,-490};
		Result result = new Result();
		Max_Min(0,arr.length-1,result);
		
		System.out.println("Max = "+ result.max +" Min = "+ result.min);
		
		

	}

}
