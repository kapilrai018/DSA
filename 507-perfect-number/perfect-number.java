class Solution {
    public static boolean checkPerfectNumber(int n) {
        if(n <= 0){
            return false;
        }

        int sum=0;
        for(int j=1;j <= n/2; j++){
            if(n % j == 0){
                sum=sum+j;
            }
           
        }
         return n == sum;
    }
}