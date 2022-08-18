package DivideAndConquer;
//TODO : Fractional Cascading over Binary search for n lists
//Author : Hyder Nabi
public class FractionalCascading {
	public static int k = 4;
	public static int list[][],aux[][],links[][];
	public static int s_Vector[];
	
	public static void CreateAuxiliaryLists()
	{
		aux[k-1] = new int[list[k-1].length];
		for(int i=0;i<list[k-1].length;i++)
		{
			aux[k-1][i] = list[k-1][i];
		}
		for(int i = k-2;i>=0;i--) {
			int listPtr = 0;
			int auxPtr = 1;
			int index = 0;
			aux[i] = new int[list[i].length+aux[i+1].length/2];
			while(listPtr<list[i].length && auxPtr<aux[i+1].length)
			{
				if(list[i][listPtr]<=aux[i+1][auxPtr]){
					aux[i][index] = list[i][listPtr];
					listPtr++;
					index++;
				}else
				{
					aux[i][index] = aux[i+1][auxPtr];
					auxPtr+=2;
					index++;
				}
			}
			while(listPtr<list[i].length)
			{
				aux[i][index] = list[i][listPtr];
				listPtr++;
				index++;
			}
			while(auxPtr<aux[i+1].length)
			{
				aux[i][index] = aux[i+1][auxPtr];
				auxPtr+=2;
				index++;
			}
			
		}
		
	}
	
	public static void CreateLinks()
	{
		links = new int[k*2-2][];
		int j = 0;
		for(int i = 0;i<links.length;i+=2) {
			links[i] = new int[aux[j].length];
			links[i+1] = new int[aux[j].length];
			int a = 0;
			int b = 0;
			int index = 0;
			while(a<aux[j].length)
			{
				if(aux[j][a]>aux[j+1][b])
				{
					if(b != aux[j+1].length-1) {
						b++;
					}else {
						links[i][index] = findActualIndex(aux[j][a],j);
						links[i+1][index] = -1; //inf 
						index++;
						a++;
					}
				}else{
					links[i][index] = findActualIndex(aux[j][a],j);
					links[i+1][index] = b; 
					index++;
					a++;
				}
			}
			j++;
		}
	}
	public static int findActualIndex(int elem,int index)
	{
		boolean flag1 = false;
		boolean flag2 = false;
		int return_index = -1;
		for(int i = 0;i<list[index].length;i++)
		{
			if(list[index][i] == elem)
			{
				flag1 = true;
				return_index = i;
				break;
			}
		}
		if(flag1 == true)
		{
			return return_index;
		}else {
			for(int i = 0;i<list[index].length;i++)
			{
				if(list[index][i] > elem)
				{
					flag2 = true;
					return_index = i;
					break;
				}
			}
			if(flag2 == true)
			{
				return return_index;
				
			}else
			{
				return -1;
			}
		}
		
	}
	
	public static void Search(int key)
	{
		s_Vector = new int[k];
		int index = Bi_Search(key);
		if(index != -1)
		{
			s_Vector[0] = links[0][index];
			int j = 1;
			for(int i = 1;i<k*2-2;i+=2)
			{
				index = links[i][index];
				if(index != -1)
				{
					int ind = index;
					for(int a =index;a>=index-1;a--)
					{
						if(a!=-1 && aux[j][a]>=key)
						{
							ind = a;
						}
					}
					index = ind;
					if(j == k-1)
					{
						s_Vector[j] = index;
					}else {
						s_Vector[j] = links[i+1][index];
					}
					j++;
				}else
				{
					for(int l = j;l<k;l++)
					{
						if(key>aux[l][aux[l].length-1])
						{
							s_Vector[l] = -1;
						}
						else
						{
							s_Vector[l] = list[l].length-1;
						}
						
					}
					break;
					
				}
				
				
				
			}
			
		}else
		{
			for(int i=0;i<s_Vector.length;i++)
			{
				s_Vector[i] = -1;
			}
		}
		
		
	}
	
	
	public static int Bi_Search(int key)
	{
		int beg = 0;
		int end = aux[0].length-1;
		int mid = (beg + end)/2;
		int successor = -1;
		while(beg<=end)
		{
			if(aux[0][mid] == key)
			{
				return mid;
			}
			else if(key<aux[0][mid])
			{
				end = mid - 1;
			}
			else
			{
				beg = mid + 1;
			}
			mid = (beg + end) / 2;
			if(aux[0][mid]>key)
			{
				successor = mid;
			}
		}
		return successor;
	
	}
	
	public static void main(String[] args) {
		//Actual List
	/*	list = new int[][] {
			{24,64,65,80,93},
			{23,25,26},
			{13,44,62,66},
			{11,35,46,79,81}
		};*/
		
		list = new int[][] {
			{3,5,9,11,34,67,78,93,99},
			{2,5,7,13,17,24,30},
			{1,4,6,9,15,19,23,69,89},
			{5,6,8,16,18,22,27,33,34,79,81}
		};
		aux = new int[k][];//Auxiliary List
		CreateAuxiliaryLists();
		CreateLinks();
		Search(3);
		for(int i = 0;i<s_Vector.length;i++)
		{
			System.out.println(s_Vector[i]);
		}
	}

}
