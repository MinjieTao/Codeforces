import java.util.*;
public class aa {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int[] a = new int[n];
    for(int i = 0; i<n; i++) a[i] = input.nextInt();
    Arrays.sort(a);
    int temp = a[0];
    a[0] = a[n-1];
    a[n-1] = temp;
    for(int i = 0; i<a.length; i++) System.out.print(a[i]+" ");
}
}