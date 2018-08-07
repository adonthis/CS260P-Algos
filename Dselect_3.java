package time_test;

import java.util.*;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.text.DecimalFormat;

import java.util.Collections;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Dselect {
    private Dselect() {

    }

    public static long getCpuTime( ) {
        ThreadMXBean bean = ManagementFactory.getThreadMXBean( );
        return bean.isCurrentThreadCpuTimeSupported( ) ?
            bean.getCurrentThreadCpuTime( ) : 0L;
    }
     
    /** Get user time in nanoseconds. */
    public static long getUserTime( ) {
        ThreadMXBean bean = ManagementFactory.getThreadMXBean( );
        return bean.isCurrentThreadCpuTimeSupported( ) ?
            bean.getCurrentThreadUserTime( ) : 0L;
    }
    /**
     * Returns median of list in linear time.
     *
     * @param grpMod group size in which the list has to be broken up
     * @param list   list to search, which may be reordered on return
     * @param k      kth largest element
     * @return median of array in linear time.
     */
    private static int getMedian(int grpMod, List<Integer> list, int k) {
        int len = list.size();

        if (len < 1) return -1;
        if (len == 1) return 0;

        int pos = select(list, 0, len-1, k, grpMod);

        return (int) list.get(pos);
    }

    /**
     * Returns position of k'th largest element of sub-list.
     *
     * @param list list to search, whose sub-list may be shuffled before
     *             returning
     * @param low   first element of sub-list in list
     * @param high   just after last element of sub-list in list
     * @param k kth largest element
     * @param  grpMod group size in which the list has to be broken up
     * @return position of k'th largest element of (possibly shuffled) sub-list.
     */
    private static int select(List<Integer> list, int low, int high, int k, int grpMod) {
        int len = high - low;
        int g = len / grpMod;//no. of partitions

        // if (lo >= hi || k < 0 || lo + k >= hi)
        //     throw new IllegalArgumentException();
        if (high - low < 10) {
            Collections.sort(list.subList(low, high));
            return low + k;
        }

        for (int i = 0; i < g; i++) {
            int part_low = low + i * grpMod;
            int part_high = ((i + 1) > g) ? high : (part_low + grpMod);
            int pos = select(list,part_low,part_high,grpMod/2,grpMod);
            //Collections.sort(list.subList(part_low, part_high));
            Collections.swap(list, pos, low + i);
        }

        int pos = select(list, low, low + g, g / 2, grpMod);

        int m = trifercate(list, low, high, pos);

        int cmp = low + k - m;

        if (cmp > 0)
            return select(list, m + 1, high, k - (m - low) - 1, grpMod);
        else if (cmp < 0)
            return select(list, low, m, k, grpMod);
        return low + k;
    }

    /**
     * Partition sub-list into 3 parts [<pivot][pivot][>pivot].
     *
     * @param list list to search, which may be reordered on return
     * @param low first element of sub-list in list
     * @param high  just after last element of sub-list in list
     * @param pos  input position of pivot value
     * @return output position of pivot value
     */
    private static int trifercate(List<Integer> list, int low, int high, int pos) {
        int pivotValue = list.get(pos);
        while (low < high) {
            while (list.get(low) < pivotValue) {//.compareTo(pos) < 0) {
                low++;
            }

            while (list.get(high) > pivotValue) {
                high--;
            }//.compareTo(pos) > 0) {// 

            if (list.get(low) == list.get(high)) {//.compareTo(high) == 0) {//list.get(high)) {
                low++;
            } else if (low < high) {
                Collections.swap(list, low, high);
            }
        }
        return high;
    }

    public static void main(String[] Args){
        Random r = new Random(1);
        int n = 400000;
        double sum=0.0;
        for (int trial = 0; trial < 20; trial++) {
            List<Integer> list = new ArrayList<Integer>();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                int v = r.nextInt();
                a[i] = v;
                list.add(v);
            }

            double startcpuTimeNano = getCpuTime( );
            double startUserTimeNano   = getUserTime( );

            int m1 = getMedian(3, list,n/2);
            
            double taskUserTimeNano    = getUserTime( ) - startUserTimeNano;
            double cpuTimeNano  = getCpuTime( ) - startcpuTimeNano;

            sum += taskUserTimeNano;
            Arrays.sort(a);
            int m2 = a[n/2];
            System.out.println(m1==m2);

            System.out.println("User time: "+taskUserTimeNano/1000000000+ " milliseconds");
            System.out.println("CPU Time: "+cpuTimeNano/1000000000+ "  seconds");
        }
        System.out.println("Average User time:"+(sum/20));
    }
}