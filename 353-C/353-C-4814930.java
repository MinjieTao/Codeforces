import java.util.*;
public class c {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int[] data = new int[n];
    for(int i = 0; i<n;i++) data[i] = input.nextInt();
    char[] s = input.next().toCharArray();
    int[] pre = new int[n];
    pre[0] = data[0];
    for(int i = 1; i<n; i++) pre[i] = pre[i-1] + data[i];
    int[] suff = new int[n];
    suff[n-1] = s[n-1] == '1' ? data[n-1] : 0;
    for(int i = n-2; i>=0; i--) suff[i] = suff[i+1] + (s[i] == '1' ? data[i] : 0);
    int max = 0;
    for(int i = 0; i<n; i++) if(s[i] == '1') max += data[i];
    for(int i = 0; i<n; i++)
    {
        if(s[i] == '0') continue;
        max = Math.max(max, (i == 0 ? 0 : pre[i-1]) + (i == n-1 ? 0 : suff[i+1]));
    }
    System.out.println(max);
    
}
}