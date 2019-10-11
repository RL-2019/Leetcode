//Leetcode  167   Two Sum II
//solution 1-- binary search
//
//
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        for (int i = 0; i<numbers.length;i++){
            int t = target - numbers[i];
            int left = i+1;
            int right = numbers.length;
            while(left<right){
                int m = left+(right-left)/2;
                if(numbers[m] == t){
                    res[0] = i+1;
                    res[1] = m+1;
                    return res;
                }else if(numbers[m]<t){
                    left = m+1;
                }else{
                      right = m;
                }
                  
            }
        }
        return res;
        
    }
}


//solution 2 -- two pointers
//
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length-1;
        int[] res = new int[2];
        while(l<r){
            int sum = numbers[l]+numbers[r];
            if(sum == target){
                res[0] = l+1;
                res[1] = r+1;
                return res;
                
            }else if(sum<target){
                l++;
            }else{
                r--;
            }
        }
        return res;
        
    }
}

