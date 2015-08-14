import java.util.*;
public class d {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt(), m = input.nextInt();
    Segment[] vert = new Segment[n], horiz = new Segment[m];
    for(int i = 0; i<n; i++)
    {
        vert[i] = new Segment(input.nextInt(), input.nextInt(), input.nextInt(), true);
    }
    for(int i = 0; i<m; i++)
    {
        horiz[i] = new Segment(input.nextInt(), input.nextInt(), input.nextInt(), false);
    }
    long lo = 0, hi = (long)(1e9+10);
    while(lo < hi - 1)
    {
        int mid = (int)(lo+hi)/2;
        ArrayList<Segment> nv = new ArrayList<Segment>(), nh = new ArrayList<Segment>();
        for(int i = 0; i<n; i++)
        {
            Segment s = vert[i].diff(mid);
            if(s != null) nv.add(s);
        }
        for(int i = 0; i<m; i++)
        {
            Segment s = horiz[i].diff(mid);
            if(s != null) nh.add(s);
        }
        //System.out.println(mid+" "+nv.size()+" "+nh.size());
        //for(Segment s : nv) System.out.println(s.x+" "+s.y+" "+s.y2+" "+s.l);
        if(intersect(nv, nh)) lo = mid;
        else hi = mid;
    }
    System.out.println(lo);
}
static boolean intersect(ArrayList<Segment> vert, ArrayList<Segment> horiz)
{
    int at = compressY(vert, horiz);
    BIT bit = new BIT(at + 1);
    PriorityQueue<Event> pq = new PriorityQueue<Event>();
    for(Segment s : vert)
    {
        pq.add(new Event((int)s.x, (int)s.y, (int)(s.y2), 0));
    }
    for(Segment s : horiz)
    {
        pq.add(new Event((long)s.x, (int)s.y, (int)s.y, 1));
        pq.add(new Event((long)(s.x+s.l), (int)s.y, (int)s.y, -1));
    }
    while(!pq.isEmpty())
    {
        Event e = pq.poll();
        //System.out.println(e.type+" "+e.y1+" "+e.y2);
        if(e.type == 1) bit.upd(e.y1, 1);
        else if(e.type == -1) bit.upd(e.y1, -1);
        else
        {
            if(bit.csum(e.y1, e.y2) > 0) return true;
        }
    }
    return false;
}
static class Event implements Comparable<Event>
{
    long x;
    int y1, y2;
    int type;
    public Event(long xx, int yy1, int yy2, int tt)
    {
        x = xx; y1 = yy1; y2 = yy2; type = tt;
    }
    @Override
    public int compareTo(Event o) {
        // TODO Auto-generated method stub
        if(x != o.x) return (int)Long.signum(x - o.x);
        return o.type - type;
    }
}
static int compressY(ArrayList<Segment> vert, ArrayList<Segment> horiz)
{
    TreeSet<Long> set = new TreeSet<Long>();
    for(Segment s : vert)
    {
        set.add(s.y);
        set.add(s.y2);
    }
    for(Segment s : horiz) set.add(s.y);
    HashMap<Long, Integer> map = new HashMap<Long, Integer>();
    int at = 0;
    for(long x : set) map.put(x, ++at);
    for(Segment s : vert)
    {
        s.y = map.get(s.y);
        s.y2 = map.get(s.y2);
    }
    for(Segment s : horiz) s.y = map.get(s.y);
    return at;
}
static class Segment
{
    long x, y, l, y2;
    boolean vert;
    public Segment(long xx, long yy, long ll, boolean b)
    {
        x = xx; y = yy; l = ll; vert = b; y2 = y + l;
    }
    Segment diff(int cross)
    {
        long nx = x;
        long ny = y;
        long nl = l - 2 * cross;
        if(nl < 0) return null;
        if(vert) ny += cross;
        else nx += cross;
        return new Segment(nx, ny, nl, vert);
    }
}
/*
 * Binary Indexed Tree - used for updates and range queries.  Every operation is O(log(n)).
 * Note: It is possible to make it do range updates and single element queries.  To do so,
 * the following is required: upd(a, v); upd(b+1, -v);  (Be careful of bounds on right side!)
 * Then, a point query is simply csum(x).
 */
static class BIT
{
    int[] tree;
    int n;
    BIT(int n)
    {
        tree = new int[n+1];
        this.n = n;
    }
    /*
     * Increases the value at x by v.
     */
    void upd(int x, int v)
    {
        int i = x;
        while(i<=n)
        {
            tree[i]+=v;
            i += (i&-i);
        }
    }
    /*
     * Returns the sum of the first x elements.
     */
    int csum(int x)
    {
        int s = 0;
        while(x>0)
        {
            s += tree[x];
            x -= (x&-x);
        }
        return s;
    }
    /*
     * Returns the sum of elements x through y, inclusive.
     */
    int csum(int x, int y)
    {
        return csum(y) - csum(x-1);
    }
    /*
     * Returns the xth value in the tree.
     */
    int get(int x)
    {
        int sum = tree[x];
        int z = x - (x&-x);
        x--;
        while(x>z)
        {
            sum -= tree[x];
            x -= (x&-x);
        }
        return sum;
    }
    /*
     * Multiplies every element in the tree by a.
     */
    void scale(int a)
    {
        for(int i = 1; i<=n; i++) tree[i] *= a;
    }
}
}