import java.util.*;
public class a {
    public static void main(String[] args)
        {
            Scanner input = new Scanner(System.in);
            int n = input.nextInt(), m = input.nextInt();
            int[][] data = new int[n][m];
            for(int i = 0; i<n; i++)
                for(int j = 0; j<m; j++)
                    data[i][j] = input.nextInt();
            int num = go(data);
            int res = n;
            for(int i = 0; i<num; i++) res /= 2;
            System.out.println(res);
        }
        static int go(int[][] data)   
        {
            int n = data.length, m = data[0].length;
            if(n%2 == 1) return 0;
            boolean good = true;
            for(int i = 0; i<n; i++)
                for(int j = 0; j<m; j++)
                    if(data[i][j] != data[n-i-1][j])
                        good = false;
            if(!good) return 0;
            int[][] top = new int[n/2][m], bottom = new int[n/2][m];
            for(int i = 0; i<n/2; i++)
                for(int j = 0; j<m; j++)
                {
                    top[i][j] = data[i][j];
                    bottom[i][j] = data[i+n/2][j];
                }
            return 1 + Math.min(go(top), go(bottom));
        }
}