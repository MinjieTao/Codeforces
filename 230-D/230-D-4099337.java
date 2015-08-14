import java.util.*;
import java.io.*;
public class b {
public static void main(String[] args) throws IOException
{
    Reader.init(System.in);
    //Scanner input = new Scanner(System.in);
    int n = Reader.nextInt(), m = Reader.nextInt();
    ArrayList<Planet> planets = new ArrayList<Planet>();
    for(int i = 0; i<n; i++)
        planets.add(new Planet());
    for(int i = 0; i<m; i++)
    {
        int a = Reader.nextInt()-1, b = Reader.nextInt()-1, len = Reader.nextInt();
        planets.get(a).edges.add(new Edge(b, len));
        planets.get(b).edges.add(new Edge(a, len));
    }
    for(int i = 0; i<n; i++)
    {
        int k = Reader.nextInt();
        for(int j = 0; j<k; j++)
        {
            planets.get(i).travelers.add((long)Reader.nextInt());
        }
    }
    PriorityQueue<State> q = new PriorityQueue<State>();
    long[] visited = new long[n];
    Arrays.fill(visited, (long)1e18);
    visited[0] = 0;
    q.add(new State(0, 0));
    long res = -1;
    while(!q.isEmpty())
    {
        State cur = q.poll();
        Planet at = planets.get(cur.at);
        long time = cur.time;
        if(cur.at == n-1)
        {
            res = time;
            break;
        }
        if(at.travelers.contains(time))
        {
            q.offer(new State(cur.at, time+1));
            continue;
        }
        for(Edge e: at.edges)
        {
            if(visited[e.to] > time + e.len)
            {
                visited[e.to] = time + e.len;
                q.offer(new State(e.to, time + e.len));
            }
        }
    }
    System.out.println(res);
}
public static class State implements Comparable<State>
{
    int at;
    long time;
    public State(int at, long time)
    {
        this.at = at;
        this.time = time;
    }
    @Override
    public int compareTo(State that) {
        // TODO Auto-generated method stub
        return this.time > that.time ? 1: -1;
    }
}
public static class Planet
{
    TreeSet<Long> travelers;
    ArrayList<Edge> edges;
    public Planet()
    {
        edges = new ArrayList<Edge>();
        travelers = new TreeSet<Long>();
    }
}
public static class Edge
{
    int to, len;
    public Edge(int to, int len)
    {
        this.to = to;
        this.len = len;
    }
}
public static class Reader {
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
}
}