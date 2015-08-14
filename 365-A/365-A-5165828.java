import java.util.*;
public class aa {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt(), k  = input.nextInt();
    int count = 0;
    for(int  i= 0; i<n; i++)
    {
        String s = input.next();
        HashSet<Character> set = new HashSet<Character>();
        for(int j = 0; j<s.length(); j++)
            if(s.charAt(j) - '0' <= k) set.add(s.charAt(j));
        if(set.size() == k+1) count++;
    }
    System.out.println(count);
}
}