package DynamicProgramming;
//TODO : Floyd Warshall Algorithm using Dynamic Programming
//Author : Hyder Nabi

interface data{
	public final int inf = 100000;
}
class FloydWarshall implements data{
	public int A[][];
	public int n;
	public FloydWarshall(int n,int cost[][]) {
		this.n = n;
		A = new int[this.n][this.n];
		for(int i=0;i<cost.length;i++)
		{
			for(int j=0;j<cost.length;j++)
			{
				A[i][j] = cost[i][j]; 
			}
		}
	}
	public void All_Paths()
	{
		for(int k=0;k<n;k++)
		{
			for(int i=0;i<n;i++)
			{
				for(int j=0;j<n;j++)
				{
					if(i!=k && j!=k && i!=j)
						A[i][j] = min(A[i][j],A[i][k]+A[k][j]);
				}
			}
		}
	}
	public void Show()
	{
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				System.out.print(A[i][j]+" ");
			}
			System.out.println();
		}
	}
	public int min(int a, int b)
	{
		if(a<b)
			return a;
		else
			return b;
	}
}
public class FloydWarshallAlgo implements data{

	public static void main(String[] args) {
	/*	int cost[][] = {
				{0,3,inf,7},
				{8,0,2,inf},
				{5,inf,0,1},f
				{2,inf,inf,0}
		};*/
		int cost[][] = {
				{0,4,11},
				{6,0,2},
				{3,inf,0}
		};
		FloydWarshall fw = new FloydWarshall(cost.length, cost);
		fw.All_Paths();
		fw.Show();
	}

}
