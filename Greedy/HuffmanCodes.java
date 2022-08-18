//TODO : Huffman Encoding with greedy approach
//Author : Hyder Nabi

package Greedy;
//node structure
class node
{
	char Char;
	int data;
	node left;
	node right;
	int val;
}
//Class Priority queue
class PQueue
{
	int front;
	int rear;
	node list[];
	PQueue(int n)
	{
		front = -1;
		rear = -1;
		list = new node[n];
	}
	//Add node in Priority Queue
	public void addNode(node n)
	{
		if(rear == -1)
		{
			front=0;
			rear=0;
			list[rear] = n;
		}else
		{
			int i=0;
			for(i=rear;i>=0;i--)
			{
				if(n.data>list[i].data)
				{
					//list[i+1] = n;
					break;
				}else
				{
					list[i+1] =list[i];
				}
			}
			list[i+1] = n;
			rear++;
		}
		
	}
	
	//Remove node from Priority Queue
	public node removeNode()
	{
		node n = list[front];
		for(int i=0;i<rear;i++)
		{
			list[i] = list[i+1];
		}
		rear--;
		if(rear == -1)
		{
			front = -1;
		}
		return n;
	}
	//Check if the Priority Queue is empty
	public boolean isDone()
	{
		if(front ==0 && rear == 0)
		{
			return true;
		}else
		{
			return false;
		}
	}
}


public class HuffmanCodes {
	public static char characters[];
	public static int frequency[];
	public static int sol_Vector[];
	
	//Huffman Procedure
	public static node HuffmanProcedure()
	{
		PQueue queue = new PQueue(characters.length);
		//Add elements into the queue
		for(int i=0;i<characters.length;i++)
		{
			node n = new node();
			n.Char = characters[i];
			n.data = frequency[i];
			n.left = null;
			n.right = null;
			queue.addNode(n);
		}
		//root of the Decode Tree
		node Root = null;
		//Create Decode Tree
		while(!queue.isDone())//until the Queue is empty
		{
			node n = new node();
			node l = queue.removeNode();//remove left child from Queue
			node r = queue.removeNode();//remove right child from Queue
			l.val = 0;
			r.val = 1;
			n.data = l.data+r.data; //Add left child and right child
			n.Char = 'X';
			n.left = l;
			n.right = r;
			Root = n;
			queue.addNode(n); //insert new node(internal node) into the Queue back
		}
		
		return Root;//return the root of the Queue
	}
	
	
	//Create the solution Vector
	public static void printCode(node root,int i)
	{
		if(root.left == null && root.right == null)//Base condition
		{
			sol_Vector[i] = root.val;
			System.out.print(root.Char +" : ");
			for(int j=1;j<=i;j++)//printing the solution
			{
				System.out.print(sol_Vector[j]);
			}
			System.out.println();
			return;
		}else {
			if(i!= 0) {
				sol_Vector[i] = root.val;
			}
			i++;
			printCode(root.left,i);//call on the left subtree
			printCode(root.right,i);//call on the right subtree
		}
	}
	public static void main(String args[])
	{
		//characters = new char[]{'A','B','C','D','E','F'};
		//frequency = new int[]{5,9,12,13,16,45};
		
		//characters = new char[]{'A','B','C','D'};
		//frequency = new int[]{5,1,6,3};
		
		characters = new char[]{'A','B','C','D','E'};
		frequency = new int[]{3,5,6,4,2};
		
		sol_Vector = new int[characters.length+1];
		node root = HuffmanProcedure();
		int i=0;
		printCode(root,i);
	}
}
