import java.util.Scanner;
public class b {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int[][] data = new int[3][3];
    for(int i = 0; i<3; i++)
        for(int j = 0; j<3; j++)
            data[i][j] = input.nextInt();
    int eminusi = data[1][2] + data[0][2] - data[0][1] - data[2][1];
    int aplusi = data[0][2] + data[2][0];
    for(int i = 1; i<= 100000; i++)
    {
        int e = i + eminusi;
        int a = aplusi - i;
        if(a > 0 && e > 0 && a<= 100000 && e <= 100000)
        {
            data[0][0] = a;
            data[1][1] = e;
            data[2][2] = i;
            if(check(data))
            break;
        }
    }
    for(int i = 0; i<3; i++)
    {
        for(int j = 0; j<3; j++)
            System.out.print(data[i][j] + " ");
        System.out.println();
    }
}
public static boolean check(int[][] data)
{
    int row1 = data[0][0] + data[0][1] + data[0][2];
    int row2 = data[1][0] + data[1][1] + data[1][2];
    int row3 = data[2][0] + data[2][1] + data[2][2];
    int col1 = data[0][0] + data[1][0] + data[2][0];
    int col2 = data[0][1] + data[1][1] + data[2][1];
    int col3 = data[0][2] + data[1][2] + data[2][2];
    int diag1 = data[0][0] + data[1][1] + data[2][2];
    int diag2 = data[2][0] + data[1][1] + data[0][2];
    return row1 == row2 && row1 == row3 && row1 == col1 && row1 == col2 && row1 == col3 && row1 == diag1 && row1 == diag2;
    
}
}