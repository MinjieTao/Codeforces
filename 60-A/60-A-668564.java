import java.util.*;
import java.io.*;
public class cerealguy
{
public static void main(String[] args)
{
Scanner input = new Scanner(System.in);
int size = input.nextInt();
int[] boxes = new int[size];
for(int i = 0; i < size; i++)
boxes[i] = 1;
int hints = input.nextInt();

for(int i = 0; i < hints; i++)
{
input.next();
input.next();
Boolean way;
String dir = input.next();
if(dir.equals("left"))
way = false;
else
way = true;
input.next();
int index = input.nextInt();
if(!(way))
{
for(int j = index-1; j < size; j++)
boxes[j]--;
}
else
{
for(int j = 0; j < index; j++)
boxes[j]--;
}
}
int counter = 0;
for(int k: boxes)
{
if(k == 1)
counter++;
}
if(counter==0)
System.out.println(-1);
else
System.out.println(counter);


}
}