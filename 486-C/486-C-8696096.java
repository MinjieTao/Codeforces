import java.util.*;
public class c {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt(), p = input.nextInt()-1;
    char[] s = input.next().toCharArray();
    int vert = 0;
    for(int i = 0; i<n/2; i++)
    {
        int cur = Math.abs(s[i] - s[n-1-i]);
        cur = Math.min(cur, 26 - cur);
        vert += cur;
    }
    //System.out.println(vert);
    System.out.println(vert+getHoriz(s, p));
}
static int getHoriz(char[] s, int p)
{
    int n = s.length;
    if(n == 1) return 0;
    if(p >= n/2) return getHoriz(rev(s), n-1-p);
    int left1 = p, left2 = p, right1 = n-1-p, right2 = n-1-p;
    for(int i = 0; i<n/2 && i<p; i++) if(s[i] != s[n-1-i])
    {
        if(left1 == p) left1 = i;
        left2 = i;
    }
    for(int i = n-1; i>p && i >= n/2; i--) if(s[i] != s[n-1-i])
    {
        right1 = i;
        if(right2 == p) right2 = i;
    }
    int horiz = n;
    if(left1 == p) return Math.abs(p - (n-1-right1));
    if(right1 == p) return Math.abs(p - left1);
    horiz = Math.min(horiz, Math.max(n - 1 - left1 - p, right2 - p));
    if(p > left2 && p > n - 1 - right1) horiz = Math.min(horiz, Math.max(p - left1, p - (n-1-right2)));
    int mostLeft = Math.min(left1, n - 1 - right2);
    if(mostLeft > p) mostLeft = p;
    int mostRight = Math.max(p, n-1-right1);
    //System.out.println(mostLeft+" "+mostRight);
    horiz = Math.min(horiz, Math.max(mostRight - p, p - mostLeft) + 2*Math.min(mostRight - p, p - mostLeft));
    return horiz;
}
static char[] rev(char[] s)
{
    int n = s.length;
    char[] res = new char[n];
    for(int i = 0; i<n; i++) res[i] = s[n-1-i];
    return res;
}
}