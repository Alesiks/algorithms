package by.bsu.mmf.datastructure.set;

public class DisjointSetTest {

    public static void main(String[] args) {
        DisjointSet ds = new DisjointSet();

        ds.makeSet(2);
        ds.makeSet(3);

        ds.makeSet(5);

        ds.makeSet(7);

        ds.union(2,3);
        ds.union(5,7);
    }

}
