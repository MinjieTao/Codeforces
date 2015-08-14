import java.util.*;
public class a {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int pages = input.nextInt();
    int[] days = new int[7];
    for(int i = 0; i<7; i++)
        days[i] = input.nextInt();
    int all = 0;
    while(pages > 0)
    {
        pages -= days[all%7];
        all++;
    }
    if(all%7!=0)
    System.out.println((int)(all%7));
    else
        System.out.println(7);
}
}