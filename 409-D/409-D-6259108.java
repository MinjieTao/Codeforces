import java.util.*;
public class d {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int[] res = new int[]
            {1, 0, 0, 1, 0, 1, 0, 1, 
        1, 1, 0, 0, 1, 0, 1, 0
            };
    System.out.println(res[input.nextInt()-1]);
}
}