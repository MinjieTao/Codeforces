import java.util.*;
public class a {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int[] freq1 = new int[26];
    int[] freq2 = new int[26];
    String s1 = input.next();
    String s2 = input.next();
    String s3 = input.next();
    for(int i = 0; i<s1.length(); i++)
    {
        freq1[s1.charAt(i)-'A']++;
    }
    for(int i = 0; i<s2.length(); i++)
    {
        freq1[s2.charAt(i)-'A']++;
    }
    for(int i = 0; i<s3.length(); i++)
    {
        freq2[s3.charAt(i)-'A']++;
    }
    boolean good = true;
    for(int i = 0; i<26; i++)
    {
        if(freq1[i] != freq2[i])
            good = false;
    }
    if(good)
        System.out.println("YES");
    else
        System.out.println("NO");
}
}