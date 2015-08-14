import java.util.*;
public class e {
    static int[] digits;
    static String[] map;
public static void main(String[] args)
{
    map = new String[43];
    Arrays.fill(map, "");
    for(int i = 0; i<3*3*3*3*3*3; i++)
    {
        int temp = i;
        int[] data = new int[6];
        int sum = 0;
        for(int j = 0; j<6; j++)
        {
            data[j] = temp%3;
            if(data[j] == 1) data[j] = 4;
            else if(data[j] == 2) data[j] = 7;
            sum += data[j];
            temp /= 3;
        }
        if(map[sum].equals("")) map[sum] = string(data);
    }
    Scanner input = new Scanner(System.in);
    int T = input.nextInt();
    for(int t =0; t<T; t++)
    {
        long n = input.nextLong();
        digits = new int[19];
        for(int i = 0; i<19; i++)
        {
            digits[i] = (int)(n%10);
            n /= 10;
        }
        memo = new int[19][15];
        sums = new int[19][15];
        answers = new int[19][15][6];
        for(int[] A: memo) Arrays.fill(A, -1);
        for(int[] A: sums) Arrays.fill(A, -1);
        for(int[][] A: answers) for(int[] B: A) Arrays.fill(B, -1);
        int res = go(0, 0);
        //System.out.println(res);
        if(res==1)
        {
            output = new int[6][19];
            traceback(0, 0);
            long[] ans = new long[6];
            for(int i = 18; i>=0; i--)
                for(int j = 0; j<6; j++)
                {
                    ans[j] *= 10;
                    ans[j] += output[j][i];
                }
            for(int i = 0; i<6; i++) System.out.print(ans[i]+" ");
            System.out.println();
        }
        else System.out.println(-1);
        
    }
}
static int[][] output;
static int[][][] answers;
static int[][] sums;
static int[][] memo;
static int go(int place, int carry)
{
    if(place == 19) return carry == 0 ? 1 : 0;
    if(memo[place][carry] != -1) return memo[place][carry];
    int res = 0;
    for(int i = 0; i<43; i++)
    {
        if(map[i].equals("")) continue;
        int total = i + carry;
        if(total%10 != digits[place] || go(place+1, total/10) == 0) continue;
        res = 1;
        sums[place][carry] = i;
        for(int j = 0; j<6; j++) answers[place][carry][j] = map[i].charAt(j) - '0';
        break;
    }
    return memo[place][carry] = res;
}
static void traceback(int place, int carry)
{
    if(place==19) return;
    int sum = sums[place][carry];
    for(int i = 0; i<6; i++) output[i][place] = answers[place][carry][i];
    traceback(place+1, (carry+sum)/10);
}
static String string(int[] a)
{
    String res = "";
    for(int i =0; i<a.length; i++) res += a[i];
    return res;
}
}