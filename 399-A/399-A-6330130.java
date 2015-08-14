import java.util.*;
public class aa {
public static void main(String[] args)
{
    Scanner input =new Scanner(System.in);
    int n = input.nextInt(), p = input.nextInt(), k = input.nextInt();
    int min = Math.max(1, p - k);
    if(min > 1) System.out.print("<< ");
    for(int i = min; i<p; i++) System.out.print(i+" ");
    System.out.print("("+p+") ");
    int max = Math.min(n, p+k);
    for(int i = p+1; i<= max; i++) System.out.print(i+" ");
    if(max < n) System.out.print(">>");
}
}