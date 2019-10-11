//Leetcode 204 Count Primes  easy  Math

class Solution {
    public int countPrimes(int n) {
        Boolean[] prime = new Boolean[n];
        Arrays.fill(prime, Boolean.TRUE);
        int res = 0;
        for(int i = 2;i<n;i++){
            if(!prime[i]){
                continue;
            }
            res++;
            for(int j =2;i*j<n;j++){
                prime[i*j] = false;
            }
        }
        return res;
        
    }
}
