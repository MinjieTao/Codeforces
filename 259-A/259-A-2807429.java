import java.util.*;
public class a {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    String[] data = new String[8];
    for(int i = 0; i<8; i++)
        data[i] = input.next();
    boolean okay = true;
    for(int i = 0; i<8; i++)
    {
        for(int j = 0; j<8; j++)
        {
            char c1 = data[i].charAt(j), c2 = data[i].charAt((j+1)%8);
            if(c1 == c2)
                okay = false;
        }
    }
    System.out.println(okay? "YES" : "NO");
}
}