import java.util.*;
public class NumberPositions {

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int a = input.nextInt();
        int b = input.nextInt();
        System.out.println(Math.min(n-a, b+1));
    }

}