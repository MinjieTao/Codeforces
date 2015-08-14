import java.util.*;
import java.io.*;
public class B257 {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    int n = input.nextInt(), m = input.nextInt(), k = input.nextInt();
    ArrayList<Edge>[] g = new ArrayList[n];
    for(int i = 0; i<n; i++) g[i] = new ArrayList<Edge>();
    boolean[] needTrain = new boolean[n];
    long[] trainDist = new long[n];
    Arrays.fill(trainDist, (long)1e18);
    trainDist[0] = 0;
    for(int i = 0; i<m; i++)
    {
        int a = input.nextInt()-1, b = input.nextInt()-1, c = input.nextInt();
        g[a].add(new Edge(b, c));
        g[b].add(new Edge(a, c));
    }
    for(int i = 0; i<k; i++)
    {
        int to = input.nextInt()-1;
        int dist = input.nextInt();
        needTrain[to] = true;
        trainDist[to] = Math.min(trainDist[to], dist);
    }
    //System.out.println(Arrays.toString(trainDist));
    PriorityQueue<State> pq = new PriorityQueue<State>();
    pq.add(new State(0, 0));
    for(int i = 1; i<n; i++)
        if(needTrain[i])
        {
            pq.add(new State(i, trainDist[i]));
            //System.out.println(i+" "+trainDist[i]);
        }
    long[] dist = new long[n];
    for(int i = 0; i<n; i++) dist[i] = trainDist[i];
    //System.out.println(Arrays.toString(dist));
    while(!pq.isEmpty())
    {
        State at = pq.poll();
        //System.out.println(at.at+" "+at.dist);
        //if(at.dist > 1e9) break;
        if(at.dist > dist[at.at]) continue;
        for(Edge e: g[at.at])
        {
            long nd = at.dist + e.dist;
            //System.out.println(at.at+" "+at.dist+" "+e.to+" "+e.dist+" "+nd);
            if(nd <= trainDist[e.to]) needTrain[e.to] = false;
            if(nd < dist[e.to])
            {
                dist[e.to] = nd;
                pq.add(new State(e.to, nd));
            }
        }
    }
    int need = 0;
    for(int i = 1; i<n; i++)
        if(needTrain[i])
            need++;
    System.out.println(k - need);
}
static class Edge
{
    int to, dist;
    public Edge(int tt, int dd)
    {
        to = tt; dist = dd;
    }
}
static class State implements Comparable<State>
{
    int at;
    long dist;
    public State(int aa, long dd)
    {
        at = aa; dist = dd;
    }
    @Override
    public int compareTo(State o) {
        // TODO Auto-generated method stub
        return (int)Long.signum(dist - o.dist);
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