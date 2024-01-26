package arrays;

public class RearrangeArrayElementsAlternatePosNeg {
    public static int[] rearrangeArray(int[] nums) {
        int[] temp = new int[nums.length];
        int pos=0,neg=1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                temp[pos]=nums[i];
                pos+=2;
            }
            else{
                temp[neg]=nums[i];
                neg+=2;
            }
        }
        return temp;
    }
    public static void main(String[] args) {
        int[] nums= new int[]{3,1,-2,-5,2,-4};
        int[] res = rearrangeArray(nums);
        for (int re : res) {
            System.out.println(re + " ");
        }
    }
}
