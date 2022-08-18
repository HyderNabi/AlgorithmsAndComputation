//TODO : Find the path from initial stage to the final stage in MultiStage Graph using dynamic Programming
//Author : Hyder Nabi 

package DynamicProgramming;

public class MultiStageGraphs {
	public static int adjacencyCost[][];
	public static int n;
	public static int stages;
	public static int cost[];
	public static int path[];
	
	public static int Multi_Stage_Proc()
	{
		cost[n-1] = 0;
		path[n-1] = 0;
		
		for(int i=n-2;i>=0;i--)
		{
			cost[i] = Integer.MAX_VALUE;
			for(int j=i;j<n;j++)
			{
				if(adjacencyCost[i][j] != 0)
				{
					if(adjacencyCost[i][j]+cost[j]<cost[i])
					{
						cost[i] = adjacencyCost[i][j]+cost[j];
						path[i] = j;
					}
					//cost[i] = Math.min(cost[i], adjacencyCost[i][j]+cost[j]);
				}
				
			}
			
			
		}
		return cost[0];
	}
	
	public static void main(String[] args) {
		n = 10;
		stages = 5;
		adjacencyCost = new int[][] {
			{0,2,1,5,0,0,0,0,0,0},
			{0,0,0,0,2,0,3,0,0,0},
			{0,0,0,0,3,2,2,0,0,0},
			{0,0,0,0,1,7,4,0,0,0},
			{0,0,0,0,0,0,0,6,1,0},
			{0,0,0,0,0,0,0,2,8,0},
			{0,0,0,0,0,0,0,2,0,0},
			{0,0,0,0,0,0,0,0,0,2},
			{0,0,0,0,0,0,0,0,0,2},
			{0,0,0,0,0,0,0,0,0,0}
		};
		cost = new int[n];
		path = new int[n];
		System.out.println("Total Cost = " + Multi_Stage_Proc());
		System.out.println("THE PATH IS: ");
		for(int a =0,i=1;i<stages;i++)
		{
			a = path[a];
			System.out.print((a+1)+" ");
		}
	}

}
