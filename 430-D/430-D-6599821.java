import java.util.*;
import java.io.*;
public class b {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    PrintWriter out = new PrintWriter(System.out);
    
    int n = input.nextInt(), m = input.nextInt();
    int[][] data = new int[n][m];
    for(int i = 0; i<n; i++)
        for(int j = 0; j<m; j++)
            data[i][j] = input.nextInt();
    long[][] pre1 = new long[n][m]; //boy after meet
    pre1[n-1][m-1] = data[n-1][m-1];
    for(int i = n-1; i>=0; i--)
        for(int j = m-1; j>=0; j--)
        {
            if(i < n-1)
                pre1[i][j] = Math.max(pre1[i][j], pre1[i+1][j] + data[i][j]);
            if(j < m-1)
                pre1[i][j] = Math.max(pre1[i][j], pre1[i][j+1] + data[i][j]);
        }
    long[][] pre2 = new long[n][m]; //girl before meet
    pre2[n-1][0] = data[n-1][0];
    for(int i = n-1; i>=0; i--)
        for(int j = 0; j<m; j++)
        {
            if(i < n-1)
                pre2[i][j] = Math.max(pre2[i][j], pre2[i+1][j] + data[i][j]);
            if(j > 0)
                pre2[i][j] = Math.max(pre2[i][j], pre2[i][j-1] + data[i][j]);
        }
    long[][] pre3 = new long[n][m]; //boy before meet
    pre3[0][0] = data[0][0];
    for(int i = 0; i<n; i++)
        for(int j = 0; j<m; j++)
        {
            if(i > 0) pre3[i][j] = Math.max(pre3[i][j], pre3[i-1][j] + data[i][j]);
            if(j > 0) pre3[i][j] = Math.max(pre3[i][j], pre3[i][j-1] + data[i][j]);
        }
    long[][] pre4 = new long[n][m];
    pre4[0][m-1] = data[0][m-1];
    for(int i = 0; i<n; i++)
        for(int j = m-1; j>=0; j--)
        {
            if(i > 0) pre4[i][j] = Math.max(pre4[i][j], pre4[i-1][j] + data[i][j]);
            if(j < m-1) pre4[i][j] = Math.max(pre4[i][j], pre4[i][j+1] + data[i][j]);
        }
    long res = 0;
    for(int i = 1; i<n-1; i++)
        for(int j =1; j<m-1; j++)
        {
            res = Math.max(res, (i < n-1 ? pre1[i+1][j] : 0) 
                    + (j > 0 ? pre2[i][j-1] : 0) 
                    + (i > 0 ? pre3[i-1][j] : 0) 
                    + (j < m-1 ? pre4[i][j+1] : 0));
            
            res = Math.max(res, (j < m-1 ? pre1[i][j+1] : 0) 
                    + (i <n-1 ? pre2[i+1][j] : 0) 
                    + (j > 0 ? pre3[i][j-1] : 0) 
                    + (i > 0 ? pre4[i-1][j] : 0));
            
//          
//          res = Math.max(res, (j < m-1 ? pre1[i][j+1] + data[i][j+1] : 0) 
//                  + (i <n-1 ? pre2[i+1][j] + data[i+1][j] : 0) 
//                  + (i > 0 ? pre3[i-1][j] + data[i-1][j] : 0));
//          res = Math.max(res, (j < m-1 ? pre1[i][j+1] + data[i][j+1] : 0) 
//                  + (j > 0 ? pre2[i][j-1] + data[i][j-1] : 0) 
//                  + (i > 0 ? pre3[i-1][j] + data[i-1][j] : 0));
//          res = Math.max(res, (i < n-1 ? pre1[i+1][j] + data[i+1][j] : 0)  
//                  + (i > 0 ? pre4[i-1][j] + data[i-1][j] : 0) 
//                  + (j > 0 ? pre3[i][j-1] + data[i][j-1] : 0) );
//          res = Math.max(res, (i < n-1 ? pre1[i+1][j] + data[i+1][j] : 0)  
//                  + (j < m-1 ? pre4[i][j+1] + data[i][j+1] : 0) 
//                  + (j > 0 ? pre3[i][j-1] + data[i][j-1] : 0) );
//
//          
//          res = Math.max(res, (i <n-1 ? pre2[i+1][j] + data[i+1][j] : 0)
//                  + (j < m-1 ? pre4[i][j+1] + data[i][j+1] : 0)
//                  + (j > 0 ? pre3[i][j-1] + data[i][j-1] : 0));
//          
//          res = Math.max(res, (i <n-1 ? pre2[i+1][j] + data[i+1][j] : 0)
//                  + (j < m-1 ? pre4[i][j+1] + data[i][j+1] : 0)
//                  + (i > 0 ? pre3[i-1][j] + data[i-1][j] : 0));
//          
//          res = Math.max(res, (i >0 ? pre4[i-1][j] + data[i-1][j] : 0)
//                  + (j > 0 ? pre2[i][j-1] + data[i][j-1] : 0)
//                  + (i < n-1 ? pre1[i+1][j] + data[i+1][j] : 0));
//          res = Math.max(res, (i >0 ? pre4[i-1][j] + data[i-1][j] : 0)
//                  + (j > 0 ? pre2[i][j-1] + data[i][j-1] : 0)
//                  + (j < m-1 ? pre1[i][j+1] + data[i][j+1] : 0) );
        }
    out.println(res);
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