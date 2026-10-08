class Solution {
    public static boolean isPalindrome(int x) {
        int num = x;
        int reverse = 0;
        if( x < 0 ){
         return false;
        }
        
        while( x != 0){
            int digit = x % 10;
            reverse = reverse * 10 + digit;
            x /= 10;
        }
        return num==reverse;
    }
        public static void main(String[] args){
            Scanner sc=new Scanner(System.in);
            int x=sc.nextInt();
            boolean isPalindrome=isPalindrome(x);
            if(isPalindrome){
                System.out.println("true");
            }else{
                System.out.println("false");
            }
        }
        
    }
