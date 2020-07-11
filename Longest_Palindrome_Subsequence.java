import java.util.*;
import java.io.*;

class Longest_Palindrome_Subsequence
 {
	public static void main (String[] args)
	{
		
	    Scanner sc=new Scanner(System.in);
	    System.out.println("Enter the string");
	    String st1=sc.next();
	    char [] s=st1.toCharArray();
	    int n=s.length;
	    String st2="";
	    int [][] t= new int[n+1][n+1];
	   
	    for(int i=n-1;i>=0;i--)
	    {
	        st2+=s[i];
	    }

	    for(int i=0;i<n+1;i++)
	    {
	        for(int j=0;j<n+1;j++)
	        {
	            if(i==0 || j==0)
	            {
	                t[i][j]=0;
	            }
	            else if(st1.charAt(i-1)==st2.charAt(j-1))
	            {
	                t[i][j]=1+t[i-1][j-1];
	            }
	            else
	            {
	                t[i][j]=Math.max(t[i-1][j],t[i][j-1]);
	            }
	        }
	    }
	    System.out.println("The longest palindromic subsequence is: "+t[n][n]);
	    
		
	}
}
