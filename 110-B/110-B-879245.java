import java.util.*;
public class LuckyString{
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    StringBuilder out = new StringBuilder("");
        
    for(int i = 4; i<n+1; i+=4)
    {
        out.append("abcd");
    }
    for(int i = 0; i<n%4; i++)
    {
        out.append((char)('a'+i));
    }
    System.out.println(out);
}
}