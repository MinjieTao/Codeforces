import java.util.*;
public class aa {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    String s = input.nextLine();
    HashSet<Character> set = new HashSet<Character>();
    for(int i = 0; i<s.length(); i++)
    {
        char c = s.charAt(i);
        if(c>='a' && c<='z') set.add(c);
    }
    System.out.println(set.size());
}
}