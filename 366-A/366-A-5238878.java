import java.util.*;
public class a {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int[] as = new int[4], bs = new int[4], cs = new int[4], ds = new int[4];
    boolean found = false;
    for(int i = 0; i<4; i++)
    {
        as[i] = input.nextInt();
        bs[i] = input.nextInt();
        cs[i] = input.nextInt();
        ds[i] = input.nextInt();
    }
    for(int i = 0; i<4; i++)
    {
        if(!found && as[i] + cs[i] <= n)
        {
            while(as[i] + cs[i] < n) as[i]++;
            found = true;
            System.out.println((i+1) + " " + as[i] + " " + cs[i]);
        }
        if(!found && as[i] + ds[i] <= n)
        {
            while(as[i] + ds[i] < n) as[i]++;
            found = true;
            System.out.println((i+1) + " " + as[i] + " " + ds[i]);
        }
        if(!found && bs[i] + cs[i] <= n)
        {
            while(bs[i] + cs[i] < n) bs[i]++;
            found = true;
            System.out.println((i+1) + " " + bs[i] + " " + cs[i]);
        }
        if(!found && bs[i] + ds[i] <= n)
        {
            while(bs[i] + ds[i] < n) bs[i]++;
            found = true;
            System.out.println((i+1) + " " + bs[i] + " " + ds[i]);
        }
    }
    if(!found) System.out.println(-1);
}
}