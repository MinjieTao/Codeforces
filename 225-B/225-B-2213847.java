import java.util.*;
public class b {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int s = input.nextInt(), k = input.nextInt();
    ArrayList<Long> data = new ArrayList<Long>();
    data.add(1l);
    while(true)
    {
        long next = 0;
        for(int i = data.size()-1; i>= 0 && i >= data.size()-k; i--)
            next += data.get(i);
        if(next > 1e9)
            break;
        data.add(next);
    }
//  for(int i = 0; i<data.size(); i++)
//      System.out.println(data.get(i));
    long sum = 0;
    int n = data.size();
    ArrayList<Long> used = new ArrayList<Long>();
    for(int i = n-1; i>=0; i--)
    {
        long needed = s - sum;
        if(data.get(i) <= needed)
        {
            sum += data.get(i);
            used.add(data.get(i));
        }
            
    }
    if(used.size() ==1)
        used.add(0l);
    Collections.sort(used);
    System.out.println(used.size());
    for(int i = 0; i<used.size()-1; i++)
        System.out.print(used.get(i) + " ");
    System.out.println(used.get(used.size()-1));
}
}