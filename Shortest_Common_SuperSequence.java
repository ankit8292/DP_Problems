import java.util.*;
import java.io.*;

class Shortest_Common_SuperSequence 
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
	    System.out.print("The length of common supersequence is: ");
	    System.out.println(m+n-t[n][m]);
		
	}
}
