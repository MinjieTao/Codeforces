import java.util.*;
public class b {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int x =input.nextInt(), k = input.nextInt();
    boolean[] used = new boolean[x];
    used[x-1] = true;
    for(int i = 0; i<k; i++)
    {
        int j = input.nextInt();
        for(int m = 0; m<1+(2-j); m++) used[input.nextInt()-1] = true;
    }
    int min = 0, max = 0;
    for(int i = 0; i<x-1; i++) if(!used[i]) max++;
    for(int i = 0; i<x-1; i++)
    {
        if(!used[i] && !used[i+1])
        {
            i++;
            min++;
        }
        else if(!used[i]) min++;
    }
    System.out.println(min+" "+max);
}
}