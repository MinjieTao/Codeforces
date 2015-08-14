import java.util.*;
public class bb {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt(), m = input.nextInt();
    int a1 = input.nextInt(), b1 = input.nextInt();
    int a2 = input.nextInt(), b2 = input.nextInt();
    boolean res = false;
    res |= Math.max(a1, a2) <= n && b1 + b2 <= m;
    res |= Math.max(a1, a2) <= m && b1 + b2 <= n;
    
    res |= Math.max(b1, a2) <= n && a1 + b2 <= m;
    res |= Math.max(b1, a2) <= m && a1 + b2 <= n;
    
    res |= Math.max(a1, b2) <= n && b1 + a2 <= m;
    res |= Math.max(a1, b2) <= m && b1 + a2 <= n;
    
    res |= Math.max(b1, b2) <= n && a1 + a2 <= m;
    res |= Math.max(b1, b2) <= m && a1 + a2 <= n;
    System.out.println(res ? "YES" : "NO");
}
}