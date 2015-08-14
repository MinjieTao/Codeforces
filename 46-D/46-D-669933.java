import java.util.*;
public class parkinglot
{
public static void main(String[] args)
{
Scanner input = new Scanner(System.in);
String out = "";
int length = input.nextInt();
int[] full = new int[length];
int b = input.nextInt();
int f = input.nextInt();
int num = input.nextInt();

//System.out.println(num);
for(int i = 0; i < num; i++)
{
int type = input.nextInt();
int size = input.nextInt();
if(type == 1)
{
int counter = 0;
int place = -1;
//System.out.println(space);

//for(int n: full)
//System.out.print(n + " ");

for(int j=0; j<length; j++)
{
if(full[j]==0)
counter++;
else
counter = 0;
if(((counter >= size + f) && (counter-j==1) || (counter >= size + f + b) || (counter >= size + b) && (j == length -1) || (counter == size && counter == length)) && ((place == -1) || (j <= place)))
{
/**
System.out.println("found");
System.out.println(i);
System.out.println(j);
System.out.println(counter);
System.out.println(b);
System.out.println(place);
System.out.println(size);
*/
if(j - counter + 1 > 0)
place = j - counter + b + 1;
else
place = 0;
counter = 0;

}
}

out += (place + "\n");
if(place!=-1)
{
for(int k = place; k < place + size; k++)
full[k] = i+1;
}



}
else
{
int counter = 1;
int index = 0;

while(index < length)
{
if(full[index] == size)
full[index] = 0;
index++;
}

}
//for(int n: full)
//System.out.print(n + " ");
//System.out.println("");
}
System.out.println(out);
}
}