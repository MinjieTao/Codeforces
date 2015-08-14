import java.util.*;
import java.io.*;
public class a {
  static long mod = 1000000000l;
  public static int n;
  public static int[][] twos, fives, memo, memo2;
  public static char[][] res, res2;
public static void main(String[] args) throws IOException
{
  input.init(System.in);
  PrintWriter out = new PrintWriter(System.out);
  n = input.nextInt();
  int[][] data = new int[n][n];
  int zi = -1, zj = -1;
  twos = new int[n][n]; fives = new int[n][n];
  for(int i = 0; i<n; i++)
    for(int j = 0; j<n; j++)
    {
      data[i][j] = input.nextInt();
      if(data[i][j] == 0)
      {
          twos[i][j]++;
          fives[i][j]++;
          zi = i;
          zj = j;
      }
      int x = data[i][j];
      while(x%2==0 &&x!=0) {
        twos[i][j]++;
        x/=2;
      }
      while(x%5 == 0&&x!=0) {
        fives[i][j]++;
        x/=5;
      }
    }
  res = new char[n][n];
  res2 = new char[n][n];
  memo = new int[n][n];
  for(int[] A: memo) Arrays.fill(A, -1);
  memo2 = new int[n][n];
  for(int[] A: memo2) Arrays.fill(A, -1);
  long twos = go2(0, 0), fives = go(0, 0);
  char[] list = new char[2*(n-1)];
  if(twos > 0 && fives > 0 && zi != -1)
  {
      out.println(1);
      for(int i =0; i<zi; i++)
      {
          out.print('D');
      }
      for(int i = 0; i<n-1; i++)
          out.print('R');
      for(int i = 0; i<n-1-zi; i++) out.print('D');
  }
  else if(twos < fives)
  {
    out.println(twos);
    int i = 0, j = 0;
    while(i<n-1 || j<n-1)
    {
      if(res2[i][j] == 'D'||j==n-1)
      {
        i++;
        list[i+j-1] = 'D';
      }
      else
      {
        j++;
        list[i+j-1] = 'R';
      }
    }
    for(char c: list) out.print(c);
  }
  else
  {
    out.println(fives);
    int i = 0, j = 0;
    while(i<n-1 || j<n-1)
    {
      if(res[i][j] == 'D' || j==n-1)
      {
        i++;
        list[i+j-1] = 'D';
      }
      else
      {
        j++;
        list[i+j-1] = 'R';
      }
    }
    for(char c: list) out.print(c);
  }
  
  out.close();
  
}
int nextInt() throws IOException {
    return Integer.parseInt(nextToken());
}

long nextLong() throws IOException {
    return Long.parseLong(nextToken());
}

double nextDouble() throws IOException {
    return Double.parseDouble(nextToken());
}
BufferedReader reader;
StringTokenizer tokenizer;
String nextToken() throws IOException {
    while (tokenizer == null || !tokenizer.hasMoreTokens()) {
        tokenizer = new StringTokenizer(reader.readLine());
    }
    return tokenizer.nextToken();
}
public static int go(int i, int j)
{
  if(i == n-1 && j == n-1) return fives[i][j];
  if(i==n-1) return memo[i][j]=fives[i][j] + go(i, j+1);
  if(j==n-1) return memo[i][j]=fives[i][j] + go(i+1, j);
  if(memo[i][j] != -1) return memo[i][j];
  int right = go(i, j+1) + fives[i][j];
  int down = go(i+1, j) + fives[i][j];
  if(down <= right)
  {
    res[i][j] = 'D';
    return memo[i][j]=down;
  }
  else
  {
    res[i][j] = 'R';
    return memo[i][j]=right;
  }
}
public static int go2(int i, int j)
{
  if(i == n-1 && j == n-1) return twos[i][j];
  if(i==n-1) return memo2[i][j]=twos[i][j] + go2(i, j+1);
  if(j==n-1) return memo2[i][j]=twos[i][j] + go2(i+1, j);
  if(memo2[i][j] != -1) return memo2[i][j];
  int right = go2(i, j+1) + twos[i][j];
  int down = go2(i+1, j) + twos[i][j];
  if(down <= right)
  {
    res2[i][j] = 'D';
    return memo2[i][j]=down;
  }
  else
  {
    res2[i][j] = 'R';
    return memo2[i][j]=right;
  }
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
  static String nextLine() throws IOException {
    return reader.readLine();
  }
}
}