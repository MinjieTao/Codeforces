import java.util.*;
public class b {
public static void main(String[] args)
{
    int[] res = new int[1000001];
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int at = 0;
    for(int i = 0; i<n; i++)
    {
        int a = input.nextInt();
        for(int j = 0; j<a; j++) res[at++] = i+1;
    }
    int m = input.nextInt();
    for(int i = 0; i<m; i++)
        System.out.println(res[input.nextInt()-1]);
}
}