import java.util.*;
public class bb {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt(), m = input.nextInt();
    HashMap<String, String> map = new HashMap<String, String>();
    for(int i = 0; i<m; i++)
    {
        map.put(input.next(), input.next());
    }
    for(int i = 0; i<n; i++)
    {
        String s = input.next();
        if(map.get(s).length() < s.length()) s = map.get(s);
        System.out.print(s+" ");
    }
}
}