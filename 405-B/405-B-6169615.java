import java.util.*;
public class bb {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    String s = input.next();
    boolean[] up = new boolean[n];
    int[] distLeft = new int[n], distRight = new int[n];
    Arrays.fill(up, true);
    for(int i = 0; i<n; i++)
    {
        if(s.charAt(i) == '.') continue;
        else if(s.charAt(i) == 'L')
        {
            int at = i, count = 1;
            while(at >= 0 && s.charAt(at) != 'R')
            {
                up[at] = false;
                distLeft[at] = count++;
                at--;
            }
        }
        else
        {
            int at = i, count = 1;
            while(at<n && s.charAt(at) != 'L')
            {
                up[at] = false;
                distRight[at] = count++;
                at++;
            }
        }
    }
    int count = 0;
    for(int i = 0; i<n; i++) if(distLeft[i] == distRight[i]) count++;
    System.out.println(count);
}
}