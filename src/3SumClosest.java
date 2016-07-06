public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int closest = nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            if(i!=0 && nums[i]==nums[i-1]) continue;
            int left = i+1;
            int right = nums.length-1;
            while(left<right){
                int sum = nums[i] + nums[left] + nums[right];
                if(target == sum){
                    return target;
                }else if(target > sum){
                    left ++;
                    while(left < right && nums[left]==nums[left-1]) left++;
                }else{
                    right --;
                    while(left < right && nums[right]==nums[right+1]) right--;
                }
                
                closest = Math.abs(target - closest) < Math.abs(target-sum) ? closest:sum;
                
            }
        }
        
        return closest;
    }
}