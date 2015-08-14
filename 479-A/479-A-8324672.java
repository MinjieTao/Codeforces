import java.util.*;
public class aa {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int a = input.nextInt(), b = input.nextInt(), c = input.nextInt();
    int max = 0;
    ArrayList<Integer> poss = new ArrayList<Integer>();
    poss.add(a+b+c);
    poss.add(a*b*c);
    poss.add((a+b)*c);
    poss.add(a*(b+c));
    
    for(int x: poss) max = Math.max(max, x);
    System.out.println(max);
}
}