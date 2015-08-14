import java.util.*;
import java.io.*;
public class c {
    static int oo = 987654321;
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    PrintWriter out = new PrintWriter(System.out);
    
    int n = input.nextInt();
    
    data = new int[n][];
    for(int i = 0; i<n; i++)
    {
        data[i] = new int[input.nextInt()];
        for(int j = 0; j<data[i].length; j++) data[i][j] = input.nextInt();
    }
    memo = new int[n][100][100][2];
    for(int[][][] A: memo) for(int[][] B: A) for(int[] C: B) Arrays.fill(C, oo);
    for(int i = 0; i<n; i++)
        for(int j =0; j<2; j++)
            dp(i, 0, data[i].length-1, j);
    int[] res = new int[2];
    int turn = 1;
    int sum = 0;
    for(int i = 0; i<n; i++) sum += data[i].length;
    int[] as = new int[n], bs = new int[n];
    for(int i = 0; i<n; i++) bs[i] = data[i].length - 1;
    for(int i= 0; i<sum; i++)
    {
        turn = 1 - turn;
        int idx = -1;
        int bestScore = -oo;
        for(int p = 0; p<n; p++)
        {
            if(as[p] > bs[p]) continue;
            int score = dp(p, as[p], bs[p], turn);
            int other = dp(p, as[p], bs[p], 1 - turn);
            if(score+other > bestScore)
            {
                bestScore = score+other;
                idx = p;
            }
        }
        if(turn == 0)
        {
            res[turn] += data[idx][as[idx]];
            as[idx]++;
        }
        else
        {
            res[turn] += data[idx][bs[idx]];
            bs[idx]--;
        }
    }
    out.println(res[0]+" "+res[1]);
    
    out.close();
}
static int[][][][] memo;
static int[][] data;
static int dp(int pile, int a, int b, int turn)
{
    if(memo[pile][a][b][turn] != oo) return memo[pile][a][b][turn];
    if(a == b) return memo[pile][a][b][turn] = data[pile][a];
    if(turn == 0) return memo[pile][a][b][turn] = data[pile][a] - dp(pile, a+1, b, 1-turn);
    else return memo[pile][a][b][turn] = data[pile][b] - dp(pile, a, b-1, 1-turn);
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