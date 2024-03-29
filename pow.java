//Leetcode 50 Pow(x,n)
//recursive - solution1
class Solution {
    public double myPow(double x, int n) {
        if(n==0){
            return 1;
        }
        double half = myPow(x,n/2);
        if(n%2 == 0)return half*half;
        if(n>0)return half*half*x;
        return half*half/x;
        
    }
}


//iterate - solution2
class Solution {
    public double myPow(double x, int n) {
        double res = 1.0;
        for(int i =n;i!=0;i /= 2){
        if(i%2 != 0){
            res *= x;
        }
        x *=x;
        
    }
    return n>0?res:1/res;
    }
}
