import java.util.*;
import java.io.*;
public class cf {
public static void main(String[] args) throws Exception
{
    input.init(System.in);
    PrintWriter out = new PrintWriter(System.out);
    int n = input.nextInt();
    int[] freq = new int[10];
    for(int i = 0; i<n; i++) freq[input.nextInt()-0]++;
    int mod3 = (freq[1]+freq[4]+freq[7] + 2*(freq[2]+freq[5]+freq[8]))%3;
    boolean good = freq[0] > 0;
    if(mod3 == 2)
    {
        if(freq[2]>0) freq[2]--;
        else if(freq[5] > 0) freq[5]--;
        else if(freq[8]>0) freq[8]--;
        else if(freq[1] > 1) freq[1] -= 2;
        else if(freq[4] > 1) freq[4] -=2;
        else if(freq[7]>1) freq[7]-=2;
        else if(freq[1] > 0 && freq[4]>0){freq[1]--; freq[4]--;}
        else if(freq[1] > 0 && freq[7]>0){freq[1]--; freq[7]--;}
        else if(freq[4] > 0 && freq[7]>0){freq[4]--; freq[7]--;}
        else good = false;
    }
    else if(mod3 == 1)
    {
        if(freq[1]>0) freq[1]--;
        else if(freq[4] > 0) freq[4]--;
        else if(freq[7]>0) freq[7]--;
        else if(freq[2] > 1) freq[2] -= 2;
        else if(freq[5] > 1) freq[5] -=2;
        else if(freq[8]>1) freq[8]-=2;
        else if(freq[2] > 0 && freq[5]>0){freq[2]--; freq[5]--;}
        else if(freq[2] > 0 && freq[8]>0){freq[2]--; freq[8]--;}
        else if(freq[5] > 0 && freq[8]>0){freq[5]--; freq[8]--;}
        else good = false;
    }
    boolean allz = true;
    for(int i = 1; i<9; i++) allz &= freq[i] ==0;
    if(allz) freq[0] = 1;
    if(good)
    {
        for(int i = 9; i>=0;i--)
            for(int j =0; j<freq[i]; j++)
                out.print(i);
    }
    else
        out.println(-1);
    out.close();
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