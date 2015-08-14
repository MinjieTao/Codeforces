import java.util.*;
import java.io.*;
public class b {
    static int s = 1000000;
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    PrintWriter out = new PrintWriter(System.out);
    boolean[] taken = new boolean[s+1];
    int n = input.nextInt();
    for(int i = 0; i<n; i++)
    {
        int x = input.nextInt();
        taken[x] = true;
    }
    ArrayList<Integer> availablePairs = new ArrayList<Integer>();
    ArrayList<Integer> wantedSingles = new ArrayList<Integer>();
    int takenPairs = 0;
    for(int i = 1; i<= s/2; i++)
    {
        if(taken[i] && taken[s+1-i]) takenPairs++;
        else if(taken[i]) wantedSingles.add(s+1-i);
        else if(taken[s+1-i]) wantedSingles.add(i);
        else availablePairs.add(i);
    }
    out.println(n);
    for(int x: wantedSingles) out.print(x+" ");
    for(int  i= 0; i<takenPairs; i++)
    {
        int x = availablePairs.get(i);
        out.print(x+" "+(s+1-x)+" ");
    }
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