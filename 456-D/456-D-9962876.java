import java.util.*;
import java.io.*;


public class B260 {
    static Trie[] states;
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    int n = input.nextInt(), k = input.nextInt();
    String[] data = new String[n];
    for(int i = 0; i<data.length; i++) data[i] = input.next();
    Trie.count = 0;
    Trie tr = new Trie();
    for(String s: data) tr.add(s, 0);
    //out.println(Trie.count);
    states = new Trie[Trie.count];
    tr.fill(states);
    winmemo = new Boolean[Trie.count];
    losememo = new Boolean[Trie.count];
    win(0);
    lose(0);
    //System.out.println(lose[0]);
    if(winmemo[0] && losememo[0]) System.out.println("First");
        else if(!winmemo[0]) System.out.println("Second");
        else System.out.println(k%2 == 1 ? "First" : "Second");
}
static Boolean[] losememo, winmemo;
static Boolean lose(int at)
{
    //if(states[at].end) return true;
    if(losememo[at] != null) return losememo[at];
    Boolean res = false;
    boolean leaf = true;
    for(Trie x : states[at].children)
    {
        if(x != null)
        {
            leaf = false;
            //System.out.println(at+" "+x.idx+" "+lose(x.idx));
            res |= !lose(x.idx);
        }
    }
    if(leaf) return losememo[at] = true;
    return losememo[at] = res;
    
}
static Boolean win(int at)
{
    //if(states[at].end) return false;
    if(winmemo[at] != null) return winmemo[at];
    Boolean res = false;
    for(Trie x : states[at].children)
    {
        if(x != null) res |= !win(x.idx);
    }
    return winmemo[at] = res;
    
}
static class Trie
{
    static int count;
    static int ALPHABET = 26;
    Trie[] children;
    boolean end;
    int idx;
    public Trie()
    {
        children = new Trie[ALPHABET];
        end = false;
        idx = count++;
    }
    void fill(Trie[] states)
    {
        states[idx] = this;
        for(Trie t : children) if(t != null) t.fill(states);
    }
    void add(String s, int idx)
    {
        if(idx == s.length())
        {
            end = true;
            return;
        }
        int next = s.charAt(idx) - 'a';
        if(children[next] == null)
        {
            this.end = false;
            children[next] = new Trie();
            //System.out.println(this.idx+" "+s+" "+idx+" "+children[next].idx);
        }
        children[next].add(s, idx+1);
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