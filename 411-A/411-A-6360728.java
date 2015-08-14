import java.util.*;
public class a {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    String s = input.next();
    System.out.println(s.length() >= 5 && contains(s, '0', '9') && contains(s, 'a','z') && contains(s, 'A','Z') ? "Correct" : "Too weak");
}
static boolean contains(String s, char a, char b)
{
    for(char c: s.toCharArray()) if(c>=a && c<=b) return true;
    return false;
}
}