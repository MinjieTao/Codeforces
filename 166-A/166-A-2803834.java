import java.util.*;
public class a
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(), k = input.nextInt();
        Team[] data = new Team[n];
        for(int i = 0; i<n; i++)
            data[i] = new Team(input.nextInt(), input.nextInt());
        Arrays.sort(data);
        int kt = data[k-1].t, kp = data[k-1].p;
        int count = 0;
        for(int i = 0; i<n; i++)
            if(data[i].p == kp && data[i].t == kt)
                count++;
            System.out.println(count);
    }
    public static class Team implements Comparable<Team>
    {
        int t, p;
        public Team(int t, int p)
        {
            this.t = t;
            this.p = p;
        }
        @Override
        public int compareTo(Team that) {
            if(this.t == that.t)
                return this.p - that.p;
            return that.t - this.t;
        }
        
    }
}