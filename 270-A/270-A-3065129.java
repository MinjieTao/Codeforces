import java.util.*;
public class a2 {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int T = input.nextInt();
    for(int t = 0; t<T; t++)
        System.out.println(360%(180-input.nextInt())==0 ? "YES":"NO");
}
}