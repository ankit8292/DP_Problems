import java.util.*;
class Count_SubSet_Given_Diff
{

	
	public static void main(String [] args)
	{

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of array");
		int n=sc.nextInt();
		int [] a= new int[n];
		int s=0;
		System.out.println("Enter the number ");
		for(int i=0;i<n;i++)
		{
			a[i]=sc.nextInt();
			s+=a[i];
		}

		System.out.println("Enter the Difference");
		int d =sc.nextInt();
		int sum =(d+s)/2;
		int ncount= count_subset_diff(a,sum,n);

		System.out.println("there is number of subset for given difference in  array is: "+ncount);
		
	}

	public static int count_subset_diff(int a[], int sum, int n)
	{
		int [][] t =new int [n+1][sum+1];
		for(int i=0;i<n+1;i++)		
		{

			t[i][0]=1;
		}

		for(int j=1;j<sum+1;j++)		
		{

			t[0][j]=0;
		}


		for(int i=1;i<n+1;i++)
		{
			for(int j=1;j<sum+1;j++)
			{
				if(a[i-1]<=j)
				{
					t[i][j]=t[i-1][j-a[i-1]] + t[i-1][j];
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

