import java.util.*;
public class c {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int[] data = new int[n];
    for(int i = 0; i<n; i++) data[i] = input.nextInt();
    Arrays.sort(data);
    if(n == 1)
    {
        System.out.println(-1);
        return;
    }
    TreeSet<Integer> res = new TreeSet<Integer>();
    if(good(data))
    {
        res.add(data[0] - (data[1] - data[0]));
        res.add(data[n-1] + (data[1] - data[0]));
    }
    else
    {
        int d = data[1] - data[0];
        if(data[1] - data[0] == 2*(data[2] - data[1])) d = data[2] - data[1];
        int badIndex = -1;
        int countBad = 0;
        for(int i = 0;i<n-1; i++)
        {
            int cur = data[i+1] - data[i];
            if(cur != d) countBad++;
            if(cur != d && cur == 2*d)
            {
                badIndex = i;
            }
        }
        if(countBad == 1 && badIndex != -1)
        {
            res.add(data[badIndex]+d);
        }
    }
    if(n == 2 && data[1]%2 == data[0]%2)
    {
        res.add((data[1] + data[0])/2);
    }
    System.out.println(res.size());
    for(int x: res) System.out.print(x+" ");
}
static boolean good(int[] a)
{
    int diff = a[1] - a[0];
    for(int i = 1; i<a.length-1; i++) if(a[i+1] - a[i] != diff) return false;
    return true;
}
}