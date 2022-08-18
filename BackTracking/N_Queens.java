//TODO : N_Queens problem using backtracking
//Author : Hyder Nabi

package BackTracking;

public class N_Queens {
	public static int S_Vector[];
	public static int N;
	public static int c = 0;
	public static void N_Queen(int k,int n)
	{
		c++;
		for(int a=0;a<N;a++)
		{
			if(can_Placed(n,a))
			{
				S_Vector[n] = a;
				
				if(n != N-1) {
					N_Queen(k+1,n+1);
				}
				if(n == N-1)
				{
					show();
				}
						
			}
		}
		
	}
	public static boolean can_Placed(int n, int a)
	{
		/** returns true if a queen can be placed in the nth row and ath column
		 * Otherwise it returns false
		 * **/
		
		
		int z=0;
		boolean test1 = true;
		boolean test2 = true;
		for(z=0;z<n;z++) {
			if(S_Vector[z] == a)//two queens in same column
			{
				test1 = false;
				break;
			}
		}
		
		if(test1 == true)
		{
			int i,j,k,l;
			k = n;
			l = a;
			
			int p=0;
			for(p=0;p<n;p++)
			{
				i = p;
				j = S_Vector[p];
				Integer Q1 = Math.abs(j-l);
				Integer Q2 = Math.abs(i-k);
				if(Q1.equals(Q2))//two queens in same diagonal
				{
					test2 = false;
					break;
				}
			}
			
			if(test2 == true)
			{
				return true;
			}else
			{
				return false;
			}
			
		}else
		{
			return false;
		}
		
		
	}
	public static void show()
	{
		for(int i=0;i<N;i++)
		{
			System.out.print(S_Vector[i]);
		}
		System.out.println();
	}
	public static void main(String args[])
	{
		N = 8;
		//row no
		int n = 0;
		S_Vector = new int[N];
		for(int i=0;i<N;i++)
		{
			S_Vector[i] = 0;
		}
		N_Queen(0,n);
		
		System.out.println("Total No of Recursive Calls = " +c);
		
	}
}
