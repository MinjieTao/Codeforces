import java.util.*;
public class a {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int a = input.nextInt();
    TreeSet<Integer> factors = new TreeSet<Integer>();
    for(int i = 1; i<=Math.sqrt(a); i++)
        if(a%i == 0)
        {
            factors.add(i);
            factors.add(a/i);
        }
    int[] count = new int[100000];
    String s = input.next();
    int n = s.length();
    int[] data = new int[n];
    for(int i = 0; i<n; i++) data[i] = s.charAt(i) - '0';
    int[] sums = new int[n];
    sums[0] = data[0];
    for(int i = 1; i<n; i++) sums[i] = sums[i-1] + data[i];
    for(int i = 0; i<n; i++)
        for(int j = i; j<n; j++)
        {
            int x = sums[j] - (i == 0 ? 0 : sums[i-1]);
            //System.out.println(x);
            count[x]++;
        }
    long res = 0;
    for(int x: factors)
    {
        if(x < 100000 && a/x < 100000)
        res += (long)count[x]*count[a/x];
    }
    if(a == 0) res += (long)count[0]*(n*(n+1)) - (long)count[0]*count[0];
    System.out.println(res);
}
}