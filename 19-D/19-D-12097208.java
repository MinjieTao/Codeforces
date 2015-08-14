import java.util.*;
import java.io.*;
public class d19 {
public static void main(String[] args) throws IOException
{
  input.init(System.in);
  PrintWriter out = new PrintWriter(System.out);
  int n = input.nextInt();
  String[] ss = new String[n];
  int[] xs = new int[n], ys = new int[n];
  ArrayList<Integer> set = new ArrayList<Integer>();
  for(int i = 0; i<n; i++)
  {
    ss[i] = input.next();
    xs[i] = input.nextInt();
    ys[i] = input.nextInt();
    if(!ss[i].equals("remove"))set.add(xs[i]);
    //set.add(ys[i]);
  }
  Collections.sort(set);
  //HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
  IT it = new IT(set.size());
  int at = 0;
//  int[] rev = new int[set.size()];
//  for(int x : set)
//  {
//    //map.put(x, at);
//    rev[at] = x;
//    at++;
//  }
  for(int i = 0; i<n; i++)
  {
    xs[i] = Collections.binarySearch(set, xs[i]);
    //xs[i] = map.get(xs[i]);
    //ys[i] = map.get(ys[i]);
  }
  TreeSet<Integer>[]  setmap = new TreeSet[set.size()];
  
  for(int i = 0; i<n; i++)
  {
    if(ss[i].equals("add"))
    {
      if(setmap[xs[i]] == null) setmap[xs[i]] = new TreeSet<Integer>();
      TreeSet<Integer> curSet = setmap[xs[i]];
      int max = curSet.size() > 0 ? curSet.last() : 0;
      curSet.add(ys[i]);
      if(ys[i] > max) it.add(xs[i], ys[i] - max);
    }
    else if(ss[i].equals("remove"))
    {
      TreeSet<Integer> curSet = setmap[xs[i]];
      curSet.remove(ys[i]);
      int max = curSet.size() > 0 ? curSet.last() : 0;
      if(max < ys[i]) it.add(xs[i], max - ys[i]);
    }
    else if(ss[i].equals("find"))
    {
      int hi = it.get(xs[i]+1, set.size()-1, ys[i]);
      //System.out.println(hi);
      if(hi == set.size()) out.println(-1);
      else
      {
        TreeSet<Integer> curSet = setmap[hi];
        int yval = curSet.higher(ys[i]);
        out.println(set.get(hi)+" "+yval);
      }
    }
  }
  out.close();
}
public static class input {
  static BufferedReader reader;
  static StringTokenizer tokenizer;
  static void init(InputStream input) {
      reader = new BufferedReader(
                   new InputStreamReader(input) );
      tokenizer = new StringTokenizer("");
  }
  static String next() throws IOException {
      while ( ! tokenizer.hasMoreTokens() ) {
          tokenizer = new StringTokenizer(
                 reader.readLine() );
      }
      return tokenizer.nextToken();
  }
  static int nextInt() throws IOException {
      return Integer.parseInt( next() );
  }
}
//Minimum Interval Tree
static class IT
{
  int[] left,right, val, a, b, prop;
  IT(int n)
  {
      left = new int[4*n];
      right = new int[4*n];
      val = new int[4*n];
      prop = new int[4*n];
      a = new int[4*n];
      b = new int[4*n];
      init(0,0, n-1);
  }
  int init(int at, int l, int r)
  {
      a[at] = l;
      b[at] = r;
      if(l==r)
          left[at] = right [at] = -1;
      else 
      {
          int mid = (l+r)/2;
          left[at] = init(2*at+1,l,mid);
          right[at] = init(2*at+2,mid+1,r);
      }
      return at++;
  }
  //return the min over [x,y]
  int get(int x, int y, int val)
  {
      return go(x, y, 0, val);
  }
//  void push(int at)
//  {
//      if(prop[at] != 0)
//      {
//          go3(a[left[at]], b[left[at]], prop[at], left[at]);
//          go3(a[right[at]], b[right[at]], prop[at], right[at]);
//          prop[at] = 0;
//      }
//  }
  int go(int x, int y, int at, int v)
  {
      if(at==-1 || y < a[at] || x>b[at]) return b[at]+1;
      if(x <= a[at] && y>= b[at])
      {
        if(val[at] <= v) return b[at] + 1;
        //return val[at];
      }
      if(a[at] == b[at]) return val[at] > v ? a[at] : a[at]+1;
      //push(at);
      int leftAns = go(x, y, left[at], v);
      if(leftAns <= b[left[at]]) return leftAns;
      return go(x, y, right[at], v);
      //return Math.max(go(x, y, left[at]), go(x, y, right[at]));
  }
  //add v to elements x through y
  void add(int x, int v)
  {
      go3(x, v, 0);
  }
  void go3(int x, int v, int at)
  {
      if(at==-1) return;
      if(x < a[at] || x > b[at]) return;
      x = Math.max(x, a[at]);
      x = Math.min(x, b[at]);
      if(x == b[at] && x == a[at])
      {
          val[at] += v;
          prop[at] += v;
          return;
      }
      //push(at);
      go3(x, v, left[at]);
      go3(x, v, right[at]);
      val[at] = Math.max(val[left[at]], val[right[at]]);
  }
}
}