import java.util.*;
class MemoKnapSack
{

	
	public static void main(String [] args)
	{

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of item");
		int n=sc.nextInt();

		System.out.println("Enter the capacity of bag");
		int w =sc.nextInt();

		int [] wt= new int[n];
		int [] val = new int[n];

		System.out.println("Enter the weight of item");
		for(int i=0;i<n;i++)
		{
			wt[i]=sc.nextInt();
		}

		System.out.println("Enter the value of item ");
		for(int i=0;i<n;i++)
		{
			val[i]=sc.nextInt();
		}

		int profit=knapsac(wt,val,w,n);
		System.out.println("Maximum Profit is: "+profit);
	}

	public static int  knapsac(int [] wt, int [] val, int w, int n)
	{
	 	int [][] t =new int[n+1][w+1];
	
		for(int i=0;i<n+1;i++)
		{
			for(int j=0;j<w+1;j++)
			{
				t[i][j]=-1;
			}

		}
		return memoknapsac(wt, val, w, n,t);
	}
	public static int memoknapsac(int [] wt, int [] val, int w, int n, int [][] t)
	{

		if(n==0 || w==0)
		{
			return 0;
		}

		if(t[n][w]!=-1)
		{
			return t[n][w];
		}

		if(wt[n-1]<=w)
		{
			return t[n][w]= Math.max((val[n-1]+memoknapsac(wt,val,w-wt[n-1],n-1,t)),memoknapsac(wt,val,w,n-1,t));
			
		}

		if(wt[n-1]>w)
		{
			return t[n][w]=(memoknapsac(wt,val,w,n-1,t));
		}

		return 0;
	}





}
