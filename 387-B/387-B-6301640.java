import java.util.*;
public class bb {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt(), m = input.nextInt();
    PriorityQueue<Integer> first = new PriorityQueue<Integer>(), second = new PriorityQueue<Integer>();
    for(int i = 0; i<n; i++) first.add(input.nextInt());
    for(int i = 0; i<m; i++) second.add(input.nextInt());
    while(!first.isEmpty() && !second.isEmpty())
    {
        int a = first.peek(), b = second.poll();
        if(b>=a) first.poll();
    }
    System.out.println(first.size());
}
}