import java.util.*;
public class bb {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int[] max = new int[100001];
    Arrays.fill(max, -1);
    boolean good = true;
    for(int i = 0; i<n; i++)
    {
        int x = input.nextInt(), k = input.nextInt();
        good &= max[k] >= x-1;
        max[k] = Math.max(max[k], x);
    }
    System.out.println(good ? "YES" : "NO");
}
}