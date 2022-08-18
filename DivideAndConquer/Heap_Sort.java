package DivideAndConquer;
//TODO : Heap Sort using Binary Heap data Structure
//Author : Hyder Nabi
public class Heap_Sort {
	public static int arr[];
	public static int n;
	
	//PROCEDURE FOR SWAPPING THE TWO ELEMENTS OF THE HEAP
	public static void swap(int a, int b)
	{
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
	//PROCEDURE FOR CREATIGN HEAP OUT OF ARRAY {Bottom up procedure}
	public static void heapify(int index,int heapSize)
	{
		int left = (2*index)+1;
		int right = (2*index)+2;
		int greater = 0;
		if(index<(heapSize/2))
		{
			if(left<heapSize && right<heapSize)
			{
				if(arr[index]<arr[left]){
					greater = left;
				}else {
					greater = index;
				}
				
				if(arr[greater]<arr[right])
				{
					greater = right;
				}
			}else if(right>=heapSize)
			{
				if(arr[index]<arr[left]){
					greater = left;
				}else {
					greater = index;
				}
			}
			if(index != greater) {
				swap(index,greater);
				heapify(greater,heapSize);
			}
			
		}
		
	}
	public static void HeapSort()
	{
		for(int i = n-1;i>=0;i--)
		{	
			swap(0,i);
			heapify(0,i);
		}
	}
	public static void main(String[] args) {
		
		arr = new int[] {2,-90,56,1234,59,10,20,15,98,34,12,40,25,18};
		n  = arr.length;
		
		for(int i = (n/2)-1;i>=0;i--)
		{
			heapify(i,n);	//BUILD MAX HEAP
		}
		
		//PROCEDURE FOR HEAPSORT
		HeapSort();
		
		for(int i = 0;i<n;i++)
		{
			System.out.print(arr[i]+" ");
		}
	}
		

}
