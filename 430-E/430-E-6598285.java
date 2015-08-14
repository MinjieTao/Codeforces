import java.util.*;
public class c {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int[] data = new int[n];
    for(int i =0; i<n; i++) data[i] = input.nextInt();
    Arrays.sort(data);
    System.out.println(data[n-1] == n && good(data, n-1, new boolean[n]) ? "YES" :"NO");
}
static boolean good(int[] data, int at, boolean[] used)
{
    //System.out.println(at+" "+Arrays.toString(used));
    if(data[at] == 1) return true;
    int left = data[at]-1;
    //used[at] = true;
    for(int i = at-1; i>=0; i--)
    {
        if(used[i]) continue;
        if(data[i] <= left && data[i] < data[at] - 1)
        {
            used[i] = true;
            if(!good(data, i, used))
            {
                return false;
            }
            left -= data[i];
        }
    }
    return left == 0;
}
}