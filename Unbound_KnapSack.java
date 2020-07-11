import java.util.*;

class Unbound_KnapSack
{
	public static void main(String[] args)		
	{
		Scanner sc =new Scanner(System.in);
		System.out.println("Enter the size of item");
		int n=sc.nextInt();
		System.out.println("Enter the capacity of bag");
		int w =sc.nextInt();
		int [] wt =new int[n];
		int [] val=new int[n];
		System.out.println("Enter the weight of item");
		for(int i=0;i<n;i++)
		{
			wt[i]=sc.nextInt();
		}

		System.out.println("Enter the value of item");
		for(int i=0;i<n;i++)
		{
			val[i]=sc.nextInt();
		}
		

		int number=unbound_knapsac(val,wt,w,n);
		System.out.println("The maximum profit in the given array is: "+number);
	 	
	}


	public static int unbound_knapsac(int [] val, int [] wt, int w, int n)
	{
		int [][] t =new int[n+1][w+1];
		for(int i=0;i<n+1;i++)
		{
			for(int j=0;j<w+1;j++)
			{
				if(i==0 || j==0)
				{
					t[i][j]=0;
				}
			
				else if(wt[i-1]<=j)
				{
					t[i][j]=Math.max(val[i-1]+t[i][j-wt[i-1]], t[i-1][j]);
				}
				else
				{
					t[i][j]=t[i-1][j];
				}
			}
		}
		return t[n][w];
	}

}
