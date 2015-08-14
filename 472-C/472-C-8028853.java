import java.util.*;
public class c {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    String[] first = new String[n], last = new String[n];
    for(int i = 0; i<n; i++)
    {
        first[i] = input.next(); last[i] = input.next();
        if(first[i].compareTo(last[i]) > 0)
        {
            String temp = first[i];
            first[i] = last[i];
            last[i] = temp;
        }
    }
    String cur = "";
    boolean good = true;
    for(int i = 0; i<n; i++)
    {
        int idx = input.nextInt()-1;
        if(cur.length() == 0 || first[idx].compareTo(cur) > 0)
        {
            cur = first[idx];
        }
        else if(last[idx].compareTo(cur) > 0) cur = last[idx];
        else good = false;
    }
    System.out.println(good ? "YES" : "NO");
}
}