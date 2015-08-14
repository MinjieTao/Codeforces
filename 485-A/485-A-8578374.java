import java.util.*;
public class aa {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int a = input.nextInt(), m = input.nextInt();
    for(int i = 0; i<m+1; i++) a = (a*2)%m;
    System.out.println(a == 0 ? "Yes" :"No");
}
}