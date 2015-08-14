import java.util.*;
public class zvalues {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    char[] s = input.next().toCharArray();
    int L = 0, R = 0;
    int n = s.length;
    int[] z = new int[n];
    for (int i = 1; i < n; i++) 
    {
          if (i > R) 
          {
            L = R = i;
            while (R < n && s[R-L] == s[R]) R++;
            z[i] = R-L; R--;
          } 
          else 
          {
                int k = i-L;
                if (z[k] < R-i+1) 
                    z[i] = z[k];
                else 
                {
                      L = i;
                      while (R < n && s[R-L] == s[R]) R++;
                      z[i] = R-L; R--;
                }
          }
    }
    int maxz = 0, res = 0;
    for (int i = 1; i < n; i++) 
    {
          if (z[i] == n-i && maxz >= n-i) 
          { 
              res = n-i; 
              break; 
          }
          maxz = Math.max(maxz, z[i]);
    }
    if(res == 0)
        System.out.println("Just a legend");
    else
    {
        for(int i = 0; i<res; i++)
            System.out.print(s[i]);
        System.out.println();
    }
}
}