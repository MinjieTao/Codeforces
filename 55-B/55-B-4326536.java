import java.util.*;
public class a {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] a = new int[4];
        for(int i = 0; i<4; i++)
            a[i] = input.nextInt();
        String x = input.next(), y = input.next(), z = input.next();
        long min = 1000000000000000l;
        for(int i = 0; i<4; i++)
            for(int ii = 0; ii<i; ii++)
            for(int j = 0; j<3; j++)
                for(int jj = 0; jj<j; jj++)
            {
                ArrayList<Long> b = new ArrayList<Long>();
                for(int e: a) b.add((long)e);
                if(x.equals("+"))
                {
                    b.set(ii, b.get(ii) + b.remove(i));
                }
                else
                    b.set(ii, b.get(ii) * b.remove(i));
                if(y.equals("+"))
                {
                    b.set(jj, b.get(jj) + b.remove(j));
                }
                else
                    b.set(jj, b.get(jj) * b.remove(j));
                if(z.equals("+"))
                {
                    b.set(0, b.get(0) + b.remove(1));
                }
                else
                    b.set(0, b.get(0) * b.remove(1));
                min = Math.min(min, b.get(0));
            }
        System.out.println(min);
    }
    static int gcd(int a, int b)
    {
        if(b == 0) return a;
        return gcd(b, a%b);
    }

}