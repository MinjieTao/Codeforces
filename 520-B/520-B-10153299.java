import java.util.*;
public class bb {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt(), m = input.nextInt();
    int[] ds = new int[10001];
    Arrays.fill(ds, 20000);
    ds[n] = 0;
    for(int i = 0; i<10000; i++)
    {
        for(int j = 0; j<=10000; j++)
        {
            if(j <= 5000) ds[j<<1] = ds[j<<1] < 1 + ds[j] ? ds[j<<1] : ds[j] + 1;
            if(j > 0) ds[j-1] = ds[j-1] < 1 + ds[j] ? ds[j-1] : ds[j] + 1;
        }
    }
    System.out.println(ds[m]);
}
}