import java.util.*;
public class a
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        ArrayList<String> list = new ArrayList<String>();
        int[] nums = new int[n];
        String[] names = new String[n];
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for(int i = 0; i<n; i++)
        {
            String s = input.next();
            names[i] = s;
            if(!list.contains(s)) list.add(s);
            int x = input.nextInt();
            nums[i] = x;
            if(map.containsKey(s)) map.put(s, map.get(s)+x);
            else map.put(s, x);
        }
        int max = -10000001;
        for(String s: list)
            max = Math.max(map.get(s), max);
        HashMap<String, Integer> map2 = new HashMap<String, Integer>();
        for(int i = 0; i<n; i++)
        {
            String s = names[i];
            if(!list.contains(s)) list.add(s);
            int x = nums[i];
            if(map2.containsKey(s)) map2.put(s, map2.get(s)+x);
            else map2.put(s, x);
            if(map.get(s) == max && map2.get(s) >= max)
            {
                System.out.println(s);
                break;
            }
        }
    }
}