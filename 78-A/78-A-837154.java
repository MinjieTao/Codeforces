import java.util.*;
public class Haiku {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    String line1 = input.nextLine();
    String line2 = input.nextLine();
    String line3 = input.nextLine();
    if(vowelCounter(line1) == 5&& vowelCounter(line2) == 7 && vowelCounter(line3)==5)
        System.out.println("YES");
    else
        System.out.println("NO");
}
public static int vowelCounter(String s)
{
    s = s.toLowerCase();
    int count = 0;
    for(int i = 0; i<s.length(); i++)
        if(s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u')
            count++;
    return count;
}
}