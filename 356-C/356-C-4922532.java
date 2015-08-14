import java.io.*;
import java.util.*;
public class c {
public static void main(String[] args) throws IOException
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int[] cs = new int[5];
    for(int i = 0; i<n; i++) cs[input.nextInt()]++;
    int tot = 0, res = 0;
    for(int i = 0; i<5; i++) tot += i*cs[i];
    if(tot == 2 || tot == 1 || tot == 5) System.out.println(-1);
    else
    {
        while(cs[1] > 0 && cs[2] > 0)
        {
            res++;
            cs[1]--;
            cs[2]--;
            cs[3]++;
        }
        while(cs[1] >= 3)
        {
            res += 2;
            cs[1] -= 3;
            cs[3]++;
        }
        while(cs[2] >= 3)
        {
            res += 2;
            cs[2] -= 3;
            cs[3] += 2;
        }
        if(cs[1] == 2)
        {
            res += 2;
        }
        else if(cs[1] == 1)
        {
            if(cs[3] > 0) res++;
            else res += 2;
        }
        else if(cs[2] == 2)
        {
            res += 2;
        }
        else if(cs[2] == 1)
        {
            if(cs[4] > 0) res ++;
            else res += 2;
        }
        System.out.println(res);
    }
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