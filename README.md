# CS260P-Algos
UCI coursework : CS260P Introdcution To Algorithms (M.Goodrich)
Course website : https://www.ics.uci.edu/~goodrich/teach/cs260P/
Homework 1 : https://www.ics.uci.edu/~goodrich/teach/cs260P/hw/hw1.html
Homework 2 : https://www.ics.uci.edu/~goodrich/teach/cs260P/hw/hw2.html
Homework 3 : https://www.ics.uci.edu/~goodrich/teach/cs260P/hw/hw3.html
Homework 4 : https://www.ics.uci.edu/~goodrich/teach/cs260P/hw/hw4.html
Homework 5 : https://www.ics.uci.edu/~goodrich/teach/cs260P/hw/hw5.html
Homework 6 : https://www.ics.uci.edu/~goodrich/teach/cs260P/hw/hw6.html
Midterm I study list : https://www.ics.uci.edu/~goodrich/teach/cs260P/hw/midterm1.html
Midterm II study list : https://www.ics.uci.edu/~goodrich/teach/cs260P/hw/midterm2.html
Final Exam study List : https://www.ics.uci.edu/~goodrich/teach/cs260P/hw/final.html

----------------------------------------------------------------------------------------------------------------------------
                                       CompSci 260P Project #1 — Median Selection
DSelect, the deterministic median selection algorithm discussed in class, finds an approximate median by starting with forming groups of five.

Consider, instead, of versions of this algorithm where the first phase involves forming groups (1) of three, (2) of seven, or (3) of nine.

    Perform a theoretical analysis to determine the best asymptotic characterization of each of these algorithms as a function of the input size, n.

    Follow up on this analysis by implementing
        All four versions of DSelect (forming groups of three, five, seven, and nine)
        and also QuickSelect, the probabilistic linear-time selection algorithm that was discussed in class. 

    Perform an empirical comparative analysis by running these five implementations on a variety of test cases to determine the relative efficiencies of these algorithms in the worst and average cases as a function of n. 

Deliverables (to be submitted via EEE dropbox) include the following:

    A ZIP file that includes the following:
        Source code (C, C++, Java, or Python) of your program that implements and experimentally tests the running times of the five selection algorithms
        The data used for any test cases or experiments 
    A Report (in PDF) that includes the following:
        Theoretical analysis that determines the recurrence relations and asymptotic (big-Oh) complexity of the variants of DSelect (which use groups of three, five, seven, or nine)
        Comparative experimental analysis and conclusions drawn from the experiments. This portion of the report should include pseudo-code summaries of the algorithms, design choices implemented in the source code (such as data structures and representations), and visual plots showing comparitive empirical performance of the different algorithms. 


----------------------------------------------------------------------------------------------------------------------------
                               
                               
                               
                                 CompSci 260P Project #2 — Longest Common Subsequences
LCS, the deterministic dynamic-programming algorithm discussed in class, finds the length of a longest common subsequence of two character strings, X and Y, in O(nm) time, where n is the length of X and m is the length of Y.

In this project, you are to implement the following algorithms:

    The LCS dynamic-programming algorithm discussed in class
    An alternative algorithm for solving the longest-common subsequence problem that is different from the LCS algorithm discussed in class. 

You are then to perform an empirical comparative analysis by running these two algorithms on a variety of test cases to determine the relative efficiencies of these algorithms on average as a function of m and n, and possibly other parameters.

Deliverables (to be submitted via EEE dropbox) include the following:

    A ZIP file that includes the following:
        Source code (C, C++, Java, or Python) of your program that implements and experimentally tests the running times of the two algorithms
        The data used for any test cases or experiments 
    A Report (in PDF) that includes the following:
        A pseudo-code/English description of each of the two algorithms that you implemented and a theoretical analysis of the running times of the two algorithms. This portion of the report should include pseudo-code summaries of the algorithms, as well as reasons why you chose the second algorithm that is different than the LCS algorithm discussed in class.
        A comparative experimental analysis of the two algorithms and conclusions drawn from the experiments. This portion of the report should include visual plots showing comparitive empirical performance of the two algorithms for various types of inputs. 

Some possible sources for reading about alternative algorithms for solving the longest-common-subsequence problem include the following (but you are not limited to choosing to implement one of these algorithms):

    A Linear Space Algorithm for Computing Maximal Common Subsequences, by Daniel Hirschberg.
    Algorithms for the Longest Common Subsequence Problem, by Daniel Hirschberg.
    An O(ND) Difference Algorithm and Its Variations, by Eugene Myers. 


