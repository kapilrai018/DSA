
import java.util.Scanner;

public class reverseInteger {
    public static int reverse(int num){
        int finalnum=0;
        while(num > 0){
            int rem=num % 10 ;
          finalnum=finalnum * 10 + rem;
            num/=10; 
        }
        return finalnum; 
    }
  public static void main(String [] args){
    Scanner sc=new Scanner(System.in);
    System.out.println(" enter the our number which you want to reverse");
    int num=sc.nextInt();
    int reverse=reverse(num);
    System.out.println("Original number" + num +" reverse number" + reverse);
  }
}
