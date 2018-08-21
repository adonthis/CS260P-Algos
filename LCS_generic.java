package test;

import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.List;

public Class LCS_generic {
    private LCS_generic(){

    }

    private static final long MEGABYTE = 1024L * 1024L;

    public static long bytesToMegabytes(long bytes) {
        return bytes / MEGABYTE;
    }

    int lcs(char [] X, char [] Y, int m, int n){
        int dp[][] = new int [m+1][n+1];
        for(int i=1;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0||j==0) dp[i][j]=0;
                else if(X[i-1]==Y[j-1]) dp[i][j]=1+dp[i-1][j-1];
                else dp[i][j] = max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[m][n];
    }

    int max(int a, int b){
        return (a > b)? a : b;
    }

    public static void main(String[] args){
        LCS_generic lcs = new LCS_generic();
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";

        char[] X=s1.toCharArray();
        char[] Y=s2.toCharArray();
        int m = X.length;
        int n = Y.length;

        System.out.println("Length of LCS is" + " " + lcs.lcs( X, Y, m, n ) );

        // Get the Java runtime
        Runtime runtime = Runtime.getRuntime();
        // Run the garbage collector
        runtime.gc();
        // Calculate the used memory
        long memory = runtime.totalMemory() - runtime.freeMemory();

        System.out.println("Used memory is bytes: " + memory);
        System.out.println("Used memory is megabytes: " + bytesToMegabytes(memory));
    }
}