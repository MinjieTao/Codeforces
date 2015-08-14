import java.util.*;
import java.io.*;
public class a {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    PrintWriter out = new PrintWriter(System.out);
    int n = input.nextInt(), k = input.nextInt();
    Node[] data = new Node[n];
    for(int i = 0; i<n; i++) data[i] = new Node(i, input.nextInt());
    Arrays.sort(data);
    if(data[0].d != 0 || n> 1 && data[1].d == 0)
    {
        out.println(-1);
        out.close();
        return;
    }
    int[] used = new int[n];
    ArrayList<Integer> as = new ArrayList<Integer>(), bs = new ArrayList<Integer>();
    int first = 0, second = 1;
    boolean valid =true;
    while(second < n)
    {
        //System.out.println("A: "+second+" "+data[second].d);
        while(data[first].d < data[second].d - 1) first++;
        while(first < second && used[first] >= k) first++;
        if(data[first].d != data[second].d - 1)
        {
            valid = false;
            break;
        }
        //out.println(first);
        as.add(data[first].i);
        bs.add(data[second].i);
        used[first]++;
        used[second]++;
        second++;
    }
    if(!valid) out.println(-1);
    else
    {
        out.println(as.size());
        for(int i =0; i<as.size(); i++)
        {
            out.println((1+as.get(i)) + " " + (1+bs.get(i)));
        }
    }
    out.close();
}
static class Node implements Comparable<Node>
{
    int i, d;
    public Node(int ii, int dd)
    {
        i = ii; d = dd;
    }
    @Override
    public int compareTo(Node o) {
        // TODO Auto-generated method stub
        return d - o.d;
    }
}
}