import java.util.*;
class Solution {
    public static int divide(int dividend, int divisor) {
        int rem = dividend/divisor;
        return rem;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int  y = sc.nextInt();
        System.out.println(divide(x,y));
    }
}
