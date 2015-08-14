import java.util.*;
public class b {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt(), m = input.nextInt(), k = input.nextInt();
    int[] data = new int[m+1];
    for(int i = 0; i<m+1; i++) data[i] = input.nextInt();
    int res = 0;
    for(int i = 0; i<m; i++) if(Integer.bitCount(data[i] ^ data[m]) <= k) res++;
    System.out.println(res);
}
}