import java.util.*;

class bintree {

    List<Integer> binaryTree; //= new ArrayList<Integer>();
    int heapsize;

    bintree(List<Integer> binaryTree) {

        this.binaryTree = binaryTree;

    }

    bintree() {

        this.binaryTree = new ArrayList<Integer>();
    }




    //return the index, so i must key in the index of my stuff
    public static int parent (int vert) {
        return vert >>1;
    }

    public static int left (int vert) {
        return vert << 1;
    }

    public static int right (int vert) {
        return (vert << 1) + 1;
    }

    //not index
    void Insert (int val) {
        heapsize = heapsize + 1;
        binaryTree.set(heapsize, val);
        ShiftUp(heapsize);

    } 

    void ShiftUp (int index) {
        while ((index > 1) && (binaryTree.get(index) > binaryTree.get(parent(index)))) {
            int placeHolder = binaryTree.get(parent(index));
            binaryTree.set(parent(index), binaryTree.get(index));
            binaryTree.set(index, placeHolder);
            index = parent(index);
        }
    }

    int ExtractMax() {

        int max = binaryTree.get(1);
        binaryTree.set(1, binaryTree.get(heapsize));
        heapsize = heapsize - 1;
        ShiftDown(1);




        return max;
    }

    void ShiftDown(int index) {
        while (index <= heapsize){
            int maxV = binaryTree.get(index);
            int max_id = index;

            if (left(index) <= heapsize && maxV < binaryTree.get(left(index))) {
                maxV = binaryTree.get(left(index));
                max_id = left(index);
            }
            if (right(index) <= heapsize && maxV < binaryTree.get(right(index))) {
                maxV = binaryTree.get(right(index));
                max_id = right(index);
            }

            if ((max_id) != index) {
                int placeHolder = binaryTree.get(index);
                binaryTree.set(index, maxV);
                binaryTree.set(max_id, binaryTree.get(index));

                index = max_id;
            }
            else {
                break;
            }

        }
    }

    public static bintree CreateHeapSlow(List<Integer> arr) {

        int size = arr.size();
        bintree binHeap = new bintree();
        for (int i = 0; i < size; i++) {
            binHeap.Insert(arr.get(i));
        }

        return binHeap;

    }

    public static bintree CreateHeap(List<Integer> arr) {

        int sizee = arr.size();
        List<Integer> arr1 = new ArrayList<Integer>();
        arr1.add(0);
        for (int i = 1; i < sizee; i++) {
            arr1.add(arr.get(i - 1));
        }
        bintree dis = new bintree(arr1);

        for (int j = parent(sizee); j < 1; sizee -= 1) {
            dis.ShiftDown(j);
        }

        return dis;

    }
    //sort using heap.
    List<Integer> HeapSort(List<Integer> a) {

        bintree aa = CreateHeap(a);
        int N = a.size();
        List<Integer> ans = new ArrayList<Integer>();
        for (int i = 1; i <= N; i++) {
            
            ans.add(aa.ExtractMax());
        }





        return ans;
    }


}