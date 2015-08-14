import java.util.*;
public class b {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt()*2;
    int len = n/2;
    int[] data = new int[n];
    for(int i = 0; i<n; i++) data[i] = input.nextInt();
    int[] freq = new int[100];
    for(int i =0; i<n; i++) freq[data[i]]++;
    HashSet<Integer> first = new HashSet<Integer>();
    HashSet<Integer> second = new HashSet<Integer>();
    int cf = 0, cs = 0;
    int[] res = new int[n];
    int count = 0;
    for(int i = 0; i<100; i++) if(freq[i]>0) count++;
    for(int i =0; i<n; i++)
    {
        int cur = data[i];
        if(!first.contains(cur) && freq[cur] > 1)
        {
            first.add(cur);
            cf++;
            res[i] = 1;
            freq[cur]--;
        }
        else if(first.contains(cur) && !second.contains(cur))
        {
            res[i] = 2;
            freq[cur]--;
            cs++;
            second.add(cur);
        }
    }
    count -= cf;
    int used = count/2;
    for(int i = 0; i<n; i++)
    {
        int cur = data[i];
        if(!first.contains(cur) && !second.contains(cur))
        {
            if(used>0)
            {
                used--;
                first.add(cur);
                res[i] = 1;
                cf++;
            }
            else
            {
                second.add(cur);
                res[i] = 2;
                cs++;
            }
        }
    }
    for(int i = 0; i<n; i++)
    {
        int cur = data[i];
        if(res[i] == 0)
        {
            if(cf < n/2)
            {
                first.add(cur);
                cf++;
                res[i] = 1;
            }
            else
            {
                second.add(cur);
                cs++;
                res[i] = 2;
            }
        }
    }
    System.out.println(first.size()*second.size());
    for(int i =0; i<n; i++) System.out.print(res[i]+" ");
}
}