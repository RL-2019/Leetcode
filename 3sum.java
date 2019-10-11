//Leetcode 15  3Sum   Medium
//
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        for(int i = 0;i<nums.length-2;i++){
            if(nums[i]>0){
                break;
            }
            int j = i+1;
            int k = nums.length-1;
            if(i>0 && nums[i] == nums[i-1]){
                continue;
            }
            while(j<k){
                if((k<nums.length-1) &&(nums[k] == nums[k+1])){
                    k--;
                    continue;
                }
                if((nums[i]+nums[j]+nums[k])>0){
                    k--;
                }else if((nums[i]+nums[j]+nums[k])<0){
                    j++;
                }else{
                    ArrayList<Integer> list = new ArrayList<Integer> ();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    result.add(list);
                    j++;
                    k--;
                    
                }
            }
        }
        return result;
        
    }
}
