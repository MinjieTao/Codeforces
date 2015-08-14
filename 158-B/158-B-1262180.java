import java.util.*;
public class b {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int[] data = new int[4];
    for(int i = 0; i<n; i++)
        data[input.nextInt()-1]++;
    int count = 0;
    count += data[3];
    data[3] = 0;
    count += data[2];
    data[0] -= Math.min(data[0], data[2]);
    data[2] = 0;
    count += data[1]/2;
    data[1] %= 2;
    if(data[1] > 0)
        data[0]+=2;
    count += data[0]/4;
    data[0] -= 4*(data[0]/4);
    if(data[0] > 0)
        count++;
    System.out.println(count);
}
}