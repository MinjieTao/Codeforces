import java.util.*;
public class bb {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int q = input.nextInt();
    HashMap<String, String> map = new HashMap<String, String>();
    for(int i = 0; i<q; i++)
    {
        String a = input.next(), b = input.next();
        if(map.containsKey(a))
        {
            String temp = map.get(a);
            map.remove(a);
            a = temp;
        }
        map.put(b, a);
    }
    System.out.println(map.size());
    for(String s: map.keySet())
    {
        System.out.println(map.get(s)+" "+s);
    }
}
}