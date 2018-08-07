package time_test;

import java.util.*;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.text.DecimalFormat;

import java.util.Collections;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class QuickSelect {
	
	/** Get CPU time in nanoseconds. */
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

	private static int select(List<Integer> list, int k){
		    
			int len= list.size();
			if(len ==0)return -1;
			int low=0;
			int high =len-1;
			int pivot = list.get(low+(k*5151)%len);

			List<Integer> left = new ArrayList<Integer>();
			List<Integer> right = new ArrayList<Integer>();
			
			for(int i=0;i<len;i++){
				int cmp = list.get(i);
				if(cmp<pivot){
					left.add(cmp);
				}else{
					right.add(cmp);
				}
			}
			if(k < left.size()){
				return select(left,k);
			}else if(k==left.size()){
				return pivot;
			}
			System.out.println("k :"+k+" right size :"+right.size());
			return select(right,k-left.size());
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

            int m1 = select(list,n/2);

            double taskUserTimeNano    = getUserTime( ) - startUserTimeNano;
		 	double cpuTimeNano  = getCpuTime( ) - startcpuTimeNano;
	    sum += taskUserTimeNano;
	    Arrays.sort(a);
            int m2 = a[n/2];
            
            System.out.println(m1);
            System.out.println(m2);
            n +=n;
            
            System.out.println("User time: "+taskUserTimeNano/1000000+ " milliseconds");
		 	System.out.println("CPU Time: "+cpuTimeNano/1000000000+ "  seconds");
         }
System.out.println("User time: "+(sum/20));
    }
}