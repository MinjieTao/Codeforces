import java.util.*;
import java.io.*;
public class luckytickets
{
public static void main(String[] args)
{
Scanner input = new Scanner(System.in);
int pieces = input.nextInt();
int[] tix = {0, 0, 0};
for(int i = 0; i < pieces; i++)
{
int j = input.nextInt();
tix[j%3]++;
}
int total = tix[0]/2;
if(tix[1] > tix[2])
total += tix[2];
else
total +=tix[1];
System.out.println(total);
}
}