import java.util.*;
public class C21 {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int[] data = new int[n];
    for(int i = 0; i<n; i++) data[i] = input.nextInt();
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    int sum = 0;
    for(int x : data) sum += x;
    if(sum%3 != 0) System.out.println(0);
    else
    {
        map.put(sum/3, 0);
        long res = 0;
        int tot = 0;
        for(int i = 0; i<n-1; i++)
        {
            tot += data[i];
            if(tot == 2 * sum / 3)
            {
                res += map.get(sum/3);
            }
            if(!map.containsKey(tot)) map.put(tot, 0);
            map.put(tot, map.get(tot)+1);
        }
        System.out.println(res);
    }
}
}