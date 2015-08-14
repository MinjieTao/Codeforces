import java.util.*;
public class a {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int[] ds = new int[n], vs = new int[n];
    for(int i = 0; i<n; i++)
    {
        ds[i] = input.nextInt();
        vs[i] = input.nextInt();
    }
    Queue<Integer> q = new LinkedList<Integer>();
    ArrayList<Integer> as = new ArrayList<Integer>(), bs = new ArrayList<Integer>();
    for(int i = 0; i<n; i++) if(ds[i] == 1) q.add(i);
    while(!q.isEmpty())
    {
        int at = q.poll();
        if(ds[at] == 0) continue;
        as.add(at);
        bs.add(vs[at]);
        vs[vs[at]] ^= at;
        ds[vs[at]]--;
        if(ds[vs[at]] == 1) q.add(vs[at]);
    }
    System.out.println(as.size());
    for(int i = 0; i<as.size(); i++) System.out.println(as.get(i)+" "+bs.get(i));
}
}