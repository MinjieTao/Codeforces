import java.util.*;
public class a {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int a = 0, b = 0;
    char[][] grid = new char[8][8];
    for(int i = 0; i<8; i++)
    {
        grid[i] = input.next().toCharArray();
        for(char c : grid[i])
        {
            if(c == 'Q') a+=9;
            if(c == 'q') b +=9;
            if(c == 'R') a+=5;
            if(c == 'r') b+=5;
            if(c == 'B') a +=3;
            if(c == 'b') b += 3;
            if(c == 'N') a+=3;
            if(c == 'n') b+=3;
            if(c == 'P') a++;
            if(c == 'p')b++;
        }
        
    }
    if(a == b) System.out.println("Draw");
    if(a > b)
    {
        System.out.println("White");
    }
    if(a < b) System.out.println("Black");
}
}