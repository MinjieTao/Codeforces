import java.util.*;
public class aa {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int[][] masks = new int[][]{
            {0, 1, 2, 3, 4, 5},
            {1, 2},
            {0, 1, 3, 4, 6},
            {0, 1, 2, 3, 6},
            {1, 2, 5, 6},
            {0, 2, 3, 5, 6},
            {0, 2, 3, 4, 5, 6},
            {0, 1, 2},
            {0, 1, 2, 3, 4, 5, 6},
            {0, 1, 2, 3, 5, 6}
    };
    int[] ms = new int[10];
    for(int i = 0; i<10; i++)
        for(int j = 0; j<masks[i].length; j++)
            ms[i] |= (1<<(masks[i][j]));
    String s = input.next();
    if(s.length() == 1)
    {
        int res = 0;
        int cur = ms[s.charAt(0) - '0'];
        for(int i = 0; i<10; i++)
        {
            if((ms[i] & cur) == cur) res++;
        }
        System.out.println(res);
    }
    else
    {
        int res1 = 0;
        int cur = ms[s.charAt(0) - '0'];
        for(int i = 0; i<10; i++)
        {
            if((ms[i] & cur) == cur) res1++;
        }
        int res2 = 0;
        cur = ms[s.charAt(1) - '0'];
        for(int i = 0; i<10; i++)
        {
            if((ms[i] & cur) == cur) res2++;
        }
        System.out.println(res1*res2);
    }
}
}