import java.util.*;
public class d {
    static int m;
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    long x = input.nextLong();
    int n = (x+"").length();
    m = input.nextInt();
    int[]counts = new int[10];
    for(int i = 0; i<n; i++)
    {
        counts[(int)(x%10)]++;
        x/=10;
    }
    long res = 0;
    memo = new HashMap<Long, Long>();
    for(int  i= 1; i<10; i++)
    {
        if(counts[i] == 0) continue;
        counts[i]--;
        res += go(counts, i%m);
        counts[i]++;
    }
    System.out.println(res);
}
static HashMap<Long, Long> memo;
static long go(int[] counts, int mod)
{
    boolean done = true;
    for(int i = 0; i<10; i++)
    {
        if(counts[i] != 0)
        {
            done = false;
            break;
        }
    }
    if(done)
    {
        return mod == 0 ? 1 : 0;
    }
    long key = encode(counts)*101+mod;
    if(memo.containsKey(key)) return memo.get(key);
    long res = 0;
    for(int i = 0; i<10; i++)
    {
        if(counts[i] == 0) continue;
        counts[i]--;
        res += go(counts, ((mod*10) + i)%m);
        counts[i]++;
    }
    memo.put(key,  res);
    return res;
}
static long encode(int[] counts)
{
    long res = 0;
    for(int i = 0; i<10; i++)
    {
        res += counts[i];
        res *= 20;
    }
    return res;
}
}