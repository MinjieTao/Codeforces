import java.util.*;
public class bb {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int[] data = new int[n];
    for(int i = 0; i<n; i++) data[i] = input.nextInt();
    int[] last = new int[100001];
    int[] diff = new int[100001];
    boolean[] valid = new boolean[100001];
    Arrays.fill(valid, true);
    Arrays.fill(last, -1);
    Arrays.fill(diff, -1);
    int count = 0;
    for(int i = 0; i<n; i++)
    {
        int at = data[i];
        if(last[at] == -1)
        {
            count++;
            last[at] = i;
        }
        else if(diff[at] == -1 || diff[at] == i - last[at])
        {
            diff[at] = i - last[at];
            last[at] = i;
        }
        else
        {
            if(valid[at])
                count--;
            valid[at] = false;
        }
    }
    System.out.println(count);
    for(int i = 1; i<=100000; i++)
    {
        if(last[i] == -1 || !valid[i]) continue;
        if(diff[i] == -1) diff[i] = 0;
        System.out.println(i+" " +diff[i]);
    }
}
}