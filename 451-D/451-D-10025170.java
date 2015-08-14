import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
public class a {

    public static void main(String[] args) throws IOException {
        input.init(System.in);
        long even = 0, odd = 0;
        int eas = 0, ebs = 0, oas = 0, obs = 0;
        char[] s= input.next().toCharArray();
        for(int i = 0; i<s.length; i++)
        {
            if(i%2 == 0)
            {
                if(s[i] == 'a')
                {
                    eas++;
                    even += oas;
                    odd += eas;
                }
                else
                {
                    ebs++;
                    even += obs;
                    odd += ebs;
                }
            }
            else
            {
                if(s[i] == 'a')
                {
                    oas++;
                    even += eas;
                    odd += oas;
                }
                else
                {
                    obs++;
                    even += ebs;
                    odd += obs;
                }
            }
        }
        System.out.println(even+" "+odd);
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