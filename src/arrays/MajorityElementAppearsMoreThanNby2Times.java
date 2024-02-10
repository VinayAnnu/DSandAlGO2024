package arrays;

public class MajorityElementAppearsMoreThanNby2Times {
    public static int majorityElement(int []nums) {
        int element=-1,count=0;
        for(int i=0;i<nums.length;i++){
            if(count==0){
                element=nums[i];
                count++;
            } else if(element==nums[i]){
                count++;
            } else{
                count--;
            }
        }
        return element;
    }
    public static void main(String[] args) {
        int res = majorityElement(new int[]{2, 2, 1, 3, 1, 1, 3, 1, 1,2,3,2,2,2});
        System.out.println(res);
    }
}
