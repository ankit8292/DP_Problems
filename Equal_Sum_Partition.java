import java.util.*;
import java.io.*;


class Equal_Sum_Partition
{
	public static void main (String[] args)throws IOException
	{
		
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    System.out.println("Enter the size of array");
	    int n=Integer.parseInt(br.readLine());
	    System.out.println("Enter the number of array");
	    
	    String[] s1 = br.readLine().split(" ");
	    int sum=0;
	    int [] a =new int[n];
	    for(int i=0;i<n;i++)
	    {
	        a[i]=Integer.parseInt(s1[i]);
	        sum+=a[i];
	    }
	    
	    if(sum%2!=0)
	    {
	        System.out.println("NO");
	    }
	    else
	    {
	        boolean flag=subset(a,sum/2,n);
	        if(flag)
	        {
	            System.out.println("YES, there is equal sum partition in the array");
	        }
	        else
	        {
	           System.out.println("NO, there is no equal sum partition in the array"); 
	        }
	    }
		    
		
	}
	
	public static boolean subset(int []a, int sum, int n)
	{
	    boolean [][] t= new boolean[n+1][sum+1];

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
	            else 
	            {
	                t[i][j]=t[i-1][j];
	            }
	        }
	    }
	    return t[n][sum];
	}
}
