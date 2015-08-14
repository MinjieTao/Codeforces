import java.util.*;
public class a {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        long a = input.nextLong(), b = input.nextLong();
        for(long i = a; i<=b; i++)
            for(long j = i+1; j<=b; j++)
                for(long k = j+1; k<=b; k++)
                {
                    if(gcd(i, j) == 1 && gcd(j, k) == 1 && gcd(i, k) != 1)
                    {
                        System.out.println(i+" "+j+" "+k);
                        return;
                    }
                }
        System.out.println(-1);
        
    }
    static long gcd(long a, long b)
    {
        if(b == 0) return a;
        return gcd(b, a%b);
    }

}