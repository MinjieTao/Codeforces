import java.util.*;
public class b {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    long m = input.nextLong();
    int swaps = n-1;
    String s = Long.toBinaryString(m-1);
    while(s.length() < swaps) s = '0' + s;
    int[] res = new int[n];
    int a = 0, b = n-1;
    for(int i = 0; i<swaps; i++)
    {
        if(s.charAt(i) == '1')
        {
            res[b--] = i+1;
        }
        else res[a++] = i+1;
    }
    res[a] = n;
    for(int x: res) System.out.print(x+" ");
}
}