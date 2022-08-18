//TODO : Job Sequencing with deadlines using greedy approach
//Author : Hyder Nabi
package Greedy;

public class JobSequencing {
	public static int profit[];//profit
	public static int deadline[];//deadline
	public static int slot[];//slots
	public static int J[];//solution vector
	public static int n;//no of jobs
	
	public static void SequenceIt()
	{
		int MaxDeadline = deadline[0];
		for(int i = 0;i<n;i++)
		{
			if(deadline[i]>MaxDeadline)
			{
				MaxDeadline = deadline[i];
			}
		}
		
		slot = new int[MaxDeadline];
		for(int i=0;i<MaxDeadline;i++)
		{
			slot[i] = -1;
		}
		
		for(int i=0;i<n;i++)
		{
			int k = deadline[i]-1;
			while(k>=0)
			{
				if(slot[k] == -1)
				{
					slot[k] = i;
					break;
				}
				k--;
			}
		}
	}
	
	public static void main(String[] args) {
		//n = 7;
		//profit = new int[]{35,30,25,20,15,12,5};
		//deadline = new int[]{3,4,4,2,3,1,2};
		
		n = 5;
		profit = new int[] {20,15,10,5,1};
		deadline = new int[]{2,2,1,3,3};
		
		J = new int[n];
		for(int i=0;i<n;i++)
		{
			J[i] = 0;
		}
		SequenceIt();
		
		double cost = 0;
		System.out.println("The Optimal Sequence is:");
		for(int i=0;i<slot.length;i++)
		{
			System.out.print(slot[i]+1+" ");
			cost += profit[slot[i]];
		}
		System.out.println("\nTotal Profit = "+cost);

	}

}
