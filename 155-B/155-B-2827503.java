import java.util.*;
public class a
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        Card[] data = new Card[n];
        for(int i = 0; i<n; i++)
        {
            data[i] = new Card(input.nextInt(), input.nextInt());           
        }
        Arrays.sort(data);
        int count = 1, at = 0, res = 0;
        while(count > 0 && at < n)
        {
            res += data[at].a;
            count += data[at].b;

            at++;
            count--;
        }
        System.out.println(res);
    }
    public static class Card implements Comparable<Card>
    {
        int a, b;
        public Card(int a, int b)
        {
            this.a = a;
            this.b = b;
        }
        @Override
        public int compareTo(Card o) {
            if(this.b == o.b)
                return o.a - this.a;
            return o.b - this.b;
        }
    }
}