import java.util.*;
public class a {
public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int[] xs = new int[n], ys = new int[n];
    int xsum = 0, ysum = 0;
    boolean good = false;
    for(int i = 0; i<n; i++)
    {
        xsum += (xs[i] = input.nextInt());
        ysum += (ys[i] = input.nextInt());
        if((xs[i] - ys[i])%2 != 0) good = true;
    }
    if(xsum%2 == ysum%2 && xsum%2 == 0) System.out.println(0);
    else if(good && xsum%2 == 1 && ysum%2 == 1) System.out.println(1);
    else System.out.println(-1);
}
}