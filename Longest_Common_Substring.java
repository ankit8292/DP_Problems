import java.util.*;
import java.io.*;

//Bottom Up Approch
class Longest_Common_Substring
{
	public static void main (String[] args)throws IOException
	{
		
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    System.out.println("Enter the first string");
	    String s1=(br.readLine());
	    System.out.println("Enter the another string");
	    String s2=(br.readLine());
	    int n=s1.length();
	    int m=s2.length();    
	    int count=LCS(s1, s2, n, m);
	    System.out.println("Longest Subsequence is: "+count);

	}	

	

	public static int LCS(String  s1, String  s2, int n, int m)
	{
		int t[][] = new int[n+1][m+1];
		int res=0;
		for(int i=0;i<n+1;i++)
		{
			for(int j=0;j<m+1;j++)
			{
				if(i==0 || j==0)
				{
					t[i][j]=0;
				}
				else if(s1.charAt(i-1) == s2.charAt(j-1))
				{
					 t[i][j]= 1+t[i-1][j-1];
					 res=Math.max(res,t[i][j]);
				}
				else
				{
					 t[i][j]= 0;
				}
			}
		}

		return res;	
	}
}
	    
