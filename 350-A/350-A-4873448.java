import java.util.*;
public class a {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n= input.nextInt(), m = input.nextInt();
    int[] a = new int[n], b = new int[m];
    for(int i = 0; i<n; i++) a[i] = input.nextInt();
    for(int i =0; i<m; i++) b[i]=input.nextInt();
    Arrays.sort(a);
    Arrays.sort(b);
    int x = Math.max(a[n-1], 2*a[0]);
    if(x>=b[0]) System.out.println(-1);
    else System.out.println(x);
}
}