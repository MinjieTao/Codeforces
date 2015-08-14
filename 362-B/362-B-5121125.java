import java.util.*;
public class b {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int x = input.nextInt(), n = input.nextInt();
    int[]data = new int[n];
    for(int i = 0; i<n; i++) data[i] = input.nextInt();
    Arrays.sort(data);
    boolean good = n==0 || (data[0] > 1 && data[n-1] != x);
    for(int i = 2; i<n; i++) good &= data[i] != data[i-2]+2;
    System.out.println(good ? "YES" : "NO");
}
}