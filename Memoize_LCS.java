import java.util.*;
import java.io.*;

//Top Down Approch
class Memoize_LCS
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
	    int count=memo_lcs(s1, s2, n, m);
	    System.out.println("Longest Subsequence is: "+count);

	}

	public static int memo_lcs(String s1, String s2, int n, int m)
	{
		int t[][] = new int[n+1][m+1];
		for(int i=0;i<n+1;i++)
		{
			for(int j=0;j<=m+1;j++)
			{
				t[i][j]=-1;
			}
		}
		return LCS(s1,s2,n,m,t);
	}
		

	}

	public static int LCS(String  s1, String  s2, int n, int m, int [][]t)
	{
		if(n==0 || m==0)
		{
			return 0;
		}
		else if(t[n][m]!=-1)
		{
			return t[n][m];
		}

			
		else if(s1.charAt(n-1) == s2.charAt(m-1))
		{
			return t[n][m]= 1+LCS(s1,s2,n-1,m-1);
		}
		else
		{
			return t[n][m]= Math.max(LCS(s1,s2,n,m-1),LCS(s1,s2,n-1,m));
		}
	       
	}
}
	    
