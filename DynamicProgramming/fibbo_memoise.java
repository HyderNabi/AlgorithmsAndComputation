//TODO : nth Fibbonacci number using Dynamic Programming (recursive (Memoization) approach)
//Author : Hyder Nabi
//Top down Approach
package DynamicProgramming;
public class fibbo_memoise {
	public static int arr[];
	public static int count = 0;
	public static int fibbo(int n)
	{
		//System.out.println(n);
		count ++;
		/*if(arr[n] != -1){
			return arr[n];
		}else */
		if(n == 0){
				arr[n] = 0;
				return 0;
		}else if(n == 1) {
			arr[n] = 1;
			return 1;
		}
		else {
			int a,b;
			if(arr[n-2] != -1)
			{
				a = arr[n-2];
			}else
			{
				a= fibbo(n-2);
			}
			if(arr[n-1] != -1)
			{
				b = arr[n-1];
			}else
			{
				b = fibbo(n-1);
			}
			int result = a+b;
			//int result =  fibbo(n-2) + fibbo(n-1);
			arr[n] = result;
			return result;
		}
		
	}
	public static void main(String[] args) {
		int n = 5;
		arr = new int[n+1];
		for(int i = 0;i<=n;i++)
		{	arr[i] = -1; }
		System.out.println(fibbo(n));
		System.out.println("No of calls = " + count);
		

	}

}
