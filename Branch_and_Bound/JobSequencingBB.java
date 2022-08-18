//TODO : JOb Sequencing using Branch and Bound {BB}
//Author : Hyder Nabi

package Branch_and_Bound;
class nodeX{
	node parent;
	int val; //Node No.
	int x; //index from the job set{defines the job number picker for this node}
	int TotalPanelty;
	int totalTimeUnits; //total time units till this node;
	int BigDeadline; //bigger deadline till this node;
}
public class JobSequencingBB {
	/*
	//Penalty
	public static int P[] = {5,10,6,3};
	//Deadline
	public static int D[] = {1,3,2,1};
	//Time units
	public static int T[] = {1,2,1,1};
	public static int n = 4; 
	*/
	
	//Penalty
	public static int P[] = {5,3,6,2,1,5};
	//Deadline
	public static int D[] = {1,3,5,7,2,3};
	//Time units
	public static int T[] = {1,1,3,2,1,2};
	public static int n = 6;
		
	
	
	
	public static int t,d,p; //total time,largest deadline and total penalty of the set so far;
	//queue
	public static node Queue[] = new node[100];
	public static  int f = -1,r = -1;
	
	
	public static void Job_SequencingBB(node root)
	{
		node child; //child node;
		node E; //the E-node
		node Answer = root; //Answer node;
		Add(root);
		int counter = 1;
		while(f<=r) {
		 E = Least();//Current E_Node Remove Node from the Queue;
		 if(E.TotalPanelty < Answer.TotalPanelty)
		 {
			 Answer = E;
			 Answer.TotalPanelty = E.TotalPanelty;
		 }
			for(int i=1;i<=n;i++) {
				if(i>E.x) {
					if(isFeasible(i, E)) {
						child = new node();
						child.parent = E;
						child.val = counter++;
						child.x = i;
						child.BigDeadline = d;
						child.totalTimeUnits = t;
						child.TotalPanelty = p;
						Add(child);
					}
				}
			}
		}
		showAnswer(Answer);
		
	}
	public static void showAnswer(node Ans)
	{
		node temp = Ans; 
		while(temp.parent != null)
		{
			System.out.println("INDEX{JOB NO.} : " +temp.x);
			temp = temp.parent;
		}
		System.out.println("Total Cost{Penalty} : " +Ans.TotalPanelty);
	}
	public static void Add(node child)
	{
		if(f == -1 && r == -1)
		{
			f++;r++;
		}
		else{
			r++;
		}
		Queue[r] = child;
	}
	public static node Least()//Remove
	{
		node n = Queue[f];
		Queue[f] = null;
		f++;
		return n;
	}
	
	public static boolean isFeasible(int Instance_index,node E_Node)
	{
		int TotalTime,B_deadLine; 
		Instance_index = Instance_index - 1; //array index starts from 0
		TotalTime = E_Node.totalTimeUnits + T[Instance_index];
		if(E_Node.BigDeadline > D[Instance_index])
			B_deadLine = E_Node.BigDeadline;
		else
			B_deadLine = D[Instance_index];
		
		if(B_deadLine >= TotalTime)
		{
			//calculate panelty for this node and set to p;
			p = E_Node.TotalPanelty - P[Instance_index];
			t = TotalTime;
			d = B_deadLine;
			return true;
		}else {
			return false;
		}
	}
	public static void main(String args[]) {
		node root = new node();
		root.val = 1;
		root.x = 0;
		root.parent = null;
		root.BigDeadline = 0;
		root.totalTimeUnits = 0;
		root.TotalPanelty = 22;//24 for exmaple 1 //when no job is selected//sum of penalties of all jobs
		Job_SequencingBB(root);
	}
}
