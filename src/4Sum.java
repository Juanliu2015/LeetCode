public class Solution {
    
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new LinkedList<>();
        for(int i=0; i<nums.length-3;i++){
            if(i!=0 && nums[i]==nums[i-1]) continue;
            List<List<Integer>> tempResult = threeSum(nums, i+1,target-nums[i]);
            if(!tempResult.isEmpty()){
                
                for(List<Integer> list:tempResult){
                    LinkedList<Integer> temp = new LinkedList<Integer>();
                    temp.add(nums[i]);
                    temp.addAll(list);
                    result.add(temp);
                }
            }
        }
            return result;
            
    }
        
    public List<List<Integer>> threeSum(int[] nums, int start,int remain) {
        List<List<Integer>> result = new LinkedList<>();
        
        if(nums==null || nums.length < 3){
            return result;
        }
        Arrays.sort(nums);
        for(int i=start; i<nums.length-2; i++){
            if(i!= start && nums[i] == nums[i-1]) continue;
            int left = i+1;
            int right = nums.length-1;
            while(left < right){
                if(nums[left]+nums[right] == remain - nums[i]){
                    List<Integer> temp = new LinkedList<Integer>();
                    temp.add(nums[i]);
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    result.add(temp);
                    left ++;
                    right --;
                    while(left < right && nums[left] == nums[left-1]) left++;
                    while(left < right && nums[right] == nums[right+1]) right--;
                }else if(nums[left]+nums[right] < remain - nums[i]){
                    left ++;
                }else{
                    right --;
                }
                
                
            }
        }
        return result;
    }
        
    

}