package com.company;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/*
* This code will output the answers to stdout
* it will take the input through stdin, I tested by typing into the console and by piping a txt file into stdin
* I changed the hacker rank code from an output file to standard out
* but I also tested on hackerrank and using stdout works on their site as well
* you can either compile and run locally or copy and paste to hacker rank and it should work
* */s

public class Main {

    final static char OPARN = '(';
    final static char OBRAK = '[';
    final static char OCURL = '{';
    final static char CPARN = ')';
    final static char CBRAK = ']';
    final static char CCURL = '}';
    final static String NO = "NO";
    final static String YES = "YES";

    // Complete the isBalanced function below.
    static String isBalanced(String s) {
        Stack<Character> st = new Stack<Character>();
        for (char p : s.toCharArray())
        {
            if(p == OCURL || p == OBRAK || p == OPARN)
            {
                st.push(p);
            }
            else if (!st.isEmpty() && ((p == CCURL && st.peek() == OCURL)
                    || (p == CPARN && st.peek() == OPARN)
                    || (p == CBRAK && st.peek() == OBRAK)))
            {
                st.pop();
            }
            else
            {
                return NO;
            }
        }
        if(st.isEmpty()){
            return YES;
        }else{
            return NO;
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out)/*new FileWriter(System.getenv("OUTPUT_PATH"))*/);

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String s = scanner.nextLine();

            String result = isBalanced(s);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
