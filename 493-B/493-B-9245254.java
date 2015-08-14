import java.util.*;
public class b {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    ArrayList<Integer> first = new ArrayList<Integer>(), second = new ArrayList<Integer>();
    int n = input.nextInt();
    boolean flag = false;
    for(int i = 0; i<n; i++)
    {
        int x = input.nextInt();
        if(x > 0) first.add(x);
        else second.add(-x);
        if(i == n-1 && x > 0) flag = true;
    }
    long tot1 = 0, tot2 = 0;
    for(int x: first) tot1 += x;
    for(int x : second) tot2 += x;
    if(tot1 > tot2) System.out.println("first");
    else if(tot1 < tot2) System.out.println("second");
    else
    {
        boolean found = false;
        for(int i = 0; i<Math.max(first.size(), second.size()) && !found; i++)
        {
            if(i > first.size())
            {
                found = true;
                System.out.println("second");
            }
            else if(i > second.size())
            {
                found = true;
                System.out.println("first");
            }
            else if(first.get(i) != second.get(i))
            {
                found = true;
                System.out.println(first.get(i) > second.get(i) ? "first" : "second");
            }
        }
        if(!found) System.out.println(flag ? "first" : "second");
    }
}
}