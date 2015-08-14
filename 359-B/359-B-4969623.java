import java.util.*;
public class b {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt(), k = input.nextInt();
    boolean[] used = new boolean[2*n];
    int f = 0, b = 2*n - 1;
    while(k > 0)
    {
        System.out.print((b+1)+" ");
        int diff = b - f;
        used[b--] = true;
        if(diff>=k)
        {
            f += diff - k;
            System.out.print((f+1)+" ");
            used[f] = true;
            break;
        }
        else
        {
            System.out.print((f+1)+" ");
            used[f++] = true;
        }
    }
    for(int i = 0; i<2*n; i++)
        if(!used[i])
            System.out.print((i+1)+" ");
}
}