import java.util.*;
public class d {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt(), d = input.nextInt();
    String[] firsts = new String[n], seconds = new String[n];
    int[] times = new int[n];
    ArrayList<String> res = new ArrayList<String>();
    for(int i = 0; i<n; i++)
    {
        firsts[i] = input.next(); seconds[i] = input.next();
        times[i] = input.nextInt();
        boolean good = false;
        for(int j = i-1; j>=0; j--)
        {
            if(times[i] - times[j] > d) break;
            if(times[i] ==times[j]) continue;
            if(firsts[j].equals(seconds[i]) && seconds[j].equals(firsts[i]))
            {
                good = true;
                break;
            }
        }
        if(!good) continue;
        String s1 = firsts[i], s2 = seconds[i];
        if(s1.compareTo(s2) > 0)
        {
            String temp = s1;
            s1 = s2;
            s2 = temp;
        }
        String toAdd = s1+" "+s2;
        if(!res.contains(toAdd))
            res.add(toAdd);
    }
    System.out.println(res.size());
    for(String s: res) System.out.println(s);
}
}