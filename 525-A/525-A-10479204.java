import java.util.*;
public class a {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    String s = input.next();
    int res = 0;
    int[] counts = new int[26];
    for(int i= 0; i<s.length(); i++)
    {
        char c = s.charAt(i);
        if(c >= 'a' && c <= 'z') counts[c - 'a']++;
        else
        {
            if(counts[c-'A'] > 0) counts[c-'A']--;
            else res++;
        }
    }
    System.out.println(res);
}
}