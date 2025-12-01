package SegmentTree;

public class SegmentTreeRangeSumQuery {
    int[] seg;
    int n;
    public SegmentTreeRangeSumQuery(int[] nums) {
        n=nums.length;
        seg=new int[4*n];
        //build segment tree
        build(nums,0,0,n-1);
    }
    // build tree at node 'pos' covering range [l, r]
    public void build(int[] nums,int pos,int l,int r){
        if(l==r){
            seg[pos]=nums[l];
            return;
        }
        int mid = l+(r-l)/2;
        build(nums,2*pos+1,l,mid);
        build(nums,2*pos+2,mid+1,r);
        seg[pos]=seg[2*pos+1] + seg[2*pos+2];
    }

    public void update(int pos,int l,int r,int index,int val){
        if(l==r){
            seg[pos]=val;
            return;
        }
        int mid = l+(r-l)/2;
        if(index<=mid){
            update(2*pos+1,l,mid,index,val);
        }else{
            update(2*pos+2,mid+1,r,index,val);
        }
        seg[pos]=seg[2*pos+1] + seg[2*pos+2];
    }

    public void update(int index, int val) {
        update(0,0,n-1,index,val);
    }

    public int query(int pos,int l,int r,int ql,int qr){
        if(ql>r || qr<l)return 0;//no overlap
        if(l>=ql && r<=qr)return seg[pos];//total overlap
        //partial overlap
        int mid = l+(r-l)/2;
        int left = query(2*pos+1,l,mid,ql,qr);
        int right = query(2*pos+2,mid+1,r,ql,qr);
        return left+right;
    }
    public int sumRange(int left, int right) {
        return query(0,0,n-1,left,right);
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7, 9, 11};

        // Create NumArray object (builds tree)
        SegmentTreeRangeSumQuery obj = new SegmentTreeRangeSumQuery(nums);

        // Test 1: Query sum range
        System.out.println("Sum(0, 2) = " + obj.sumRange(0, 2));
        // Expected = 1 + 3 + 5 = 9

        // Test 2: Update index
        obj.update(1, 10);  // nums[1] = 3 → 10

        // Test 3: Query again after update
        System.out.println("Sum(0, 2) after update = " + obj.sumRange(0, 2));
        // Expected = 1 + 10 + 5 = 16

        // Test 4: Query full range
        System.out.println("Sum(0, 5) = " + obj.sumRange(0, 5));
        // Expected = 1 + 10 + 5 + 7 + 9 + 11 = 43
    }
}
