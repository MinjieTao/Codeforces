import java.util.*;
public class b {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt(), m = input.nextInt();
    String[] data = new String[n];
    for(int i = 0; i<n; i++) data[i] = input.next();
    HashSet<Integer> set =new HashSet<Integer>();
    boolean good = true;
    for(int i = 0; i<n; i++)
    {
        int x = data[i].indexOf('S') - data[i].indexOf('G');
        if(x<0) good = false;
        set.add(x);
    }
    System.out.println(good ? set.size() : -1);
}
}