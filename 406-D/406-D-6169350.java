import java.util.*;
import java.io.*;
public class d {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    PrintWriter out = new PrintWriter(System.out);
    int n = input.nextInt();
    Hill[] data = new Hill[n];
    for(int i = 0; i<n; i++) data[i] = new Hill(input.nextInt(), input.nextLong());
    int[] next = hull(data);
    //Process queries.
    LCT lct = new LCT(n);
    for(int i = 0; i<n-1; i++)
        lct.link(i, next[i]);
    int q = input.nextInt();
    for(int i = 0; i<q; i++)
    {
        int a = input.nextInt()-1, b = input.nextInt()-1;
        out.print((lct.LCA(a, b)+1)+" ");
    }
    out.close();
}
static int[] hull(Hill[] data)
{
    int n = data.length;
    int[] next = new int[n];
    int[] stk = new int[n+1];
    stk[++stk[0]] = n-1;
    for(int i = n-2; i>=0; i--)
    {
        while(stk[0] > 1)
        {
            int twoBefore = stk[stk[0]-1], prev = stk[stk[0]];
            long cross = (data[i].y - data[twoBefore].y) * (data[prev].x - data[twoBefore].x) -
                    (data[i].x - data[twoBefore].x) * (data[prev].y - data[twoBefore].y);
            if(cross < 0)
            {
                next[stk[stk[0]]] = stk[stk[0]-1];
                stk[0]--;
            }
            else break;
        }
        stk[++stk[0]] = i;
    }
    for(int i = stk[0]; i>1; i--) next[stk[i]] = stk[i-1];
    return next;
}
static class Hill
{
    int x;
    long y;
    public Hill(int xx, long yy)
    {
        x =xx; y = yy;
    }
}
public static class LCT
{
    int[] p, l, r, pp, val, prop;
    int NULL;
    LCT(int n)
    {
        val = new int[n+1];     //the value contained in each node
        prop = new int[n+1];    //lazily propagating value change
        Arrays.fill(p=new int[n+1],NULL=n); //make NULL n to avoid array out of bounds errors
        Arrays.fill(l=new int[n+1],NULL); //parent, left, and right refer to aux tree
        Arrays.fill(r=new int[n+1],NULL);
        Arrays.fill(pp=new int[n+1], NULL); //the root of each aux tree has one of these to that preferred path's top member's parent in represented tree
    }
    //increment everything on the simple path from v to w (going through their LCA)
    void incToLCA(int v, int w, int inc)
    {
        incPath(v, inc);
        incPath(w, inc);
        int lca = LCA(v,w);
        incPath(lca,-2*inc);
        //value[lca] += inc; //if you want to include the LCA in your incrementing
    }
    //returns the least common ancestor of two nodes in the represented tree
    int LCA(int v, int w)
    {
        access(v);
        access(w);
        splay(v);
        if(pp[v] == NULL) return v; //they're in the same aux tree, so w's path to the root passed through v -> answer is v
        return pp[v]; //the point at which the w-root path made the v-root path no longer preferred is where the two paths intersect, or pp[v]
    }
    //finds and splays root of v's represented tree
    int findRoot(int v)
    {
        access(v);
        while(l[v] != NULL) v = l[v];
        splay(v);
        return v;
    }
    //return value at v
    int val(int v)
    {
        access(v);
        return val[v];
    }
    //increment each node on v-root path by inc
    void incPath(int v, int inc)
    {
        access(v);
        val[v] += inc;
        prop[l[v]] += inc;
    }
    //w becomes v's parent
    //must be in different aux trees
    void link(int v, int w)
    {
        access(v);
        access(w);
        p[l[v]=w] = v;
    }
    //cuts off v from its parent
    void cut(int v)
    {
        access(v);
        p[l[v]] = NULL;
        l[v] = NULL;
    }
    void access(int v)
    {
        splay(v);
        //get rid of v's preferred child
        if(r[v] != NULL)
        {
            pp[r[v]] = v;
            p[r[v]] = NULL;
            r[v] = NULL;
        }
        //make v-root path preferred
        while(pp[v] != NULL)
        {
            int w = pp[v];
            splay(w);
            if(r[w]!=NULL)
                pp[r[w]] = w;
            p[r[w]] = NULL;
            r[w] = v;
            p[v] = w;
            pp[v] = NULL;
            lift(v);
        }
    }
    //splays vertex v (moves it to top of its aux tree)
    void splay(int v)
    {
        while(p[v] != NULL)
            if(p[p[v]] != NULL && (l[l[p[p[v]]]] == v || r[r[p[p[v]]]] == v)) lift(p[v]);
            else lift(v);
    }
    //lift x by one in its aux tree
    void lift(int x)
    {
        //take care of carry
        int inc = prop[p[x]];
        val[p[x]] += inc;
        prop[l[p[x]]] += inc;
        prop[r[p[x]]] += inc;
        prop[p[x]] = 0;
        val[x] += prop[x];
        prop[l[x]] += prop[x];
        prop[r[x]] += prop[x];
        prop[x] = 0;
        if(p[x] == NULL) return;
        pp[x] = pp[p[x]]; //move parent pointer to x if y is root
        pp[p[x]] = NULL;
        int y = p[x], z = p[y];
        p[p[y]=x] = z;
        if(z != NULL) //adjust grandparent's left/right pointer to point to x
            if(l[z] == y) l[z] = x; 
            else r[z] = x;
        if(l[y] == x) //zig (x<p[x])
        {
            if((l[y]=r[x])!=NULL) p[r[x]] = y;
            r[x] = y;           
        }
        else //zag (x>p[x])
        {
            if((r[y]=l[x])!=NULL) p[l[x]] = y;
            l[x] = y;
        }
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