//TODO : Fractional Knapsack using Greedy Approach (item selection criteria is "Select item with Maximum Profit/Weight Ratio")[Alternate method]
//Author : Hyder Nabi
package Greedy;
class Knapsack{
	//Pi
	private double profit[];
	//Wi
	private double weight[];
	//Solution Vector
	private double x[];
	//profit by weight (Ratio) vector --- used for selection criteria
	private double ProWei[];
	//Total number of objects in the Knapsack
	private int n;
	//Total capacity of the Knapsack
	private int m; 
	
	
	//Initialization of data variables
	public Knapsack(int P[],int W[],int m) {
		//initialize Vectors (solution,profit and weight)
		this.profit = new double[P.length];
		this.weight = new double[W.length];
		this.x = new double[P.length];
		this.ProWei = new double[P.length];
		for(int i = 0;i<P.length;i++) {
			this.profit[i] = P[i];
			this.weight[i] = W[i];
			//Set Initial Solution to 0
			this.x[i] = 0;
			//profit by weight vector
			this.ProWei[i] = ((double)P[i]/(double)W[i])  ; 
		}
		
		//initialize n and m
		this.n = P.length;//no of objects
		this.m = m;//knapsack capacity
		
	}
	
	//The Main Greedy Knapsack Procedure
	public void Greedy_Knapsack() {
		int index;
		for(int i = 0;i<n;i++)
		{
			index = Selection();
			CheckConstraint_and_Union(index);
			if(WiXi() == m)
			{
				break;
			}
			
		}
	}
	//calculate Summation PiXi
	public double PiXi()
	{
		double profit_sum = 0;
		for(int i=0;i<n;i++)
		{
			System.out.println("x["+(i+1)+"] = "+x[i]);
			profit_sum += this.profit[i] * this.x[i];
			
		}
		return profit_sum;
	}
	////calculate Summation WiXi
	public double WiXi() {
		double Weight_sum = 0;
		for(int i=0;i<n;i++)
		{
			Weight_sum += this.weight[i] * this.x[i];
			
		}
		
		return Weight_sum;
	}
	//check constraints and Unite solution
	public void CheckConstraint_and_Union(int index) {
		double sum = 0;
		double leftCapacity;
		sum = WiXi();
		if(sum+this.weight[index] <= m) {
			x[index] = 1;
		}else if(sum+this.weight[index] > m) {
			leftCapacity = m-sum;
			x[index] = (double)leftCapacity/(double)weight[index];
		}
	}
	//Selection criteria
	public int Selection() {
		double lar = this.ProWei[0];
		int index = 0;
		for(int i=0;i<this.n;i++) {
			if(this.ProWei[i]>=lar && this.ProWei[i]>0)
			{
				lar = this.ProWei[i];
				index = i;
			}
		}
		this.ProWei[index] = 0;
		return index;
	}
}

public class Fractional_Knapsack {

	public static void main(String[] args) {
		int p[] = {10, 5, 15, 7, 6, 18,3};
		int w[] = {2, 3, 5, 7, 1, 4, 1};
		int m = 15;
		
		//int p[] = {25, 24,15};
		//int w[] = {18, 15, 10};
		//int m = 20;
		Knapsack o = new Knapsack(p, w, m);
		o.Greedy_Knapsack();
		
		System.out.println("The Optimal Cost = " + o.PiXi());

	}

}
