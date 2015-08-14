import java.util.*;
public class a {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt(), c = input.nextInt();
    int[] data = new int[n];
    for(int i = 0; i<n; i++) data[i] = input.nextInt();
    int res = 0;
    for(int i = 0; i<n-1; i++) res = Math.max(res, data[i] - data[i+1] - c);
    System.out.println(res);
    
}
}