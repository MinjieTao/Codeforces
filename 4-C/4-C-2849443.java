import java.util.*;
public class a
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for(int i = 0; i<n; i++)
        {
            String s = input.next();
            if(!map.containsKey(s))
            {
                map.put(s,  1);
                System.out.println("OK");
            }
            else
            {
                System.out.println(s + map.get(s));
                map.put(s, map.get(s)+1);
            }
        }
    }
}