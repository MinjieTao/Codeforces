import java.util.*;
import java.io.*;
public class D7 {
public static void main(String[] args) throws IOException
{
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    String s = input.readLine();
    int n = s.length();
    int[] res = new int[n];
    char[] ss = new char[2*n];
    for(int i = 0; i<n; i++) ss[i] = ss[2*n-1-i] = s.charAt(i);
    int[] zs = zs(ss);
    //System.out.println(Arrays.toString(zs));
    int sum = res[0] = 1;
    for(int i = 1; i<n; i++) sum += res[i] = (zs[2*n-1-i] > i) ? res[(i-1)/2] + 1 : 0;
    //System.out.println(Arrays.toString(res));
    System.out.println(sum);
}
static int[] zs(char[] s)
{
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
    return z;
}
}