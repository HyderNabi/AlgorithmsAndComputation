package GraphSearch;
//TODO : Breadth First Search (Graph Version)
//Author : Hyder Nabi
class Queue{
	public int r,f;
	public int arr[];
	Queue(){
		r = f = -1;
		arr = new int[100];
	}
	public void insert(int i)
	{
		if(r == -1)
		{
			r++;
			f++;
		}else
		{
			f++;
		}
		arr[f] = i;
	}
	public int delete()
	{
		int elem = arr[r];
		for(int i=0;i<f;i++)
		{
			arr[i] = arr[i+1];
		}
		f--;
		if(f == -1)
		{
			r = -1;
		}
		return elem;
	}
	public boolean isEmpty()
	{
		if(r == -1)
		{
			return true;
		}else
			return false;
	}
}
class BreadthFirstSearch{
	public int adjacencyList[][];	//ADJACENCY LIST
	public boolean visited[];	//VISITED NODES
	public boolean inQueue[];	//NODES THAT ARE CURRENTLY IN QUEUE
	public int V; 	//THE NUMBER OF VERTICES
	public int source;
	//CONSTRCUTOR
	BreadthFirstSearch(int data[][],int source)
	{
		V = data.length;
		adjacencyList = new int[V][V];
		visited = new boolean[V];
		inQueue = new boolean[V];
		this.source = source-1;
		for(int i = 0;i<V;i++)
		{
			visited[i] = false;
			inQueue[i] = false;
			
			for(int j = 0;j<V;j++)
			{
				adjacencyList[i][j] = data[i][j];
			}
		}
	}
	
	public void Search()
	{
		Queue queue = new Queue();
		queue.insert(source);
		inQueue[source] = true;
		
		while(!queue.isEmpty())
		{
			int elem = queue.delete();
			inQueue[elem] = false;
			visited[elem] = true;
			
			System.out.println(elem+1);
			for(int i=0;i<V;i++)
			{
				if(adjacencyList[elem][i] == 1 && visited[i] == false && inQueue[i] == false)
				{
					queue.insert(i);
					inQueue[i] = true;
				}
			}
		}
	}
}
public class Breadth_First_Search {
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
		int source = 1;
		BreadthFirstSearch  bfs = new BreadthFirstSearch(data,source); 
		bfs.Search();
	}
}

