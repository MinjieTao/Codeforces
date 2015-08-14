import java.util.*;
import java.io.*;
public class a {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    int n = input.nextInt();
    int[] data = new int[n];
    for(int i = 0; i<n; i++) data[i] = input.nextInt();
    ArrayList<Integer> bad = new ArrayList<Integer>();
    for(int i = 0; i<n-1; i++) if(data[i+1] < data[i]) bad.add(i);
    boolean res = true;
    for(int i = 0; i<bad.size()-1; i++) if(bad.get(i+1) != bad.get(i)+1) res = false;
    if(res && bad.size() > 0) bad.add(bad.get(bad.size()-1)+1);
    for(int i = 0; i<bad.size()/2 && res; i++)
    {
        int temp = data[bad.get(i)];
        data[bad.get(i)] = data[bad.get(bad.size()-1-i)];
        data[bad.get(bad.size()-1-i)] = temp;
    }
    //System.out.println(Arrays.toString(data));
    for(int i = 0; i<n-1; i++) if(data[i+1] < data[i]) res = false;
    if(res && bad.size() == 0) System.out.println("yes\n1 1");
    else System.out.println(res ? "yes\n" + (1+bad.get(0)) +" "+ (1+bad.get(bad.size()-1)) : "no");
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