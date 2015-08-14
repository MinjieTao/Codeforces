import java.util.*;
public class b {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    String s = input.next();
    int n = s.length();
    Stack<Character> stk = new Stack<Character>();
    for(int i = 0; i<s.length(); i++)
    {
        char c = s.charAt(i);
        if(!stk.isEmpty() && c == stk.peek()) stk.pop();
        else stk.push(c);
    }
    System.out.println(stk.isEmpty() ? "Yes" : "No");
}
}