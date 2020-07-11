import java.util.*;
class SubSet_Problem
{

	
	public static void main(String [] args)
	{

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of array");
		int n=sc.nextInt();
		int [] a= new int[n];
		System.out.println("Enter the number in the array");
		for(int i=0;i<n;i++)
		{
			a[i]=sc.nextInt();
		}

		System.out.println("Enter the sum");
		int sum =sc.nextInt();

		boolean flag= subset(a,sum,n);

		if(flag)
		{
			System.out.println("Yes, there is subset in given array");
		}

		else
		{
			System.out.println("No, there is no subset in given array");
		}
	}

	public static boolean subset(int [] a,  int sum, int n)
	{
	 	boolean [][] t =new boolean[n+1][sum+1];

	        // Intialize zeroth column to put the true value
		for(int i=0;i<n+1;i++)
		{
			t[i][0]=true;
		}

	        // Intialize zeroth row to put the flase value
		for(int j=1;j<sum+1;j++)
		{
			t[0][j]=false;
		}
	

		for(int i=1;i<n+1;i++)
		{
			for(int j=1;j<sum+1;j++)
			{
				if(a[i-1]<=j)
				{
					t[i][j]= t[i-1][j-a[i-1]] || t[i-1][j];

				}
				
				else 
				{
					 t[i][j]=t[i-1][j];
				}
			}

		}
		/*for(int i=0;i<n+1;i++)
		{
			for(int j=0;j<sum+1;j++)
			{
				System.out.print(t[i][j]+" ");
			}
			System.out.println();
		}*/

		return t[n][sum];
	}
	

}
