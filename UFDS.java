import java.util.*;

public class UFDS {
    
    int[] p;
    int[] rank;

    UFDS(int N) {
        
        this.p = new int[N];
        this.rank = new int[N];

        for (int i = 0; i< N; i++) {
            p[i] = i;
            rank[i] = 0;
        }
    }

    UFDS(int[] arr) {
        int sizee = arr.length;
        this.p = new int[sizee];
        this.rank = new int[sizee];

        for (int i : arr) {
            p[i] = i;
            rank[i] = 0;
        }
    }

    int findSet(int val) {

        if (p[val] == val) {
            return val;
        }
        else {
            p[val] = findSet(p[val]);
            return p[val];
        }
    }

    boolean isSameSet (int a, int b){
        return findSet(a) == findSet(b);
    }

    public void unionSet(int i, int j) {

        int boss1 = findSet(i);
        int boss2 = findSet(j);
        if (rank[boss1] > rank [boss2]) {
            p[boss2] = boss1;
        }
        else {
            p[boss1] = boss2;

            if (rank[boss1] ==rank[boss2]) {
                rank[boss2] = rank[boss2] + 1;
            }
        }
    }
}
