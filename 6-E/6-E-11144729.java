import java.util.*;
public class E6 {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt(), k = input.nextInt();
    int[] data = new int[n];
    for(int i = 0; i<n; i++) data[i] = input.nextInt();
    ArrayList<Integer> starts = new ArrayList<Integer>();
    int max = 0;
    int j = 0;
    TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
    for(int i = 0; i<n; i++)
    {
        if(!map.containsKey(data[i])) map.put(data[i], 0);
        map.put(data[i], map.get(data[i])+1);
        while(map.lastKey() - map.firstKey() > k)
        {
            map.put(data[j], map.get(data[j]) - 1);
            if(map.get(data[j]) == 0) map.remove(data[j]);
            j++;
        }
        int cur = i - j + 1;
        if(cur == max) starts.add(j+1);
        else if(cur > max)
        {
            max = cur;
            starts = new ArrayList<Integer>();
            starts.add(j+1);
        }
    }
    System.out.println(max+" "+starts.size());
    for(int x : starts) System.out.println(x+" "+(x+max-1));
}
}