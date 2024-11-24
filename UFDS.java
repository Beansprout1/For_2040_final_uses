import java.util.*;

class UFDS {
    int[] p;
    int rank;

    UFDS () {

    }

    public int findSet(int elem) {
        if (p[elem] == elem) {
            return elem;
        }
        else {
            p[elem] = findSet(p[elem]);
            return p[elem];
        }
    }

    boolean isSameSet(int a, int b) {
        if (findSet(a) == findSet(b)) {
            return true;
        }
        else {
            return false;
        }
    }
}