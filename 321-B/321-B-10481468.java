import java.util.*;
public class B190 {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt(), m = input.nextInt();
    ArrayList<Integer> defs = new ArrayList<Integer>();
    ArrayList<Integer> atks = new ArrayList<Integer>();
    for(int i = 0; i<n; i++)
    {
        String type = input.next();
        if(type.equals("ATK")) atks.add(input.nextInt());
        else defs.add(input.nextInt());
    }
    Collections.sort(atks);
    Collections.sort(defs);
    int[] data = new int[m];
    for(int i = 0; i<m; i++) data[i] = input.nextInt();
    Arrays.sort(data);
    long res = 0;
    for(int i = 1; i<= Math.min(atks.size(), m); i++)
    {
        int sum = 0;
        for(int j = 0; j<i; j++)
        {
            int cur = data[m-i+j] - atks.get(j);
            if(cur < 0) sum = -987654321;
            else sum += cur;
        }
        res = Math.max(res, sum);
    }
    boolean[] used = new boolean[m];
    boolean canAll = true;
    for(int i = 0; i<defs.size(); i++)
    {
        boolean cur = false;
        for(int j = 0; j<m; j++)
        {
            if(used[j]) continue;
            if(data[j] > defs.get(i))
            {
                used[j] = true;
                cur = true;
                break;
            }
        }
        if(!cur) canAll = false;
    }
    ArrayList<Integer> extra = new ArrayList<Integer>();
    for(int i = 0; i<m; i++)
    {
        if(!used[i]) extra.add(data[i]);
    }
    if(extra.size() < atks.size()) canAll = false;
    else
    {
        for(int i = 0; i<atks.size(); i++)
        {
            if(extra.get(extra.size() - i - 1) < atks.get(atks.size() - i - 1)) canAll = false;
        }
    }
    long sum = 0;
    for(int x : extra) sum += x;
    for(int x : atks) sum -= x;
    if(canAll) res = Math.max(res, sum);
    System.out.println(res);
}
}