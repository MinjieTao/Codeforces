import java.util.*;
public class a {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        ArrayList<Integer>[] g = new ArrayList[n];
        for(int i = 0; i<n; i++) g[i] = new ArrayList<Integer>();
        for(int i = 0; i<n-1; i++)
        {
            int a = input.nextInt()-1, b = input.nextInt()-1;
            g[a].add(b);
            g[b].add(a);
        }
        ArrayList<Integer> heads = new ArrayList<Integer>();
        ArrayList<Integer> bad1 = new ArrayList<Integer>(), bad2 = new ArrayList<Integer>();
        int comp = 0;
        int[] prev = new int[n];
        Arrays.fill(prev, -1);
        for(int i = 0; i<n; i++)
        {
            if(prev[i]>-1) continue;
            heads.add(i+1);
            Queue<Integer> q = new LinkedList<Integer>();
            q.add(i);
            prev[i] = -2;
            while(!q.isEmpty())
            {
                int at = q.poll();
                for(int x: g[at])
                {
                    if(prev[x]==-1)
                    {
                        prev[x] = at;
                        q.add(x);
                    }
                    else if(x != prev[at] && x>at)
                    {
                        bad1.add(x+1);
                        bad2.add(at+1);
                        //System.out.println(x+" "+at);
                    }
                }
            }
        }
        System.out.println(bad1.size());
        for(int i = 0; i<bad1.size(); i++)
        {
            System.out.println(bad1.get(i) + " "+ bad2.get(i) + " "+ heads.get(i)+" "+heads.get((i+1)%heads.size()));
        }
    }

}