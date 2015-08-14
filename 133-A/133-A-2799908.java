import java.util.*;
public class a
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        System.out.println(s.indexOf('H') == -1 && s.indexOf('Q') == -1 && s.indexOf('9') == -1 ? "NO" : "YES");
    }
}