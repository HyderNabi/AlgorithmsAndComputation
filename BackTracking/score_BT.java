package BackTracking;

/*Author : Hyder Nabi
 *[Altrnate way]
 * We have to score 18 runs in the last 5 balls to win the cricket match
 * 
 * constraints:
 * on ball no 2 and 4  only 1 run can be scored
 * on ball no 1 3 5 either 1 or 4 or 6 runs can be scored
 * 
 * Formally:
 * S1+S2+S3+S4+S5 >= 18
 * sub to
 * s1,s3,s5 = {1,4,6}
 * and s2,s4,= {1}
 * */
public class score_BT {
	public static int S_Vector[];
	public static int ScoreRequired;
	public static int P_Score[];
	public static int count = 0;
	public static void BT_Proc(int k,int n,int score)
	{
		count++;
		//index starts from 0
		if(k == 1 || k == 3)
		{
			S_Vector[k] = 1;
			BT_Proc(k+1,n,score+1);
		}else {
			for(int i=0;i<P_Score.length;i++)
			{
				if(k == n)
				{
					if(score>=ScoreRequired) {
						show(score);
						return;					
					}
				}else {
					S_Vector[k] = P_Score[i];
					BT_Proc(k+1,n,score+P_Score[i]);
				}
			}
		}
	}
	
	public static void show(int score)
	{
		for(int i=0;i<S_Vector.length;i++)
		{
			System.out.print(S_Vector[i]);
		}
		System.out.print(" : Score = "+score);
		System.out.println();
	}
	public static void main(String[] args) {
		int n = 5;
		S_Vector = new int[n];
		//Possible score on ball no 1,3 and 5
		P_Score = new int[]{1,4,6};
		ScoreRequired = 18;
		BT_Proc(0,n,0);
		System.out.println("Total number of recursive calls = "+count);
	}

}
