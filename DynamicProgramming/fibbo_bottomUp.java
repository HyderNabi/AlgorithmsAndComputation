//TODO : find nth fibonacci number using dynamic programming (bottom up approach (tabulation))
//Author : Hyder Nabi


package DynamicProgramming;

public class fibbo_bottomUp {
	public static int arr[];
	public static int fibbo(int n)
	{
		if(n<=1)
		{
			return n;
		}
		else {
			arr[0] = 0;
			arr[1] = 1;
			for(int i=2;i<=n;i++)
			{
				arr[i] = arr[i-2] + arr[i-1];
			}
		}
		return arr[n];
			
	}

	public static void main(String[] args) {
		int n = 40;
		arr = new int[n+1];
		System.out.println(fibbo(n));
	}

}
