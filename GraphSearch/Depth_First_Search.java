package GraphSearch;
//TODO : Depth First Search (Graph Version)
//Author : Hyder Nabi
class Stack{
	public int top;
	public int arr[];
	Stack(){
		top = -1;
		arr = new int[100];
	}
	public void push(int i)
	{
		arr[++top] = i;
	}
	public int pop()
	{
		int i = arr[top];
		top--;
		return i;
	}
}
class DepthFirstSearch{
	public int adjacencyList[][];	//ADJACENCY LIST
	public boolean visited[];	//VISITED NODES
	public boolean inStack[];	//NODES THAT ARE CURRENTLY IN STACK
	public int V; 	//THE NUMBER OF VERTICES
	public int source;
	
	//CONSTRCUTOR
	DepthFirstSearch(int data[][],int source)
	{
		V = data.length;
		adjacencyList = new int[V][V];
		visited = new boolean[V];
		inStack = new boolean[V];
		this.source = source-1;
		
		for(int i = 0;i<V;i++)
		{
			visited[i] = false;
			inStack[i] = false;
			
			for(int j = 0;j<V;j++)
			{
				adjacencyList[i][j] = data[i][j];
			}
		}
	}
	
	public void Search()
	{
		Stack stack = new Stack();
		stack.push(source);
		inStack[source] = true;
		
		while(stack.top != -1)
		{
			int elem = stack.pop();
			inStack[elem] = false;
			visited[elem] = true;
			
			System.out.println(elem+1);
			for(int i=0;i<V;i++)
			{
				if(adjacencyList[elem][i] == 1 && visited[i] == false && inStack[i] == false)
				{
					stack.push(i);
					inStack[i] = true;
				}
			}
		}
	}
}
public class Depth_First_Search {
	public static int data[][];
	public static void main(String args[])
	{
		data = new int[][] {
				{0,1,0,1,0,0,0,0,0,0},
				{1,0,1,0,1,0,1,1,0,0},
				{0,1,0,1,0,0,0,0,1,1},
				{1,0,1,0,0,0,0,0,0,0},
				{0,1,0,0,0,1,1,1,0,0},
				{0,0,0,0,1,0,0,0,0,0},
				{0,1,0,0,1,0,0,1,0,0},
				{0,1,0,0,1,0,1,0,0,0},
				{0,0,1,0,0,0,0,0,0,0},
				{0,0,1,0,0,0,0,0,0,0}
		};
		int source = 6;
		DepthFirstSearch  dfs = new DepthFirstSearch(data,source); 
		dfs.Search();
	}
}
