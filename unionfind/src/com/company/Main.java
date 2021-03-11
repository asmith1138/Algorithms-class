package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int q = scan.nextInt();

        UnionFind uf = new UnionFind(n);

        for (int i = 0; i < q; i++){
            switch(scan.next()){
                case "M":
                    uf.union(scan.nextInt(), scan.nextInt());
                    break;
                case "Q":
                    System.out.println(uf.size(scan.nextInt()));
                    break;
                default:
                    break;
                //System.out.println(scan.next());
            }
        }
    }
}

