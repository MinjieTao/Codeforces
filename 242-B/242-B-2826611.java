import java.util.*;
public class a
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int n= input.nextInt();
        Segment[] data = new Segment[n];
        for(int i = 0; i<n; i++) data[i] = new Segment(input.nextInt(), input.nextInt(), i+1);
        Arrays.sort(data);
        boolean good = true;
        for(int i = 1; i<n; i++)
            if(data[i].b > data[0].b)
                good = false;
        System.out.println(good ? data[0].c : -1);
    }
    public static class Segment implements Comparable<Segment>
    {
        int a, b, c;
        public Segment(int a, int b, int c)
        {
            this.a = a;
            this.b = b;
            this.c = c;
        }
        @Override
        public int compareTo(Segment that) {
            if(this.a == that.a)
                return that.b - this.b;
            return this.a - that.a;
        }
    }
}