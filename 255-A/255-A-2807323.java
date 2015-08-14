import java.util.*;
public class a {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int ch = 0, bi = 0, ba = 0;
    for(int i = 0; i<n; i++)
    {
        if(i%3 == 0) ch += input.nextInt();
        else if(i%3 == 1) bi += input.nextInt();
        else ba += input.nextInt();
    }
    if(ch > bi && ch > ba) System.out.println("chest");
    else if(bi > ba) System.out.println("biceps");
    else System.out.println("back");
}
}