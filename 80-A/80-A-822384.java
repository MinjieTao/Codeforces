import java.util.*;
public class Panoramix {
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        int[] array = {2, 2, 3, 5, 5, 7, 7, 11, 11, 11, 11, 13, 13, 17, 17, 17, 17, 19, 19, 23, 23, 23, 23, 29, 29, 29, 29, 29, 29, 31, 31, 37, 37, 37, 37, 37, 37, 41, 41, 41, 41, 43, 43, 47, 47, 47, 47, 53, 53, 53, 53, 53, 53};
        int m = input.nextInt();
        int n = input.nextInt();
        if(n == array[m])
            System.out.println("YES");
        else
            System.out.println("NO");
    }

}