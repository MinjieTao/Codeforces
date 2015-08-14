import java.util.*;
public class a {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    ArrayList<Integer> res = new ArrayList<Integer>();
    int v = input.nextInt();
    for(int i = 0; i<n; i++)
    {
        int k = input.nextInt(), count = 0;
        for(int j = 0; j<k; j++) if(input.nextInt() < v) count++;
        if(count > 0) res.add(i+1);
    }
    System.out.println(res.size());
    for(int x: res) System.out.print(x+" ");
}
}