import java.util.*;
import java.io.*;
public class f {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    PrintWriter out = new PrintWriter(System.out);
    int n1 = input.nextInt(), n2 = input.nextInt();
    String s = input.next(), t = input.next();
    int[] res = new int[n1];
    int[][] match = new int[n1][26];
    int[][] rev = new int[n1][26];
    boolean[] valid = new boolean[n1];
    Arrays.fill(valid, true);
    for(int[] A : match) Arrays.fill(A, -1);
    for(int[] A : rev) Arrays.fill(A, -1);
    for(int i = 0; i<26; i++)
        for(int j = 0; j<26; j++)
        {
            int count = 0;
            char[] cs = new char[n1+n2+1];
            for(int k = 0; k<n2; k++)
            {
                char c = t.charAt(k);
                if(c == 'a' + j)
                {
                    count++;
                    cs[k] = c;
                }
                else cs[k] = '#';
            }
            cs[n2] = '$';
            for(int k = 0; k<n1; k++)
            {
                char c = s.charAt(k);
                cs[n2+k+1] = (c == 'a' + i) ? (char)('a'+j) : '#';
            }
            //if(i == 1 && j == 2) System.out.println(new String(cs));
            if(count == 0) continue;
            int[] zs = zs(cs);
            for(int k = 0; k<n1; k++)
            {
                if(zs[k+n2+1] >= n2)
                {
                    //System.out.println(i+" "+j+" "+k);
                    if(match[k][i] != -1 || rev[k][j] != -1) valid[k] = false;
                    if(rev[k][i] != -1 && rev[k][i] != j) valid[k] = false;
                    if(match[k][j] != -1 && match[k][j] != i) valid[k] = false;
                    match[k][i] = j;
                    rev[k][j] = i;
                    res[k] += count;
                    //System.out.println(i+" "+j+" "+k+" "+count);
                }
            }
        }
    //System.out.println(Arrays.toString(res));
    ArrayList<Integer> ans = new ArrayList<Integer>();
    for(int i = 0; i<n1; i++)
        if(res[i] == n2 && valid[i])
        {
            ans.add(i+1);
        }
    out.println(ans.size());
    for(int x : ans) out.print(x+" ");
    
    out.close();
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
public static class input {
    static BufferedReader reader;
    static StringTokenizer tokenizer;

    /** call this method to initialize reader for InputStream */
    static void init(InputStream input) {
        reader = new BufferedReader(
                     new InputStreamReader(input) );
        tokenizer = new StringTokenizer("");
    }

    /** get next word */
    static String next() throws IOException {
        while ( ! tokenizer.hasMoreTokens() ) {
            //TODO add check for eof if necessary
            tokenizer = new StringTokenizer(
                   reader.readLine() );
        }
        return tokenizer.nextToken();
    }

    static int nextInt() throws IOException {
        return Integer.parseInt( next() );
    }
    
    static double nextDouble() throws IOException {
        return Double.parseDouble( next() );
    }
    static long nextLong() throws IOException {
        return Long.parseLong( next() );
    }
}
}