package SegmentTree;

public class SegmentTreeLazyPropagation {
    int[] seg,lazy;
    int n;
    SegmentTreeLazyPropagation(int[] nums){
        n=nums.length;
        seg=new int[4*n];
        lazy = new int[4*n];
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

    //push lazy value to children
    public void push(int pos,int l,int r){
        if(lazy[pos]!=0){
            int pending = lazy[pos];
            // apply to current node
            seg[pos] = seg[pos] + pending * (r - l + 1);
            //not a leaf → push to children
            if(l!=r){
                lazy[pos*2+1] = lazy[pos*2+1]+pending;
                lazy[pos*2+2] = lazy[pos*2+2]+pending;
            }
            lazy[pos] = 0; // clear current node
        }
    }

    public void updateRange(int pos,int l,int r,int ql,int qr,int val){
        push(pos, l, r); // apply pending updates
        if(ql>r || qr<l)return;     //no overlap
        if(l>=ql && r<=qr){     //total overlap
            lazy[pos] = lazy[pos] + val;
            push(pos,l,r);
            return;
        }
        //partial overlap
        int mid = l+(r-l)/2;
        updateRange(2*pos+1, l, mid, ql, qr, val);
        updateRange(2*pos+2, mid+1, r, ql, qr, val);
        seg[pos]=seg[2*pos+1] + seg[2*pos+2];
    }
    // Range update: add val to all elements in [ql, qr]
    public void updateRange(int ql, int qr, int val) {
        updateRange(0, 0, n - 1, ql, qr, val);
    }

    public int query(int pos,int l,int r,int ql,int qr){
        push(pos, l, r); // ensure node is updated
        if(ql>r || qr<l) return 0; // no overlap
        if(l>=ql && r<=qr) return seg[pos]; // total overlap
        //partial overlap
        int mid = l+(r-l)/2;
        int left = query(2*pos+1,l,mid,ql,qr);
        int right = query(2*pos+2,mid+1,r,ql,qr);
        return left+right;
    }
    // Range sum query
    public int queryRange(int ql, int qr) {
        return query(0, 0, n - 1, ql, qr);
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7, 9, 11};

        SegmentTreeLazyPropagation seg = new SegmentTreeLazyPropagation(nums);

        System.out.println("Initial Sum(0, 5): " + seg.queryRange(0, 5));
        // Expected: 1+3+5+7+9+11 = 36

        // Update range: add 10 to every element from index 1 to 3
        seg.updateRange(1, 3, 10);

        System.out.println("After update (+10 to [1,3]) Sum(0, 5): " + seg.queryRange(0, 5));
        // Expected: 1 + (3+10) + (5+10) + (7+10) + 9 + 11 = 1 + 13 + 15 + 17 + 9 + 11 = 66

        System.out.println("Sum(1,3): " + seg.queryRange(1, 3));
        // Expected: 13 + 15 + 17 = 45

        // Another update
        seg.updateRange(2, 5, 5);

        System.out.println("After second update (+5 to [2,5]) Sum(0, 5): " + seg.queryRange(0, 5));
        // Expected final array: [1, 13, 20, 22, 14, 16]
        // Sum = 1+13+20+22+14+16 = 86
    }
}
