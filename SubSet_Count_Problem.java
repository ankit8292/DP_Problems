import java.util.*;
class SubSet_Count_Problem
{

	
	public static void main(String [] args)
	{

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of array");
		int n=sc.nextInt();
		int [] a= new int[n];
		System.out.println("Enter the number ");
		for(int i=0;i<n;i++)
		{
			a[i]=sc.nextInt();
		}

		System.out.println("Enter the sum");
		int sum =sc.nextInt();

		int ncount= subset(a,sum,n);

		System.out.println("there is number of subset in given array are: "+ncount);
		
	}

	public static int subset(int [] a,  int sum, int n)
	{
	   int [][] t =new int[n+1][sum+1];

	    // Intialize zeroth column to put the 1 value
	    for(int i=0;i<n+1;i++)
	    {
		t[i][0]=1;
	    }

	    // Intialize zeroth row to put the 0 value 
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
				t[i][j]= t[i-1][j-a[i-1]] + t[i-1][j];

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
