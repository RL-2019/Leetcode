//Leetcode 18  4Sum
//
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        for(int i = 0;i<nums.length-3;i++){
            if(i>0 && nums[i]== nums[i-1])continue;
            for(int j = i+1;j<nums.length-2;j++){
                if(j>i+1 && nums[j] == nums[j-1])continue;
                int left = j+1, right = nums.length-1;
                while(left<right){
                    int sum = nums[i]+nums[j]+nums[left]+nums[right];
                    if(sum==target){
                        ArrayList<Integer> list = new ArrayList<Integer>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        result.add(list);
                        while(left<right && nums[left]==nums[left+1]) left++;
                        while(left<right && nums[right]== nums[right-1])right--;
                        left++;
                        right--;
                            
                    }else if(sum < target)left++;
                    else right--;
                }
            }
        }
        return result;
        
    }
}

