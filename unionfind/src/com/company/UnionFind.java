package com.company;

public class UnionFind {
    private int[] sz;
    private int[] id;

    public UnionFind(int n){
        id = new int[n];
        sz = new int[n];
        for(int i = 0; i < n; i++) {
            id[i] = i;
            sz[i] = 1;
        }
    }
    private int root(int i){
        if(i != id[i]) {
            /*int j = root(id[i]);
            id[i] = id[id[i]];
            return j;*/
            return root(id[i]);
        }else{
            return i;
        }
    }
    public boolean connected(int p, int q){
        p--;
        q--;
        return root(p) == root(q);
    }

    public int size(int i){
        i--;
        return sz[root(i)];
    }

    public void union(int p, int q){
        p--;
        q--;
        int i = root(p);
        int j = root(q);
        if (i == j) return;
        if (sz[i] < sz[j]){
            id[i] = j;
            sz[j] += sz[i];
        }else{
            id[j] = i;
            sz[i] += sz[j];
        }
    }
}
