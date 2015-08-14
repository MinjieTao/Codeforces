import java.util.*;
public class a {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    String s1 = input.next(), s2 =  input.next();
    int n = s1.length()/2;
    int a = 0, b = 0;
    HashMap<String, Integer> map = new HashMap<String, Integer>();
    map.put("()", 0);
    map.put("[]", 1);
    map.put("8<", 2);
    for(int i = 0; i<n; i++)
    {
        int x1 = map.get(s1.substring(2*i, 2*i+2));
        int x2 = map.get(s2.substring(2*i, 2*i+2));
        int x = x1*x1 - x2*x2;
        if(x == 1 || x == 3 || x == -4) a++;
        else if(x != 0) b++;
    }
    if(a>b) System.out.println("TEAM 1 WINS");
    else if(a<b) System.out.println("TEAM 2 WINS");
    else System.out.println("TIE");
}
}