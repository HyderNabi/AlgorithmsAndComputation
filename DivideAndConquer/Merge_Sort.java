package DivideAndConquer;
//TODO : Merge Sort Algorithm
//Author : Hyder Nabi
class MS{
	int arr[] = new int[] {10,5,7,90,20,13,12,1,24,35,26,11,19,27};
	int len = arr.length;
	
	public void MergeSort(int l,int h) {
		if(l<h) {
			int mid = (l+h)/2;
			MergeSort(l,mid);
			
			MergeSort(mid+1,h);
			Merge(l,mid,h);
		}
		
	}
	void Merge(int l,int mid,int h) {
		int Left[] = new int[(mid-l)+1];
		int Right[] = new int[h-mid];
		int i,j;
		for(i = 0;i<Left.length;i++) {
			Left[i] = arr[l+i];
		}
		for(i = 0;i<Right.length;i++) {
			Right[i] = arr[mid+1+i];
		}
		i = j = 0;
		while(i<Left.length && j<Right.length) {
			if(Left[i]<Right[j]) {
				arr[l] = Left[i];
				i++;
				l++;
			}
			else {
				arr[l] = Right[j];
				j++;
				l++;
			}
		}
		while(i<Left.length) {
			arr[l] = Left[i];
			i++;
			l++;
		}
		while(j<Right.length) {
			arr[l] = Right[j];
			j++;
			l++;
		}
	}
}
public class Merge_Sort {

	
	public static void main(String[] args) {
		MS ms = new MS();
		ms.MergeSort(0,ms.len-1);
		for(int i : ms.arr) {
			System.out.println(i);
		}
	}

}
