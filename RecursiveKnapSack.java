import java.util.*;
class RecursiveKnapSack
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

		int profit=recursiveknapsac(wt,val,w,n);
		System.out.println("Maximum Profit is: "+profit);
	}


	public static int recursiveknapsac(int [] wt, int [] val, int w, int n)
	{

		if(n==0 || w==0)
		{
			return 0;
		}

		if(wt[n-1]<=w)
		{
			return Math.max((val[n-1]+recursiveknapsac(wt,val,w-wt[n-1],n-1)),recursiveknapsac(wt,val,w,n-1));
			
		}

		if(wt[n-1]>w)
		{
			return(recursiveknapsac(wt,val,w,n-1));
		}

		return 0;
	}





}
