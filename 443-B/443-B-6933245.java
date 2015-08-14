import java.util.*;
public class bb {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    String s = input.next();
    int m = input.nextInt(), n = s.length();
    int res = 0;
    for(int i = 0; i<n+m; i++)
        for(int j = i+1; j<n+m; j+=2)
        {
            int len = (j - i + 1)/2;
            boolean good = true;
            for(int k = 0; k<len; k++)
            {
                char a = '?', b = '?';
                if(i+k < n) a = s.charAt(i+k);
                if(i+k+len < n) b = s.charAt(i+k+len);
                if(a != '?' && b != '?' && a != b)
                {
                    good = false;
                    break;
                }
            }
            if(good) res = Math.max(res, 2*len);
        }
    System.out.println(res);
}
}