import java.util.*;
import java.io.*;
public class a {
    static int[] heights;
    static int[] block;
    static int[] second;
    static int size;
    static int oo = (int)(1e9+1);
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    int n = input.nextInt();
    int[] ps = new int[n];
    ArrayList<Integer>[] gin = new ArrayList[n];
    for(int i = 0; i<n; i++) gin[i] = new ArrayList<Integer>();
    heights = new int[n];
    for(int i = 0; i<n; i++) heights[i] = input.nextInt();
    for(int i = 0; i<n-1; i++)
    {
        int a = input.nextInt()-1, b = input.nextInt()-1;
        gin[a].add(b);
        gin[b].add(a);
    }
    int m = input.nextInt();
    int[] miners = new int[m];
    for(int i = 0; i<m; i++) miners[i] = input.nextInt();
    Arrays.sort(miners);
    Queue<Integer> q = new LinkedList<Integer>();
    Arrays.fill(ps, -1);
    ps[0] = -2;
    q.add(0);
    block = new int[n];
    second = new int[n];
    second[0] = -1;
    block[0] = 0;
    while(!q.isEmpty())
    {
        int at = q.poll();
        for(int e : gin[at])
        {
            if(e == ps[at]) continue;
            ps[e] = at;
            q.add(e);
            block[e] = block[at];
            second[e] = second[at];
            if(heights[e] < heights[block[e]])
            {
                second[e] = block[e];
                block[e] = e;
            }
            else if(second[e] == -1 || heights[e] < heights[second[e]])
            {
                second[e] = e;
            }
        }
    }
    ArrayList<Integer>[] bg = new ArrayList[n];
    for(int i = 0; i<n; i++) bg[i] = new ArrayList<Integer>();
    for(int i = 0; i<n; i++)
    {
        bg[block[i]].add(i);
    }
    ArrayList<Group> groups = new ArrayList<Group>();
    for(int i = 0; i<n; i++)
    {
        if(bg[i].size() > 0)
        {
            groups.add(new Group(i, bg[i]));
        }
    }
    Collections.sort(groups);
//  for(Group g : groups)
//  {
//      System.out.println(g.block);
//      for(int x : g.list) System.out.print(x+" "); 
//      System.out.println("\n");
//  }
Queue<Integer> extras = new LinkedList<Integer>();
    int done = 0;
    int cnt = groups.size();
    int[] pref = new int[cnt];
    for(int i = 0; i<cnt; i++)
    {
        int start = done;
        //System.out.println(done+" "+miners[done]+" "+heights[groups.get(i).block]);
        while(done - start < groups.get(i).list.size() && done < m && miners[done] <= heights[groups.get(i).block]) done++;
        pref[i] = done;
    }
    //System.out.println(Arrays.toString(pref));
    if(pref[cnt-1] == m)
    {
        System.out.println(0);
        return;
    }
    TreeMap<Integer, Integer> need = new TreeMap<Integer, Integer>();
    size = 0;
    for(int i = pref[cnt-1]; i<m; i++) add(need, miners[i]);
    int res = oo;
    for(int i = cnt-1; i>=0; i--)
    {
        for(int j = (i == 0 ? 0 : pref[i-1]); j<pref[i]; j++)
        {
            add(need, miners[j]);
        }
        while(!extras.isEmpty() && remove(need, need.floorKey(extras.peek()))) extras.poll();
        //System.out.println(size);
//      for(int x : need.keySet())
//      {
//          System.out.print("("+x+","+need.get(x)+") ");
//      }
//      System.out.println();
        ArrayList<Integer> list = groups.get(i).list;
        int rsize = list.size();
        int[] rem = new int[rsize];
        for(int j = 0; j<rsize; j++)
        {
            rem[j] = second[list.get(j)] == -1 ? oo : heights[second[list.get(j)]];
        }
        if(size <= rsize)
        {
            
            Arrays.sort(rem);
            //System.out.println(Arrays.toString(rem));
            int ptr = rsize - size;
            int maxDiff = 0;
            boolean good = true;
            int block = heights[groups.get(i).block];
            for(Integer x : need.keySet())
            {
                for(int j = 0; j<need.get(x) && good; j++)
                {
                    //System.out.println(x+" "+rsize+" "+ptr);
                    good &= x - rem[ptr++] <= 0;
                    maxDiff = Math.max(maxDiff, x - block);
                }
                if(!good) break;
            }
            if(good) res = Math.min(res, maxDiff);
        }
        int[] hs = new int[list.size()];
        for(int j = 0; j<list.size(); j++) hs[j] = heights[list.get(j)];
        Arrays.sort(hs);
        for(int x : hs)
        {
            if(!remove(need, need.floorKey(heights[groups.get(i).block]))) extras.add(heights[groups.get(i).block]);
        }
        
    }
    System.out.println(res == oo ? -1 : res);
}
static void add(TreeMap<Integer, Integer> map, int x)
{
    if(!map.containsKey(x)) map.put(x, 1);
    else map.put(x, map.get(x)+1);
    size++;
}
static boolean remove(TreeMap<Integer, Integer> map, Integer x)
{
    if(x == null || !map.containsKey(x)) return false;
    if(map.get(x) == 1) map.remove(x);
    else map.put(x, map.get(x)-1);
    size--;
    return true;
}
static class Group implements Comparable<Group>
{
    int block;
    ArrayList<Integer> list;
    public Group(int bb, ArrayList<Integer> ll)
    {
        block = bb; list = ll;
    }
    @Override
    public int compareTo(Group o) {
        // TODO Auto-generated method stub
        return heights[block] - heights[o.block];
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