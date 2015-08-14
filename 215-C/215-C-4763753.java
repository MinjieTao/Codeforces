import java.util.*;
public class ff {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt(), m = input.nextInt(), s = input.nextInt();
    long res = 0;
    for(int a = 0; a<=250; a++)
        for(int b = 0; b<=250; b++)
        {
            int left = s - (2*a+1)*(2*b+1);
            if(left < 0) break;
            if((left&1) == 1) continue;
            for(int c = 0; c<=a; c++)
            {
                if(left%(2*c+1) != 0) continue;
                int d = left/(2*c+1)/2 + b;
                int countx = n - Math.max(2*a+1, 2*c+1) + 1;
                int county = m - Math.max(2*b+1, 2*d+1) + 1;
                if(countx < 0 || county < 0) continue;
                int add = countx*county;
                if(left == 0) add *= (b+1);
                if(a != c) add *= 2;
                res += add;
            }
        }
    System.out.println(res);
}
}