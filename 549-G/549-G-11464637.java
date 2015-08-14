import java.util.*;
import java.io.*;
public class g {
public static void main(String[] args) throws IOException
{
    PrintWriter out = new PrintWriter(System.out);
    input.init(System.in);
    int n = input.nextInt();
    Person[] data = new Person[n];
    for(int i = 0; i<n; i++) data[i] = new Person(input.nextInt(), i);
    Arrays.sort(data);
    int[] res = new int[n];
    for(int i = 0; i<n; i++) res[i] = data[i].x + (data[i].i - i);
    boolean good = true;
    for(int i = 0; i<n-1; i++) if(res[i] > res[i+1]) good = false;
    if(good)
        for(int x : res) out.print(x+" ");
    else out.println(":(");
    
    out.close();
}
static class Person implements Comparable<Person>
{
    int x, i;
    public Person(int xx, int ii)
    {
        x = xx; i = ii;
    }
    @Override
    public int compareTo(Person o) {
        // TODO Auto-generated method stub
        return x + i - (o.x + o.i);
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