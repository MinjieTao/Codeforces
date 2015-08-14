import java.util.*;
public class e {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    String s = input.next();
    int n = s.length();
    int res = 0;
    boolean flag = false;
    boolean found = false;
    boolean firstFlag = false;
    for(int i = 0; i<n; i++)
    {
        if(s.charAt(i) == '0' && s.charAt((i+n-1)%n) == '1')
        {
            int fwd = 0, rev = 0;
            int at = i;
            while(true)
            {
                at++;
                if(at == n) at = 0;
                if(s.charAt(at) == '1' && s.charAt((at+n-1)%n) == '0') break;
            }
            fwd = (at + n - i)%n;
            at = i;
            while(true)
            {
                at--;
                if(at == -1) at = n-1;
                if(s.charAt(at) == '1' && s.charAt((at+n-1)%n) == '0') break;
            }
            rev = (i - at + n)%n;
            if(fwd == 1 && rev == 1) res++;
            if(rev >= 2 && !flag)
            {
                res++;
            }
            if(fwd == 1 && rev != 1)
            {
                flag = true;
                res++;
            }
            
            if(fwd >= 2)
            {
                res++;
                flag = false;
            }
            if(!found)
            {
                found = true;
                boolean f = true;
                int r2 = 0;
                if(fwd == 1 && rev == 1) r2++;
                if(rev >= 2 && !f) r2++;
                if(fwd == 1 && rev != 1) r2++;
                if(fwd >= 2) r2++;
                if(r2 < 2) firstFlag = true;
            }
        }
    }
    if(flag && firstFlag) res--;
    System.out.println(res);
}
}