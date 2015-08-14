import java.util.*;
import java.io.*;
public class CLASS_NAME
{
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    PrintWriter out = new PrintWriter(System.out);
    
    
    
    out.close();  
}
public static class input {
    static BufferedReader reader;
    static StringTokenizer tokenizer;
    static void init(InputStream input) 
    {
        reader = new BufferedReader(new InputStreamReader(input));
        tokenizer = new StringTokenizer("");
    }
    static String next() throws IOException 
    {
        while (!tokenizer.hasMoreTokens())
            tokenizer = new StringTokenizer(reader.readLine());
        return tokenizer.nextToken();
    }
    static int nextInt() throws IOException
    {
        return Integer.parseInt(next());
    }
    static double nextDouble() throws IOException
    {
        return Double.parseDouble(next());
    }
    static long nextLong() throws IOException
    {
        return Long.parseLong(next());
    }
}
}
