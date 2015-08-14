import java.util.*;
public class aa {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int[] freq = new int[10];
    Arrays.fill(freq, 2*n);
    for(int i= 0; i<4; i++)
    {
        char[] s = input.next().toCharArray();
        for(char c: s) if(c != '.') freq[c-'0']--;
    }
    Arrays.sort(freq);
    System.out.println(freq[0] < 0 ? "NO" : "YES");
}
}