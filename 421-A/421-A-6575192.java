import java.util.*;
public class aa {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt(), a = input.nextInt(), b = input.nextInt();
    boolean[] good = new boolean[n];
    for(int i = 0; i<a; i++) good[input.nextInt()-1] = true;
    for(int i =0; i<b; i++) input.nextInt();
    for(int i = 0; i<n; i++) System.out.print((good[i] ? 1 : 2)+" ");
}
}