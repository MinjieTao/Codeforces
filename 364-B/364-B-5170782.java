import java.util.*;
public class b {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt(), d = input.nextInt();
    boolean[] possible = new boolean[1000000];
    possible[0] = true;
    int[] data = new int[n];
    for(int i = 0; i<n; i++) data[i] = input.nextInt();
    for(int i = 0; i<n; i++)
    {
        for(int j = 600000; j>=0; j--)
            if(possible[j])
                possible[j+data[i]] = true;
    }
    Queue<Integer> good = new LinkedList<Integer>();
    for(int i = 0; i<possible.length; i++) if(possible[i]) good.add(i);
    good.poll();
    int ans = 0, count = 0;
    while(!good.isEmpty())
    {
        if(good.peek() - ans > d) break;
        int next = good.poll();
        while(!good.isEmpty() && good.peek() - ans <= d)
        {
            next = good.poll();
        }
        ans = next;
        count++;
    }
    System.out.println(ans+" "+count);
}
}