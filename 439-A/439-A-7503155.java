import java.util.*;
public class a {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt(), d = input.nextInt();
    int[] data = new int[n];
    for(int i = 0; i<n; i++) data[i] = input.nextInt();
    int sum = 0;
    for(int i = 0; i<n; i++) sum += data[i];
    if(sum + 10 * (n-1) > d) System.out.println(-1);
    else System.out.println((d - sum)/5);
}
}