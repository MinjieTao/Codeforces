import java.util.*;
public class aa {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    boolean[] res = new boolean[n];
    for(int k = 0; k<2; k++)
    {
        int p = input.nextInt();
        for(int i = 0; i<p; i++) res[input.nextInt()-1] = true;
    }
    boolean x = true;
    for(int i = 0; i<n; i++) x &= res[i];
    System.out.println(x ? "I become the guy." : "Oh, my keyboard!");
}
}