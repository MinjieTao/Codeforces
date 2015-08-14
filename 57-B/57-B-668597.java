import java.util.*;
import java.math.*;

public class martianarch2
{
public static void main(String[] args) 
{
                    Scanner input = new Scanner(System.in);
                    int n = input.nextInt(), m = input.nextInt(), k = input.nextInt();
                    int[][] a = new int[m][];
                    for (; m-- > 0;) {
                    a[m] = new int[] { input.nextInt(), input.nextInt(), input.nextInt() };
                    }
                    long r = 0;
                    for (; k-- > 0;) {
                            int x = input.nextInt();
                            for (int[] b : a) {
                                    if (b[0] <= x && x <= b[1]) {
                                            r +=(x + b[2] - b[0]);
                                    }
                            }
                    }
                    System.out.println(r);
}
}