/**
 * @author yuanfang
 * @date 2018/7/11 12:49
 * @description 不想当一只菜鸟，虚心学习，期待重生羽毛，展翅高飞
 * ---------------------------------------------------------------------------
 * 问题描述：
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.
 *
 * 给定两个已经排好序的整形数组A和B,合并B到A数组成为一个有序的数组。
 * ---------------------------------------------------------------------------
 * 注意：
 * You may assume that A has enough space to hold additional elements from B.
 * The number of elements initialized in A and B are m and n respectively.
 *
 * A数组有足够的空间存放B数组。m和n表示A和B的初始大小。
 */
public class MergeTowSortArray {
    /**
     * 第一版本思路：1.申请新数组大小为m+n。2.对A,B数组数据比较进行迁移。
     * 迁移思路：每次从A, B数组中拿一个数据，进行对比，如果谁小则放入新数组中。直到A, B迁移完毕。
     * 时间复杂度分析：最好情况：B == null or A == null 直接返回 时间复杂度 O(1)
     *              一般情况下：比较次数 (m+n-1) 次     时间复杂度O(m+n)
     * 空间复杂度分析：O(m+n)
     * @param A
     * @param m
     * @param B
     * @param n
     */
    public void mergeV1(int A[], int m, int B[], int n) {
        if (A == null || B == null || m <= 0 || n <= 0) {
            return ;
        }
        int[] newArr = new int[m + n];

        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            if (A[i] >= B[j]) {
                newArr[k++] = B[j++];
            }else{
                newArr[k++] = A[i++];
            }
        }
        while (i < m) {
            newArr[k++] = A[i++];
        }
        while (j < n) {
            newArr[k++] = B[j++];
        }
        A = newArr;
    }
}
