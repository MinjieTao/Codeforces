import java.util.*;
public class bb {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt(), k = input.nextInt(), x =input.nextInt();
    ArrayList<Integer> list = new ArrayList<Integer>();
    for(int i = 0; i<n; i++) list.add(input.nextInt());
    int res = 0;
    for(int i = 0; i<=n; i++) res = Math.max(res, process(list, x, i));
    System.out.println(res);
}
static int process(ArrayList<Integer> l, int x, int idx)
{
    ArrayList<Integer> list = new ArrayList<Integer>();
    for(int i = 0; i<l.size(); i++)
    {
        if(i == idx) list.add(x);
        list.add(l.get(i));
    }
    int n = list.size();
    if(idx == n) list.add(x);
    for(int i = 0; i<n-2; i++)
    {
        if(i<0) i = 0;
        if(i+2 >= list.size()) break;
        if(list.get(i) == list.get(i+1) && list.get(i+1) == list.get(i+2))
        {
            int y = list.get(i);
            while(i<list.size() && list.get(i) == y)
                list.remove(i);
            i -= 3;
        }
    }
    //System.out.println(list.size());
    return l.size() - list.size();
}
}