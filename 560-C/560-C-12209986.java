import java.util.*;
public class a {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int[] a = new int[6];
    for(int i = 0; i<6; i++) a[i] = input.nextInt();
    System.out.println((a[0]+a[1]+a[2]) * (a[0]+a[1]+a[2]) - a[0] * a[0] - a[2]*a[2] - a[4]*a[4]);
}
}