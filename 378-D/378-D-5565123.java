import java.util.*;
import java.io.*;
public class b {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    PrintWriter out = new PrintWriter(System.out);
    
    n = input.nextInt();
    m = input.nextInt();
    s = input.nextInt();
    as = new int[m];
    for(int i = 0; i<m; i++) as[i] = input.nextInt();
    bugs = new Bug[m];
    for(int i = 0; i<m; i++) bugs[i] = new Bug(as[i], i);
    Arrays.sort(bugs);
    bs = new int[n];
    cs = new int[n];
    for(int i = 0; i<n; i++) bs[i] = input.nextInt();
    for(int i = 0; i<n; i++) cs[i] = input.nextInt();
    students = new Student[n];
    for(int i = 0; i<n; i++) students[i] = new Student(bs[i], cs[i], i);
    Arrays.sort(students);
    int lo = 1, hi = 1000000;
    while(lo + 1 < hi)
    {
        int mid = (lo+hi)/2;
        if(good(mid)) hi = mid;
        else lo = mid;
    }
    if(good(lo)) hi--;
    else good(hi);
    //System.out.println(lo+" "+hi);
    out.println(hi < 200000 ? "YES" : "NO");
    if(hi < 200000)
    {
        for(int i = 0; i<m; i++) out.print(res[i]+" ");
    }
    out.close();
}
static int[] res;
static boolean good(int t)
{
    int ats = 0, atb = 0;
    res = new int[m];
    Arrays.fill(res, -1);
    long passes = 0;
    PriorityQueue<Student2> pq = new PriorityQueue<Student2>();
    while(atb < m)
    {
        while(ats < n && students[ats].b >= bugs[atb].a)
        {
            pq.add(new Student2(students[ats]));
            ats++;
        }
        if(pq.isEmpty()) return false;
        Student2 use = pq.poll();
        for(int i = 0; i<t && atb<m; i++)
        {
            res[bugs[atb].i] = use.i+1;
            atb++;
        }
        passes += use.c;
    }
    return passes <= s;
}
static class Bug implements Comparable<Bug>
{
    int a, i;
    public Bug(int aa, int ii)
    {
        a = aa; i =ii;
    }
    @Override
    public int compareTo(Bug o) {
        // TODO Auto-generated method stub
        return o.a-a;
    }
}
static class Student implements Comparable<Student>
{
    int b, c, i;
    public Student(int bb, int cc, int ii)
    {
        b = bb; c = cc; i = ii;
    }
    @Override
    public int compareTo(Student o) {
        // TODO Auto-generated method stub
        return o.b-b;
    }
}
static class Student2 implements Comparable<Student2>
{
    int b, c, i;
    public Student2(Student s)
    {
        b = s.b; c = s.c; i = s.i;
    }
    @Override
    public int compareTo(Student2 o) {
        // TODO Auto-generated method stub
        return c-o.c;
    }
}
static int n, m, s;
static Bug[] bugs;
static Student[] students;
static int[] as, bs, cs;
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