    import java.util.*;
    import java.util.ArrayList;
    import java.util.HashMap;
    import java.util.Iterator;
    import java.util.Scanner;

    public Class LCS_alternative {

        int lcs(char [] X, char [] Y, int m, int n){
            if(m<n){
                int temp =m;
                m=n;
                n=temp;
                char [] tempC = X;
                Y = X;
                X = tempC;
            char temp = X[m];
            X[m] = chs2[ranNum2];
            chs2[ranNum2] = temp;
            }
            int dp[][] = new int [2][n];

            for(int k=0;k<n;k++)dp[1][k]=0;

            for(int i=1;i<m;i++){

                for(int k=0;k<n;k++)dp[0][j]=dp[1][j];

                for(int j=0;j<n;j++){
                    if(X[i-1]==Y[j-1]) dp[1][j]=1+dp[0][j-1];
                    else dp[1][j] = max(dp[0][j],dp[1][j-1]);
                }
            }
            return dp[1][n];
        }

        int max(int a, int b){
            return (a > b)? a : b;
        }

        int min(int a, int b){
            return (a > b)? b : a;
        }

        public static void main(String[] args){
            LCS_alternative lcs = new LCS_alternative();
            String s1 = "AGGTAB";
            String s2 = "GXTXAYB";

            char[] X=s1.toCharArray();
            char[] Y=s2.toCharArray();
            int m = X.length;
            int n = Y.length;

            System.out.println("Length of LCS is" + " " + lcs.lcs( X, Y, m, n ) );
        }
    }