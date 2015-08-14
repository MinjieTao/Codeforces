import java.util.*;
public class a {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int[] data = new int[4];
    for(int i = 0; i<4; i++) data[i] = input.nextInt();
    String s = input.next();
    int res = 0;
    for(int i = 0; i<s.length(); i++) res += data[(s.charAt(i)-'1')];
    System.out.println(res);
}
}