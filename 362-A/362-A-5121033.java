import java.util.*;
public class a {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int T = input.nextInt();
    for(int t = 0; t<T; t++)
    {
        char[][] data = new char[8][8];
        char[][] copy = new char[8][8];
        for(int i = 0; i<8; i++) data[i] = copy[i] = input.next().toCharArray();
        int i1 = 0, j1 = 0, i2 = 0, j2 = 0;
        for(int i =0; i<64; i++)
        {
            int r = i/8, c = i%8;
            if(data[r][c] == 'K')
            {
                i1 = r;
                j1 = c;
                data[r][c] = 'L';
                break;
            }
        }
        for(int i = 0; i<64; i++)
        {
            int r = i/8, c = i%8;
            if(data[r][c] == 'K')
            {
                i2 = r;
                j2 = c;
            }
        }
        int[] dx = new int[]{2, 2, -2, -2};
        int[] dy = new int[]{2, -2, 2, -2};
        boolean found = false;
        for(int z = 0; z<70; z++)
        {
            for(int i = 0; i<8; i++)
                for(int j = 0; j<8; j++)
                {
                    if(data[i][j] == 'K' || data[i][j] == 'L')
                    {
                        for(int k = 0; k<4; k++)
                        {
                            int ni = i+dx[k], nj = j+dy[k];
                            if(ni<0||ni>7||nj<0||nj>7) continue;
                            if(data[ni][nj] == 'K' && data[i][j] == 'L' || data[ni][nj] == 'L' && data[i][j] == 'K' && copy[i][j] != '#') found = true;
                            data[ni][nj] = data[i][j];
                        }
                    }
                }
        }
        if((Math.abs(i1-i2)/2)%2 == 1 && (Math.abs(j1-j2)/2)%2 == 1) found = false;
        System.out.println(found ? "YES" : "NO");
    }
}
}