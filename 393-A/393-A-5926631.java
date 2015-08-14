import java.util.*;
public class aa {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int[] freq = new int[26];
    String s = input.next();
    for(int i = 0; i<s.length(); i++) freq[s.charAt(i)-'a']++;
    int min = 100;
    min = Math.min(freq[4]/3, min);
    min = Math.min((freq[13]-1)/2,min);
    min = Math.min(min, freq[8]);
    min = Math.min(min,  freq[19]);
    System.out.println(min);
}
}