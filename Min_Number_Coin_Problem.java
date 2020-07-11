import java.util.*;
class Min_Number_Coin_Problem
{

	
	public static void main(String [] args)
	{

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of coin_array");
		int n=sc.nextInt();
		int [] a= new int[n];
		System.out.println("Enter the types of coin");
		for(int i=0;i<n;i++)
		{
			a[i]=sc.nextInt();
		}

		System.out.println("Enter the sum");
		int sum =sc.nextInt();

		int ncount= min_coin(a,sum,n);
		System.out.println("The min number of coin to get given sum is: "+ ncount);
	}
	
	public static int min_coin(int [] a, int sum, int n)
	{
		int [][] t =new int[n+1][sum+1];
		for(int j=0;j<sum+1;j++)
		{
			t[0][j]=Integer.MAX_VALUE-1;
		}

		for(int i=1;i<n+1;i++)
		{
			t[i][0]=0;
		}	
		
		for(int j=1;j<sum+1;j++)
		{
			if(j%a[0]==0)
			{
				t[1][j]=j/a[0];
				
			}
			else
			{
				t[1][j]=Integer.MAX_VALUE-1;
			}
		}

		for(int i=2;i<n+1;i++)
		{
			for(int j=1;j<sum+1;j++)
			{
				if(a[i-1]<=j)
				{

					t[i][j]=Math.min(t[i][j-a[i-1]]+1, t[i-1][j]);
					
				}
				
				else
				{
					t[i][j]=t[i-1][j];
				}
			}
		}

		
		return t[n][sum];

	}

}
