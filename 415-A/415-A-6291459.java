import java.util.*;
public class aa {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt(), m = input.nextInt();
    int[] res = new int[n];
    for(int i = 0; i<m; i++)
    {
        int cur = input.nextInt()-1;
        for(int j = cur; j<n; j++)
            if(res[j] == 0)
                res[j] = cur+1;
    }
    for(int i = 0; i<n; i++) System.out.print(res[i]+" ");
}
}