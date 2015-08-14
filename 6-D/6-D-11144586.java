import java.util.*;
public class D6 {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    n = input.nextInt();
    a = input.nextInt();
    b = input.nextInt();
    int[] data = new int[n+1];
    int[] copy = new int[n+1];
    int res = 0;
    for(int i = 0; i<n; i++) data[i] = copy[i] = input.nextInt();
    
    String s = "";
    while(data[0] >= 0)
    {
        data[0] -= b;
        data[2] -= b;
        data[1] -= a;
        res++;
        for(int i = 0; i<3; i++) if(data[i] < 0) data[i] = -1;
        for(int i = 0; i<3; i++) copy[i] = data[i];
        s += "2 ";
    }
    while(data[n-1] >= 0)
    {
        data[n-1] -= b;
        data[n-3] -= b;
        data[n-2] -= a;
        res++;
        for(int i = 0; i<3; i++) if(data[n-1-i] < 0) data[n-1-i] = -1;
        for(int i = 0; i<3; i++) copy[n-1-i] = data[n-1-i];
        s += (n-1)+" ";
    }
    copy[n] = data[n] = 1;
    res += go(copy);
    System.out.println(res);
    System.out.print(s);
    trace(data);
}
static int a, b, n;
static HashMap<String, Integer> memo = new HashMap<String, Integer>();
static HashMap<String, Integer> trace = new HashMap<String, Integer>();
static int go(int[] data)
{
    String key = Arrays.toString(data);
    if(memo.containsKey(key)) return memo.get(key);
    int min = 987654321;
    int best = -1;
    if(sum(data) != -n)
        for(int i = data[n]; i<n-1; i++)
        {
            if(data[i] < 0 && (i == 0 || data[i-1] < 0) && (i == n-1 || data[i+1] < 0)) continue;
            int[] ndata = new int[n+1];
            for(int j = 0; j<n; j++)
            {
                ndata[j] = data[j];
                if(j == i) ndata[j] -= a;
                else if(Math.abs(i - j) == 1) ndata[j] -= b;
                if(ndata[j] < 0) ndata[j] = -1;
            }
            ndata[n] = i;
            int next =  1 + go(ndata);
            if(next < min) best = i;
            min = Math.min(min, next);
        }
    else min = 0;
    //min =  min == 987654321 ? 0 : min;
    memo.put(key,  min);
    trace.put(key, best);
    //System.out.println(key+" "+min);
    return min;
}
static int sum(int[] data)
{
    int res = 0;
    for(int x : data) res += x;
            res -= data[n];
            return res;
}
static void trace(int[] data)
{
    String key = Arrays.toString(data);
    if(memo.get(key) == 0) return;
    int i = trace.get(key);
    System.out.print(i+1+" ");
    int[] ndata = new int[n+1];
    for(int j = 0; j<n; j++)
    {
        ndata[j] = data[j];
        if(j == i) ndata[j] -= a;
        else if(Math.abs(i - j) == 1) ndata[j] -= b;
        if(ndata[j] < 0) ndata[j] = -1;
    }
    ndata[n] = i;
    trace(ndata);
}
}