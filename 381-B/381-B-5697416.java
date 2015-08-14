import java.util.*;
public class a {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int[] freq = new int[5001];
    for(int i = 0; i<n; i++) freq[input.nextInt()]++;
    ArrayList<Integer> res = new ArrayList<Integer>();
    for(int i = 1; i<5001; i++)
    {
        if(freq[i] > 0) res.add(i);
    }
    int max = res.get(res.size()-1);
    for(int i = max-1; i>=1; i--)
    {
        if(freq[i] > 1) res.add(i);
    }
    System.out.println(res.size());
    for(int i = 0; i<res.size(); i++) System.out.print(res.get(i)+" ");
}
}