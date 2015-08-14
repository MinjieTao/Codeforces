import java.util.*;
public class aa {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int t = input.nextInt();
    int[] fs = new int[10], fs2 = new int[10];
    String s = input.next();
    for(int i = 0; i<(t+"").length(); i++) fs[(t+"").charAt(i)-'0']++;
    for(int i =0; i<s.length(); i++) fs2[s.charAt(i)-'0']++;
    fs[2] += fs[5];
    fs[5] = 0;
    fs2[2] += fs2[5];
    fs2[5] = 0;
    fs[6] += fs[9];
    fs[9] = 0;
    fs2[6] += fs2[9];
    fs2[9] = 0;
    int res = 987654;
    for(int i = 0; i<10; i++)
    {
        if(fs[i] == 0) continue;
        res = Math.min(res, fs2[i]/fs[i]);
    }
    System.out.println(res);
}
}