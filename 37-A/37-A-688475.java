import java.util.*;
import java.io.*;
public class towers
{
public static void main(String[] args) throws IOException
{
int counter = 0;
Scanner input = new Scanner(System.in);
int numBars = input.nextInt();
int[] lengths = new int[1001];
for(int i = 0; i < numBars; i++)
lengths[input.nextInt()]++;
int max = 0;
for(int j: lengths)
{
if(j>0)
counter ++;
if (j > max)
max = j;
}
System.out.println(max + " " + counter);

}
}