package com.company;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        Stack<Integer> st = new Stack<>();
        Stack<Integer> max = new Stack<>();

        for (int i = 0; i < n; i++){
            switch(scan.nextInt()){
                case 1:
                    int nxt = scan.nextInt();
                    st.push(nxt);
                    if(max.isEmpty() || max.peek() <= nxt)
                        max.push(nxt);
                    break;
                case 2:
                    int old = st.pop();
                    if(max.peek() == old)
                        max.pop();
                    break;
                case 3:
                    System.out.println(max.peek());
                    break;
                default:
                    break;
            }
        }
    }
}
