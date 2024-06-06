import java.util.*;
public class Prcatice___Spiral___Matrix {
    public static void main(String args[]){
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int matrix[][] = new int[n][n];

            //taking matrix input 
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    matrix[i][j] = sc.nextInt();
                }
            }

            //algo for spiral printing
            int startrow = 0;
            int startcol = 0;
            int endrow = matrix.length-1;
            int endcol = matrix[0].length-1;

            while(startrow <= endrow && startcol <= endcol){
                //top
                for(int i=startcol; i<=endcol; i++){
                    System.err.print(matrix[startrow][i] + " ");
                }

                //right
                for(int j=startrow+1; j<=endrow; j++){
                    System.out.print(matrix[j][endcol] + " ");
                }

                //bottom
                for(int i=endcol-1; i>=startcol; i--){
                    if(startrow == endrow){
                        break;
                    }
                    System.out.print(matrix[endrow][i] + " ");
                }

                //left
                for(int j=endrow-1; j>startrow; j--){
                    if(startcol == endcol){
                        break;
                    }
                    System.out.print(matrix[j][startcol] + " ");
                }

                startrow++;
                startcol++;
                endrow--;
                endcol--;
            }
    }
}
