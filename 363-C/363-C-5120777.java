import java.io.PrintWriter;
import java.util.*;
public class c {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    String s = input.next();
    int n = s.length();
    PrintWriter out = new PrintWriter(System.out);
    ArrayList<Character> list = new ArrayList<Character>();
    for(int i = 0; i<n; i++)
    {
        char c = s.charAt(i);
        boolean triple = list.size() >= 2 && c == list.get(list.size()-1) && c == list.get(list.size()-2);
        boolean double2 = list.size() >= 3 && c == list.get(list.size()-1) && list.get(list.size()-2) == list.get(list.size()-3);
        if(triple || double2) continue;
        list.add(c);
    }
    for(char c: list) out.print(c);
    
    
    out.close();
}
}