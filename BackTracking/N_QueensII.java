//TODO : N_Queens problem using backtracking(Alternate way)
//Author : Hyder Nabi
package BackTracking;

public class N_QueensII {
	public static int n; //Problem Size
	public static int x[]; //Solution Vector
	
	public static void NQueens(int i)	
	{
		
			for(int j =0;j<n;j++)
			{
				if(Place(i,j))
				{
					x[i] = j;
					if(i==n-1)
					{
						print();
					}else {
						NQueens(i+1);
					}
					
				}
			}
		
	}
	public static boolean Place(int i, int j)
	{
		for(int a=0;a<i;a++)
		{
			int p,q,r,s;
			p = a;
			q = x[a];
			r = i;
			s = j;
			
			if(x[a] == j || ((p-q)==(r-s)) || ((p+q) == (r+s)))
			{
				return false;
			}
		}
		return true;
	}
	public static void print(){
		for(int i=0;i<n;i++)
		{
			System.out.print(x[i]+"  ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		n = 4;
		x = new int[n];
		NQueens(0);
	}

}
