import java.util.*;
public class bb {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int p = input.nextInt(), q = input.nextInt(), l = input.nextInt(), r = input.nextInt();
    ArrayList<Integer> first = new ArrayList<Integer>(), second = new ArrayList<Integer>();
    for(int i = 0; i<p; i++)
    {
        int a = input.nextInt(), b = input.nextInt();
        for(int j = a; j<=b; j++) first.add(j);
    }
    for(int i = 0; i<q; i++)
    {
        int a = input.nextInt(), b = input.nextInt();
        for(int j = a; j<=b; j++) second.add(j);
    }
    HashSet<Integer> set = new HashSet<Integer>();
    for(int a : first)
        for(int b: second)
        {
            int diff = a - b;
            if(diff >= l && diff <= r) set.add(diff);
        }
    System.out.println(set.size());
}
}