import java.util.*;
public class c {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int[] a = new int[5];
    for(int i = 0; i<5; i++) a[i] = input.nextInt();
    int res = Math.min(a[0], a[1]);
    res = Math.min(res, a[2]/2);
    res = Math.min(a[3]/7, res);
    res = Math.min(res, a[4]/4);
    System.out.println(res);
}
}