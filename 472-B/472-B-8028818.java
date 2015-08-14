import java.util.*;
public class b {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt(), k = input.nextInt();
    int[] data = new int[n];
    for(int i = 0; i<n; i++) data[i] = input.nextInt()-1;
    Arrays.sort(data);
    int at = n-1, res = 0;
    while(at >= 0)
    {
        res += 2*data[at];
        at -= k;
    }
    System.out.println(res);
}
}