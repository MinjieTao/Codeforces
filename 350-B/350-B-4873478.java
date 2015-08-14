import java.util.*;
public class b {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int[] types = new int[n];
    for(int i = 0; i<n; i++) types[i] = input.nextInt();
    int[] prev = new int[n], count = new int[n];
    for(int i = 0; i<n; i++)
    {
        int p = input.nextInt()-1;
        prev[i] = p;
        if(p==-1) continue;
        count[p]++;
    }
    int max = 0, maxdex = 0;
    for(int i = 0; i<n; i++)
    {
        if(types[i] == 0) continue;
        int x = 1;
        int at = i;
        while(true)
        {
            int next = prev[at];
            if(next == -1 || types[next] == 1 || count[next] > 1) break;
            at = next;
            x++;
        }
        if(x>max)
        {
            max = x;
            maxdex = i;
        }
    }
    int[] data = new int[max];
    data[max-1] = maxdex;
    for(int i = max-2; i>=0; i--) data[i] = prev[data[i+1]];
    System.out.println(max);
    for(int i = 0; i<max; i++) System.out.print((1+data[i])+" ");
}
}