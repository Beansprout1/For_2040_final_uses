import java.util.*;

class bintree {

    List<Integer> binaryTree; //= new ArrayList<Integer>();
    int heapsize;

    bintree(List<Integer> binaryTree) {
        binaryTree = this.binaryTree;

    }




    //return the index, so i must key in the index of my stuff
    int parent (int vert) {
        return vert >>1;
    }

    int left (int vert) {
        return vert << 1;
    }

    int right (int vert) {
        return (vert << 1) + 1;
    }

    //not index
    void Insert (int val) {

    } 

    void ShiftUp (int index) {
        while ((index > 1) && (binaryTree.get(index) > binaryTree.get(parent(index)))) {
            int placeHolder = binaryTree.get(parent(index));
            binaryTree.set(parent(index), binaryTree.get(index));
            binaryTree.set(index, placeHolder);
        }
    }


}