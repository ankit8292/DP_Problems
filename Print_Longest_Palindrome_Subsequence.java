import java.util.*;
import java.io.*;

class Print_Longest_Palindrome_Subsequence 
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
	    //System.out.println(st1);
	    //System.out.println(st2);
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
	    
	    int index=t[n][n];
	    
	    char [] ch=new char[index+1];
	    int i=n,j=n;
	    while(i>0 && j>0)
	    {
	        if(st1.charAt(i-1)==st2.charAt(j-1))
	        {
	            ch[index-1]=st1.charAt(i-1);
	            i--;
	            j--;
	            index--;
	        }
	        else if(t[i-1][j]>t[i][j-1])
	        {
	            i--;
	        }
	        else
	        {
	            j--;
	        }
	    }
	    String ans="";
	    for(int k=0;k<ch.length;k++)
	    {
	        ans+=ch[k];
	    }
	    System.out.println("The longest palindrome string is: "+ans);
	    
		
	}
}
