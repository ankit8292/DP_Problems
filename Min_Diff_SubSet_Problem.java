import java.util.*;
class Min_Diff_SubSet_Problem
{

	
	public static void main(String [] args)
	{

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of array");
		int n=sc.nextInt();
		int [] a= new int[n];
		int sum=0;
		System.out.println("Enter the number in the array");
		for(int i=0;i<n;i++)
		{
			a[i]=sc.nextInt();
			sum+=a[i];
		}

		int number= min_diff_subset(a,sum,n);
		
		System.out.println("There is minimum difference of  subset in given array is: "+ number);		

	}

	public static int min_diff_subset(int [] a, int sum, int n)
	{
		boolean [][] t= new boolean[n+1][sum+1];
		ArrayList<Integer> list=new ArrayList<>();

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
					t[i][j]=t[i-1][j-a[i-1]] || t[i-1][j];
				}
				else if(a[i-1]>j)
				{
					t[i][j]=t[i-1][j];
				}
				
			}
		}
	
		for(int i=n;i<n+1;i++)
		{
			for(int j=0;j<sum+1;j++)
			{
				if(t[i][j]==true && j<sum/2)
				{
					list.add(j);
				}
			}
			
		}

	
		int mn=Integer.MAX_VALUE; 
		for(int i=0;i<list.size();i++)
		{
			mn= Math.min(mn, sum-2*list.get(i));
		}
			
	        return mn;

	}


}
