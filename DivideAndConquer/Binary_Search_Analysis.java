package DivideAndConquer;
//TODO : Analysis of Binary Search Algorithm in case of time in Nanoseconds over multiple arrays of different size.
//Author : Hyder Nabi

import java.util.Scanner;
public class Binary_Search_Analysis {

	static long Search(int arr[],int key)
	{
		long startTime = System.nanoTime();
		int beg,end,mid;
		beg = 0;
		end = arr.length-1;
		mid = (beg + end)/2;
		while(beg<=end)
		{
			if(arr[mid] == key)
			{
				System.out.println("Element is Found at Location " + mid);
				break;
			}
			else if(key<arr[mid])
			{
				end = mid - 1;
			}
			else
			{
				beg = mid + 1;
			}
			
			mid = (beg + end) / 2;
		}
		
		long endTime = System.nanoTime();
		long totalTime = endTime - startTime;
		System.out.println("Total TurnAroundTime = " + totalTime  + " NanoSeconds");
		
		return totalTime;
	}
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int key;
		long time[] = new long[50];
		int arrayLength[] = new int[50];
		int index = 0;
		boolean flag = true;
		
		int arr1[] = new int[] {51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92};
		int arr2[] = new int[] {100,102,104,106,108,110,112,114,116,118,120,122,124,126,128,130,132,134,136,138,140,142,144,146,148,150,152,154,156,158,160,162,164,166,168,170,172,174,176,178,180,182,184,186,188,190,192,194,196,198,260,262,264,266,268,270,272,274,276,278,280,282,284,286,288,290,292,294,296,298,300};
		int arr3[] = new int[] {100,102,104,106,108,110,112,114,116,118,120,122,124,126,128,130,132,134,136,138,140,142,144,146,148,150,152,154,156,158,160,162,164,166,168,170,172,174,176,178,180,182,184,186,188,190,192,194,196,198,200,202,204,206,208,210,212,214,216,218,220,222,224,226,228,230,232,234,236,238,240,242,244,246,248,250,252,254,256,258,260,262,264,266,268,270,272,274,276,278,280,282,284,286,288,290,292,294,296,298,300,302,304,306,308,310,312,314,316,318,320,322,324,326,328,330,332,334,336,338,340,342,344,346,348,350,352,354,356,358,360,362,364,366,368,370,372,374,376,378,380,382,384,386,388,390,392,394,396,398,400,402,404,406,408};
		int arr4[] = new int[] {6208,6210,6212,6214,6216,6218,6220,6222,6224,6226,6228,6230,6232,6234,6236,6238,6240,6242,6244,6246,6248,6250,6252,6254,6256,6258,6260,6262,6264,6266,6268,6270,6272,6274,6276,6278,6280,6282,6284,6286,6288,6290,6292,6294,6296,6298,6300,6302,6304,6306,6308,6310,6312,6314,6316,6318,6320,6322,6324,6326,6328,6330,6332,6334,6336,6338,6340,6342,6344,6346,6348,6350,6352,6354,6356,6358,6360,6362,6364,6366,6368,6370,6372,6374,6376,6378,6380,6382,6384,6386,6388,6390,6392,6394,6396,6398,6400,6402,6404,6406,6408,6410,6412,6414,6416,6418,6420,6422,6424,6426,6428,6430,6432};
		
		while(flag) {
			System.out.println("Enter Your Choice : ");
			System.out.println("0. For Termination");
			System.out.println("1. For array 1");
			System.out.println("2. For array 2");
			System.out.println("3. For array 3");
			System.out.println("4. For array 4");
			int choice = in.nextInt();
			switch(choice)
			{

			case 0:
					flag = false;
					in.close();
					break;
			case 1:
				System.out.print("Enter Key = ");
				key = in.nextInt();
				arrayLength[index] = arr1.length;
				time[index] = Search(arr1, key);
				index ++;
				break;
			case 2:
				System.out.print("Enter Key = ");
				key = in.nextInt();
				arrayLength[index] = arr2.length;
				time[index] = Search(arr2, key);
				index ++;
				break;
			case 3:
				System.out.print("Enter Key = ");
				key = in.nextInt();
				arrayLength[index] = arr3.length;
				time[index] = Search(arr3, key);
				index ++;
				break;
			case 4:
				System.out.print("Enter Key = ");
				key = in.nextInt();
				arrayLength[index] = arr4.length;
				time[index] = Search(arr4, key);
				index ++;
				break;
			default:
				System.out.println("Your Input is not correct");
					
				
			}
		}
		
		for(int i = 0; i<index;i++)
		{
			System.out.println("N = "+arrayLength[i] + "\t Time = " +time[i]);
		}
		
	}

}
