import java.util.*;
public class aa {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    boolean one = false;
    for(int i = 0;i<n; i++) one |= input.nextInt() == 1;
    System.out.println(one ? -1 : 1);
}
}