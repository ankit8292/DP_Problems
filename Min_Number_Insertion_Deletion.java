import java.util.*;
import java.io.*;

class Min_Number_Insertion_Deletion 
{
	public static void main (String[] args) 
	{
		//code
	    Scanner sc=new Scanner(System.in);
	    
	    System.out.println("Enter the first string");
	    String s1=sc.next();
	    System.out.println("Enter the another string");
	    String s2=sc.next();
	    int n=s1.length();
	    int m=s2.length();
	 
	    int [][] t =new int[n+1][m+1];
	    for(int i=0;i<n+1;i++)
	    {
	        for(int j=0;j<m+1;j++)
	        {
	            if(i==0 || j==0)
	            {
	                t[i][j]=0;
	            }
	            
	            else if(s1.charAt(i-1)==s2.charAt(j-1))
	            {
	                t[i][j]=1+t[i-1][j-1];
	            }
	            else
	            {
	                t[i][j]=Math.max(t[i][j-1], t[i-1][j]);
	            }
	        }
	    }
	    int lcs=t[n][m];
	    int ndeletion=n-lcs;
	    int ninsertion=m-lcs;
	    System.out.println("The minimum number of insertion is: "+ninsertion);
	    System.out.println("The minimum number of deletion is: "+ndeletion);
	    System.out.println("The total no. of insertion and deletion required to get the second string is: "+(ninsertion+ndeletion));
	    
		
	}
}
