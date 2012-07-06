/**
 *
 * @author Garis M. Suero
 */
public class NumberPool {

    int[] pool = null;
    
    public synchronized int checkOut() {
        return pull();
    }

    public synchronized void checkIn(int x) {
        push(x);
    }
    
    private int pull() {
        int min = Integer.MAX_VALUE;
        int minIndex = 0;
        for(int a=0; a < pool.length; a++) {
            if (pool[a] < min) {
                min = pool[a];
                minIndex = a;
            }  
        }
        pool = remove(pool, minIndex);
        return min;
    }
    private void push(int num) {
        int[] longer = new int[pool.length + 1];
        System.arraycopy(pool, 0, longer, 0, pool.length);
        longer[pool.length] = num;
        pool = longer;
    }
    public void setPool(int[] pool) {
        this.pool = pool;
    }
    
    
    private int[] remove(int[] vals, int index) {
        int[] copy = new int[vals.length-1];
        System.arraycopy(vals, 0, copy, 0, index);
        System.arraycopy(vals, index+1, copy, index, vals.length-index-1);
        return copy;
    }
}
