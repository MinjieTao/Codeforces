import java.util.*;
public class d {
public static void main(String[] args)
{
    int[] vowels = {0, 4, 8, 14, 20, 24};
    Scanner input = new Scanner(System.in);
    String s = input.nextLine();
    s = s.substring(0,s.length()-1).toLowerCase();
    s = s.replaceAll(" ","");
    boolean good = false;
    for(int i: vowels) good |= s.charAt(s.length()-1)-'a' == i;
    System.out.println(good ? "YES" : "NO");
}
}