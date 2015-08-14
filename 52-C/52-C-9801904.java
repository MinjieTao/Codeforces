import java.util.*;
import java.io.*;
public class LCTTest {
public static void main(String[] args) throws IOException
{
    //Scanner input = new Scanner(System.in);
    PrintWriter out = new PrintWriter(System.out);
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] data = new int[n];
    StringTokenizer str = new StringTokenizer(br.readLine());
    for(int i = 0; i<n; i++) data[i] = Integer.parseInt(str.nextToken());
    LCT lct = new LCT(n, Node.MIN);
    for(int i = 0; i<n; i++) lct.add(i,  i, data[i]);
    for(int i= 0; i<n-1; i++) lct.link(i, i+1);
    int m = Integer.parseInt(br.readLine());
    //input.nextLine();
    for(int i = 0; i<m; i++)
    {
        //String[] query = new String[]{"0", "199999", "-1000000"};
       String[] query = br.readLine().split(" ");
        int a = Integer.parseInt(query[0]), b = Integer.parseInt(query[1]);
        if(query.length == 2)
        {
            out.println(a > b ? Math.min(lct.sum(a, n-1), lct.sum(0, b)) : lct.sum(a,  b));
        }
        else
        {
            int v = Integer.parseInt(query[2]);
            if(a <= b) lct.add(a, b, v);
            else
            {
                lct.add(a, n-1, v);
                lct.add(0, b, v);
            }
            //for(int j = 0; j<n; j++) out.print(lct.sum(j, j)+" ");
            //out.println();
        }
        
    }
    out.close();
}
static class Node
{
    static int SUM = 0, MIN = 1, MAX = 2;
    Node left, right, parent;
    int size;
    int id;
    boolean revert;
    int type;
    long delta, nodeValue, subtreeValue;
    Node(int i, int t)
    {
        id = i;
        type = t;
    }
    boolean isRoot()
    {
        if(parent == null) return true;
        if(parent.left == this || parent.right == this) return false;
        return true;
    }
    void push()
    {
        if (revert)
        {
            revert = false;
            Node t = left;
            left = right;
            right = t;
            if (left != null) left.revert = !left.revert;
            if (right != null) right.revert = !right.revert;
        }
        if (left != null) left.delta += delta;
        if (right != null) right.delta += delta;
        nodeValue += delta;
        if(type == SUM) subtreeValue += delta * size;
        else subtreeValue += delta;
        delta = 0;
    }
    void update()
    {
        size = 1;
        subtreeValue = nodeValue;
        if (left != null)
        {
            if(type == SUM) subtreeValue += left.subtreeValue + left.delta * left.size;
            else if(type == MIN) subtreeValue = Math.min(subtreeValue, left.subtreeValue + left.delta);
            else if(type == MAX) subtreeValue = Math.max(subtreeValue, left.subtreeValue + left.delta);
            size += left.size;
        }
        if (right != null)
        {
            if(type == SUM) subtreeValue += right.subtreeValue + right.delta * right.size;
            else if(type == MIN) subtreeValue = Math.min(subtreeValue, right.subtreeValue + right.delta);
            else if(type == MAX) subtreeValue = Math.max(subtreeValue, right.subtreeValue + right.delta);
            size += right.size;
        }
    }
}
/*
 * Makes p the parent of ch.
 * If type = 0, ch is the left child.
 * If type = 1, ch is the right child. 
 */
static class LCT
{
    Node[] nodes;
    LCT(int n, int type)
    {
        nodes = new Node[n];
        for(int i = 0; i<n; i++) nodes[i] = new Node(i, type);
    }
    void connect(Node ch, Node p, int type)
    {
        if (ch != null) ch.parent = p;
        if(type == 0) p.left = ch;
        else if(type == 1) p.right = ch;
    }
    void rotate(Node x)
    {
        Node p = x.parent, g = p.parent;
        boolean isRootP = p.isRoot();
        boolean leftChildX = (x == p.left);
    
        // create 3 edges: (x.r(l),p), (p,x), (x,g)
        connect(leftChildX ? x.right : x.left, p, leftChildX ? 0 : 1);
        connect(p, x, leftChildX ? 1 : 0);
        connect(x, g, isRootP ? 2 : (p == g.left ? 0 : 1));
        p.update();
    }
    void splay(Node x)
    {
        while (!x.isRoot())
        {
            Node p = x.parent, g = p.parent;
            if (!p.isRoot()) g.push();
            p.push();
            x.push();
            if (!p.isRoot()) rotate((x == p.left) == (p == g.left) ? p/*zig-zig*/ : x/*zig-zag*/);
            rotate(x);
        }
        x.push();
        x.update();
    }
    /*
     * Makes q the root of its tree of splay trees.
     */
    Node access(Node q)
    {
        Node r = null;
        for(Node p = q; p != null; p = p.parent)
        {
            splay(p);
            p.left = r;
            p.update();
            r = p;
        }
        splay(q);
        return r;
    }
    void makeRoot(Node x)
    {
        access(x);
        x.revert = !x.revert;
    }
    /*
     * Makes p the parent of q.
     */
    void link(int pp, int qq)
    {
        Node p = nodes[pp], q = nodes[qq];
        if (connected(p, q)) throw new RuntimeException("error: x and y are already connected");
        makeRoot(p);
        p.parent = q;
    }
    int findRoot(Node p)
    {
        access(p);
        while(p.right != null) p = p.right;
        splay(p);
        return p.id;
    }
    void cut(int pp, int qq)
    {
        Node p = nodes[pp], q = nodes[qq];
        makeRoot(p);
        access(q);
        if (q.right != p || p.left != null || p.right != null) throw new RuntimeException("error: no edge (x,y)");
        q.right.parent = null;
        q.right = null;
    }
    long sum(int from, int to)
    {
        makeRoot(nodes[from]);
        access(nodes[to]);
        return nodes[to].subtreeValue;
    }
    void add(int from, int to, int delta)
    {
        makeRoot(nodes[from]);
        access(nodes[to]);
        nodes[to].delta += delta;
    }
    boolean connected(Node p, Node q)
    {
        if(p == q) return true;
        access(p);
        access(q);
        return p.parent != null;
    }
    Node lca(Node x, Node y) {
        if (findRoot(x) != findRoot(y)) throw new RuntimeException("error: x and y are not connected");
        access(x);
        return access(y);
    }
}
}