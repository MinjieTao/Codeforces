import java.util.*;
public class aa {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int c = input.nextInt(), d = input.nextInt(), n = input.nextInt(), m = input.nextInt(), k = input.nextInt();
    int need = Math.max(0, n*m - k);
    int res = 987654321;
    for(int i = 0; i<=need/n+1; i++)
    {
        int left = Math.max(0, need - i*n);
        int prob = i * c + left * d;
        res = Math.min(res, prob);
    }
    System.out.println(res);
}
}