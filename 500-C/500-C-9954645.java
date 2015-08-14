import java.util.*;
public class c {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt(), m = input.nextInt();
    int[] ws = new int[n], bs = new int[m];
    for(int i = 0; i<n; i++) ws[i] = input.nextInt();
    for(int i = 0; i<m; i++) bs[i] = input.nextInt()-1;
    ArrayList<Integer> read = new ArrayList<Integer>();
    long res = 0;
    for(int i = 0; i<m; i++)
    {
        HashSet<Integer> toLift = new HashSet<Integer>();
        for(int j = read.size() - 1; j >= 0; j--)
        {
            if(read.get(j) == bs[i]) break;
            toLift.add(read.get(j));
        }
        for(int x: toLift) res += ws[x];
        read.add(bs[i]);
    }
    System.out.println(res);
}
}