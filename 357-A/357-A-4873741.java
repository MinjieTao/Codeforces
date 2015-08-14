import java.util.*;
public class aa {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int[] data = new int[n];
    for(int i = 0; i<n; i++) data[i] = input.nextInt();
    int x = input.nextInt(), y = input.nextInt();
    int res = 0;
    for(int i = 1; i<=101; i++)
    {
        int c1 = 0, c2 = 0;
        for(int j =0; j<n; j++)
        {
            if(j < i-1) c2 += data[j];
            else c1 += data[j];
        }
        if(c1 >= x && c1<=y && c2>=x && c2<=y) res = i;
    }
    System.out.println(res);
}
}