import java.util.*;
public class d {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int k = input.nextInt();
    int[] ns = new int[3], ts = new int[3];
    for(int i = 0; i<3; i++) ns[i] = input.nextInt();
    for(int i = 0; i<3; i++) ts[i] = input.nextInt();
    PriorityQueue<Event> pq = new PriorityQueue<Event>();
    for(int i = 0; i<ns[0] && i < k; i++) pq.add(new Event(ts[0], 1));
    k -= Math.min(ns[0], k);
    int res = 0;
    ns[0] = 0;
    int doneWash = 0, doneDry = 0;
    while(!pq.isEmpty())
    {
        Event at = pq.poll();
        res = at.time;
        //System.out.println(at.time+" "+at.type+" "+Arrays.toString(ns));
        if(at.type == 3)
        {
            ns[2]++;
            if(doneDry > 0)
            {
                ns[2]--;
                doneDry--;
                ns[1]++;
                pq.add(new Event(at.time + ts[2], 3));
                if(doneWash > 0 && ns[1] > 0)
                {
                    doneWash--;
                    ns[1]--;
                    ns[0]++;
                    if(k > 0 && ns[0] > 0)
                    {
                        k--;
                        ns[0]--;
                        pq.add(new Event(at.time + ts[0], 1));
                    }
                    pq.add(new Event(at.time + ts[1], 2));
                }
            }
        }
        else if(at.type == 2)
        {
            //ns[1]++;
            if(ns[2] > 0)
            {
                ns[1]++;
                pq.add(new Event(at.time + ts[2], 3));
                ns[2]--;
            }
            else doneDry++;
            if(doneWash > 0 && ns[1] > 0)
            {
                doneWash--;
                ns[1]--;
                ns[0]++;
                if(k > 0 && ns[0] > 0)
                {
                    k--;
                    ns[0]--;
                    pq.add(new Event(at.time + ts[0], 1));
                }
                pq.add(new Event(at.time + ts[1], 2));
            }
            
        }
        else
        {
            //ns[0]++;
            if(ns[1] > 0)
            {
                ns[0]++;
                pq.add(new Event(at.time + ts[1], 2));
                ns[1]--;
            }
            else doneWash++;
            if(k > 0 && ns[0] > 0)
            {
                k--;
                ns[0]--;
                pq.add(new Event(at.time + ts[0], 1));
            }
            
        }
    }
    System.out.println(res);
}
static class Event implements Comparable<Event>
{
    int time, type;
    public Event(int ti, int ty)
    {
        time = ti;
        type = ty;
    }
    @Override
    public int compareTo(Event o) {
        // TODO Auto-generated method stub
        if(time != o.time) return time - o.time;
        return o.type - type;
    }
}
}