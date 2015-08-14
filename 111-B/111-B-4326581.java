import java.util.*;
public class a {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] last = new int[100001];
        Arrays.fill(last, -1);
        for(int i = 0; i<n; i++)
        {
            int x = input.nextInt(), y = input.nextInt();
            int count = 0;
            for(int j = 1; j<=Math.sqrt(x); j++)
            {
                if(x%j != 0) continue;
                //System.out.println(j+" "+last[j]+" "+last[x/j]);
                if(last[j] < i - y) count++;
                last[j] = i;
                if(last[x/j] < i - y) count++;
                last[x/j] = i;
            }
            System.out.println(count);
        }
    }
    static int gcd(int a, int b)
    {
        if(b == 0) return a;
        return gcd(b, a%b);
    }

}