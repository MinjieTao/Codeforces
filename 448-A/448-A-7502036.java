import java.util.*;
public class a {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int needed = (input.nextInt() + input.nextInt() + input.nextInt() + 4)/5 + (input.nextInt() + input.nextInt() + input.nextInt() + 9)/10;
    System.out.println(input.nextInt() >= needed ? "YES" :"NO");
}
}