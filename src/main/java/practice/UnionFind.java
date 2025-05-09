package practice;

public class UnionFind {
    int []root;
    UnionFind(int size){
        root = new int[size];
        for (int i = 0; i < size; i++) {
            root[i] = i;
        }
    }


    public void union(int x, int y){
        int rootX=find(x);
        int rootY = find(y);
        for(int i=0;i<root.length;i++){
            if(root[i]==rootY){
                root[i]=rootX;
            }
        }
    }


    public int find(int x){
        return root[x];
    }
    public boolean connected(int x,int y){
        if(root[x]==root[y])
            return true;


        return find(x) == find(y);
    }

    public static void main(String[] args) throws Exception {
        UnionFind uf = new UnionFind(10);
        // 1-2-5-6-7 3-8-9 4
        uf.union(1, 2);
        uf.union(2, 5);
        uf.union(6, 5);
        uf.union(6, 7);
        uf.union(3, 8);
        uf.union(8, 9);
        System.out.println(uf.connected(1, 5)); // true
        System.out.println(uf.connected(5, 7)); // true
        System.out.println(uf.connected(4, 9)); // false
        // 1-2-5-6-7 3-8-9-4
        uf.union(9, 4);
        System.out.println(uf.connected(4, 9)); // true
    }
}
