import java.util.*;
public class PetyaSquare {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int size = input.nextInt();
    size /=2;
    int x = input.nextInt();
    int y = input.nextInt();
    if((x == size || x == size+1) && (y==size || y == size+1))
        System.out.println("NO");
    else
        System.out.println("YES");
    
}
}