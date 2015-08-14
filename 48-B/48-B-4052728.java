import java.util.*;
import java.io.*;
public class a {
    static long mod = 1000000007;
public static void main(String[] args) throws IOException
{
    //Scanner input = new Scanner(new File("input.txt"));
    //PrintWriter out = new PrintWriter(new File("output.txt"));
  input.init(System.in);
  PrintWriter out  = new PrintWriter((System.out));
  int n = input.nextInt(), m = input.nextInt();
  int[][] data = new int[n][m];
  for(int i =0 ; i<n; i++)
      for(int j = 0; j<m; j++)
          data[i][j] = input.nextInt();
  int a = input.nextInt(), b = input.nextInt();
  out.println(Math.min(go(data, a, b), go(data, b, a)));

  out.close();
}
static int go(int[][] grid, int a, int b)
{
    int n = grid.length, m = grid[0].length;
    int[][] sum = new int[n][m];
    for(int[] A: sum) Arrays.fill(A, 999999);
    if(a>n || b>m) return 999999;
    int sum1 = 0;
    for(int i = 0; i<a; i++)
        for(int j = 0; j<b; j++)
            sum1 += grid[i][j];
    for(int i = 0; i<n+1-a; i++)
    {
        for(int j = 0; j<m+1-b; j++)
        {
            if(i+j==0) sum[i][j] = sum1;
            else if(j!=0)
            {
                sum[i][j] = sum[i][j-1];
                int end = j+b-1;
                for(int k = i; k<a+i; k++)
                {
                    //System.out.println(i+" "+j+" "+k+" "+end+" "+sum[k][end] + " "+ sum[k][j-1]);
                    sum[i][j] += grid[k][end] - grid[k][j-1];
                }
            }
            else if(j == 0)
            {
                sum[i][j] = sum[i-1][j];
                int end = i+a-1;
                for(int k = 0; k<b; k++)
                {
                    sum[i][j] += grid[end][k] - grid[i-1][k];
                }
            }
            else sum[i][j] = sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1] + grid[i+a-1][j+b-1];
        }
    }
    int min = 9999999;
    for(int i = 0; i<n;i++)
        for(int j = 0; j<m; j++)
            min = Math.min(min, sum[i][j]);
    return min;
    
}
static long pow (long a, long p)
{
    if(p==0) return 1;
    if((p&1) == 0)
    {
        long sqrt = pow(a, p/2);
        return (sqrt*sqrt)%mod;
    }
    return (a*pow(a,p-1))%mod;
}
static class input {
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
  static String nextLine() throws IOException {
    return reader.readLine();
  }
}
}