//TODO : Dijkstra's Algorithm with Greedy Approach 
//Author : Hyder Nabi

package Greedy;
interface data{
	final int inf = 10000;
}
class Dijkstra implements data{
	int dist[];
	int cost[][];
	int v;
	int n;
	boolean S[];
	String path[];
	Dijkstra(int cost[][],int v){
		this.n = cost.length;
		this.v = v;
		path = new String[n];
		this.cost = new int[n][n];
		for(int i=0;i<n;i++) {
			
			for(int j=0;j<n;j++)
			{
				this.cost[i][j] = cost[i][j];
			}
		}
		dist = new int[n];
		S = new boolean[n];
		
	}
	void Shortest_Paths() {
		for(int i = 0;i<n;i++) {
			S[i] = false;
			dist[i] = cost[v][i]; 
			if(dist[i] != inf)
			{
				path[i] = (v+1)+"->"+(i+1);
			}
		}
		S[v] = true;
		dist[v] = 0;
		
		for(int i = 1;i<n-1;i++) {
			
			int u; 
			u = min();
			S[u] = true;
			for(int w=0;w<n;w++)
			{
				if(cost[u][w] != inf && S[w] != true) {
					if(dist[w] > dist[u]+cost[u][w])
					{
						dist[w] = dist[u]+cost[u][w];
						path[w] = path[u]+"->"+(w+1);
					}
				}
			}
			
		}
	}
	public int min()
	{
		int m = inf;
		int index = -1;
		for(int i = 0;i<n;i++)
		{
			if(dist[i]<=m && S[i] == false) {
				m = dist[i];
				index = i;
			}
		}
		return index;
		
	}
	void getDistances()
	{
		System.out.println("Path \t : \t Cost");
		for(int i = 0;i<n;i++)
		{
			if(dist[i] == inf)
			{
				System.out.println(path[i] + "\t : \t inf");
			}else {
				System.out.println(path[i] + "\t : \t "+dist[i]);
			}
		}
	}
}
public class DijkstrasAlgo implements data {

	public static void main(String[] args) {
		int cost[][] = {
				{0,50,45,10,inf,inf},
				{inf,0,10,15,inf,inf},
				{inf,inf,0,inf,30,inf},
				{20,inf,inf,0,15,inf},
				{inf,20,35,inf,0,inf},
				{inf,inf,inf,inf,3,inf}
		};
		int source = 0;
		Dijkstra d = new Dijkstra(cost, source);
		d.Shortest_Paths();
		d.getDistances();
	}

}
