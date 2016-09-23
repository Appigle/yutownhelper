package com.chenley.an.yutownhelper.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.chenley.an.yutownhelper.R;
import com.chenley.an.yutownhelper.base.BaseActionBarActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AlgorithmActivity extends BaseActionBarActivity {

    @Bind(R.id.tv_algorithm_info)
    TextView tvAlgorithm5;
    @Bind(R.id.tv_origin_list)
    TextView tvOriginList;
    @Bind(R.id.tv_algorithm_insertSort)
    TextView tv_algorithm_insertSort;
    @Bind(R.id.tv_algorithm_shellSort)
    TextView tv_algorithm_shellSort;
    @Bind(R.id.tv_algorithm_selectSort)
    TextView tv_algorithm_selectSort;
    @Bind(R.id.tv_algorithm_heapSort)
    TextView tv_algorithm_heapSort;
    @Bind(R.id.tv_algorithm_bubbleSort)
    TextView tv_algorithm_bubbleSort;
    @Bind(R.id.tv_algorithm_quickSort)
    TextView tv_algorithm_quickSort;
    @Bind(R.id.tv_algorithm_mergingSort)
    TextView tv_algorithm_mergingSort;
    @Bind(R.id.tv_algorithm_radixSort)
    TextView tv_algorithm_radixSort;
    @Bind(R.id.tv_algorithm_result)
    TextView tv_algorithm_result;
    /**
     * Log Tag
     */
    private static final String TAG = "AlgorithmActivity@@";
    /**
     * 待排序的数组
     */
    private int[] list = {49, 38, 65, 97, 76, 13, 27, 49
            , 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56
            , 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56
            , 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56
            , 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56
            , 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56
            , 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56
            , 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56
            , 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56
            , 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56
            , 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56
            , 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56
            , 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56
            , 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56
            , 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56
            , 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56
            , 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56
            , 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56
            , 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56
            , 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56
            , 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56
            , 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56
            , 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56
            , 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56
            , 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56
            , 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56
            , 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56
            , 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56
            , 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56
            , 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56
            , 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56
            , 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56
            , 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56
            , 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56
            , 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56
            , 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56
            , 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56
            , 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56
            , 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56
            , 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56
            , 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56
            , 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56
            , 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56
            , 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56
            , 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56
            , 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56
            , 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56
            , 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56
            , 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56
            , 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56
            , 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56
            , 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56
            , 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56
            , 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56
            , 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56
            , 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56
            , 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56
            , 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56
            , 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56
            , 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56
            , 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56
            , 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56
            , 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56
            , 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56
            , 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56
            , 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56
            , 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56
            , 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56
            , 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56
            , 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56
            , 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56
            , 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56
            , 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56
            , 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56
            , 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56
            , 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56
            , 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56
            , 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56
            , 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56
            , 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56
            , 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56
            , 17, 18, 23, 34, 15, 35, 25, 53, 51};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_algorithm);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.tv_algorithm_insertSort
            , R.id.tv_algorithm_shellSort
            , R.id.tv_algorithm_selectSort
            , R.id.tv_algorithm_heapSort
            , R.id.tv_algorithm_bubbleSort
            , R.id.tv_algorithm_quickSort
            , R.id.tv_algorithm_mergingSort
            , R.id.tv_algorithm_radixSort
    })
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_algorithm_insertSort:
                insertSort(list);//插入排序
                break;
            case R.id.tv_algorithm_shellSort:
                shellSort(list);//希尔排序
                break;
            case R.id.tv_algorithm_selectSort:
                selectSort(list);//简单选择排序
                break;
            case R.id.tv_algorithm_heapSort:
                heapSort(list);//堆排序
                break;
            case R.id.tv_algorithm_bubbleSort:
                bubbleSort(list);//冒泡排序
                break;
            case R.id.tv_algorithm_quickSort:
                quickSort(list);//快速排序
                break;
            case R.id.tv_algorithm_mergingSort:
                mergingSort(list);//归并排序
                break;
            case R.id.tv_algorithm_radixSort:
                radixSort();//基数排序
                break;
        }
    }

    /**
     * 基数排序：
     * 基本思想：将所有待比较数值（正整数）统一为同样的数位长度，
     * 数位较短的数前面补零。然后，从最低位开始，依次进行一次排序。
     * 这样从最低位排序一直到最高位排序完成以后,数列就变成一个有序序列。
     */
    private void radixSort() {
        long startTime = 0l;//排序开始时间
        long endTime = 0l;//排序结束时间
        Log.i(TAG, "radixSort: start：" + (startTime = System.currentTimeMillis()));
        _radixSort(list);
        Log.i(TAG, "radixSort: end：" + (endTime = System.currentTimeMillis()));
        Log.i(TAG, "radixSort: 用时：" + (endTime - startTime));
        tv_algorithm_radixSort.setText("基数排序用时：" + (endTime - startTime));
        tv_algorithm_result.setText("基数排序结果 = " + getListString(list) + "\n排序用时：" + (endTime - startTime));
    }

    /**
     * 基数排序
     *
     * @param array
     */
    public void _radixSort(int[] array) {
        //首先确定排序的趟数;
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        int time = 0;
        //判断位数;
        while (max > 0) {
            max /= 10;
            time++;
        }
        //建立10个队列;
        List<ArrayList> queue = new ArrayList<ArrayList>();
        for (int i = 0; i < 10; i++) {
            ArrayList<Integer> queue1 = new ArrayList<Integer>();
            queue.add(queue1);
        }
        //进行time次分配和收集;
        for (int i = 0; i < time; i++) {
            //分配数组元素;
            for (int j = 0; j < array.length; j++) {
                //得到数字的第time+1位数;
                int x = array[j] % (int) Math.pow(10, i + 1) / (int) Math.pow(10, i);
                ArrayList<Integer> queue2 = queue.get(x);
                queue2.add(array[j]);
                queue.set(x, queue2);
            }
            int count = 0;//元素计数器;
            //收集队列元素;
            for (int k = 0; k < 10; k++) {
                while (queue.get(k).size() > 0) {
                    ArrayList<Integer> queue3 = queue.get(k);
                    array[count] = queue3.get(0);
                    queue3.remove(0);
                    count++;
                }
            }
        }
    }

    /**
     * 归并排序
     *
     * @param list
     */
    private void mergingSort(int[] list) {
        long startTime = 0l;//排序开始时间
        long endTime = 0l;//排序结束时间
        Log.i(TAG, "mergingSort: start：" + (startTime = System.currentTimeMillis()));
        sort(list, 0, list.length - 1);
        Log.i(TAG, "mergingSort: end：" + (endTime = System.currentTimeMillis()));
        Log.i(TAG, "mergingSort: 用时：" + (endTime - startTime));
        tv_algorithm_mergingSort.setText("归并排序用时：" + (endTime - startTime));
        tv_algorithm_result.setText("归并排序结果 = " + getListString(list) + "\n排序用时：" + (endTime - startTime));
    }

    /**
     * 归并排序
     *
     * @param data
     * @param left
     * @param right
     */
    public void sort(int[] data, int left, int right) {
        if (left < right) {
            //找出中间索引
            int center = (left + right) / 2;
            //对左边数组进行递归
            sort(data, left, center);
            //对右边数组进行递归
            sort(data, center + 1, right);
            //合并
            merge(data, left, center, right);
        }

    }

    /**
     * 归并排序
     *
     * @param data
     * @param left
     * @param center
     * @param right
     */
    public void merge(int[] data, int left, int center, int right) {
        int[] tmpArr = new int[data.length];
        int mid = center + 1;
        //third记录中间数组的索引
        int third = left;
        int tmp = left;
        while (left <= center && mid <= right) {
            //从两个数组中取出最小的放入中间数组
            if (data[left] <= data[mid]) {
                tmpArr[third++] = data[left++];
            } else {
                tmpArr[third++] = data[mid++];
            }
        }
        //剩余部分依次放入中间数组
        while (mid <= right) {
            tmpArr[third++] = data[mid++];
        }
        while (left <= center) {
            tmpArr[third++] = data[left++];
        }
        //将中间数组中的内容复制回原数组
        while (tmp <= right) {
            data[tmp] = tmpArr[tmp++];
        }
    }

    /**
     * 快速排序
     * 基本思想：选择一个基准元素,通常选择第一个元素或者最后一个元素,通过一趟扫描，
     * 将待排序列分成两部分,一部分比基准元素小,一部分大于等于基准元素,此时基准元
     * 素在其排好序后的正确位置,然后再用同样的方法递归地排序划分的两部分。
     *
     * @param list
     */
    private void quickSort(int[] list) {
        long startTime = 0l;//排序开始时间
        long endTime = 0l;//排序结束时间
        Log.i(TAG, "quickSort: start：" + (startTime = System.currentTimeMillis()));
        if (list.length > 0) {    //查看数组是否为空
            _quickSort(list, 0, list.length - 1);
        }
        Log.i(TAG, "quickSort: end：" + (endTime = System.currentTimeMillis()));
        Log.i(TAG, "quickSort: 用时：" + (endTime - startTime));
        tv_algorithm_quickSort.setText("快速排序用时：" + (endTime - startTime));
        tv_algorithm_result.setText("快速排序结果 = " + getListString(list) + "\n排序用时：" + (endTime - startTime));
    }

    /**
     * 获得中间值
     *
     * @param list
     * @param low
     * @param high
     * @return
     */
    public int getMiddle(int[] list, int low, int high) {
        int tmp = list[low];    //数组的第一个作为中轴
        while (low < high) {
            while (low < high && list[high] >= tmp) {
                high--;
            }
            list[low] = list[high];   //比中轴小的记录移到低端
            while (low < high && list[low] <= tmp) {
                low++;
            }
            list[high] = list[low];   //比中轴大的记录移到高端
        }
        list[low] = tmp;              //中轴记录到尾
        return low;                   //返回中轴的位置
    }

    /**
     * 递归排序
     *
     * @param list
     * @param low
     * @param high
     */
    public void _quickSort(int[] list, int low, int high) {
        if (low < high) {
            int middle = getMiddle(list, low, high);  //将list数组进行一分为二
            _quickSort(list, low, middle - 1);       //对低字表进行递归排序
            _quickSort(list, middle + 1, high);       //对高字表进行递归排序
        }
    }


    /**
     * 冒泡排序
     *
     * @param list
     */
    private void bubbleSort(int[] list) {
        long startTime = 0l;//排序开始时间
        long endTime = 0l;//排序结束时间
        int temp = 0;
        Log.i(TAG, "bubbleSort: start：" + (startTime = System.currentTimeMillis()));
        for (int i = 0; i < list.length - 1; i++) {
            for (int j = 0; j < list.length - 1 - i; j++) {
                if (list[j + 1] < list[j]) {
                    temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                }
            }
        }
        Log.i(TAG, "bubbleSort: end：" + (endTime = System.currentTimeMillis()));
        Log.i(TAG, "bubbleSort: 用时：" + (endTime - startTime));
        tv_algorithm_bubbleSort.setText("冒泡排序用时：" + (endTime - startTime));
        tv_algorithm_result.setText("冒泡排序结果 = " + getListString(list) + "\n排序用时：" + (endTime - startTime));
    }


    /**
     * 堆排序
     * 基本思想：堆排序是一种树形选择排序，是对直接选择排序的有效改进。
     * 堆的定义如下：具有n个元素的序列（h1,h2,...,hn),当且仅当满足（hi>=h2i,hi>=2i+1）
     * 或（hi<=h2i,hi<=2i+1）(i=1,2,...,n/2)时称之为堆。在这里只讨论满足前者条件的堆。
     * 由堆的定义可以看出，堆顶元素（即第一个元素）必为最大项（大顶堆）。完全二叉树可
     * 以很直观地表示堆的结构。堆顶为根，其它为左子树、右子树。初始时把要排序的数的序
     * 列看作是一棵顺序存储的二叉树，调整它们的存储序，使之成为一个堆，这时堆的根节点
     * 的数最大。然后将根节点与堆的最后一个节点交换。然后对前面(n-1)个数重新调整使之
     * 成为堆。依此类推，直到只有两个节点的堆，并对它们作交换，最后得到有n个节点的有序
     * 序列。从算法描述来看，堆排序需要两个过程，一是建立堆，二是堆顶与堆的最后一个元
     * 素交换位置。所以堆排序有两个函数组成。一是建堆的渗透函数，
     * 二是反复调用渗透函数实现排序的函数。
     *
     * @param list
     */
    private void heapSort(int[] list) {
        long startTime = 0l;//排序开始时间
        long endTime = 0l;//排序结束时间
        int arrayLength = list.length;
        Log.i(TAG, "heapSort: start：" + (startTime = System.currentTimeMillis()));
        //循环建堆
        for (int i = 0; i < arrayLength - 1; i++) {
            //建堆
            buildMaxHeap(list, arrayLength - 1 - i);
            //交换堆顶和最后一个元素
            swap(list, 0, arrayLength - 1 - i);
        }
        Log.i(TAG, "heapSort: end：" + (endTime = System.currentTimeMillis()));
        Log.i(TAG, "heapSort: 用时：" + (endTime - startTime));
        tv_algorithm_heapSort.setText("堆排序用时：" + (endTime - startTime));
        tv_algorithm_result.setText("堆排序结果 = " + getListString(list) + "\n排序用时：" + (endTime - startTime));
    }

    /**
     * 值交换
     *
     * @param data
     * @param i
     * @param j
     */
    private void swap(int[] data, int i, int j) {
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }

    /**
     * 对data数组从0到lastIndex建大顶堆
     *
     * @param data
     * @param lastIndex
     */
    private void buildMaxHeap(int[] data, int lastIndex) {
        //从lastIndex处节点（最后一个节点）的父节点开始
        for (int i = (lastIndex - 1) / 2; i >= 0; i--) {
            //k保存正在判断的节点
            int k = i;
            //如果当前k节点的子节点存在
            while (k * 2 + 1 <= lastIndex) {
                //k节点的左子节点的索引
                int biggerIndex = 2 * k + 1;
                //如果biggerIndex小于lastIndex，即biggerIndex+1代表的k节点的右子节点存在
                if (biggerIndex < lastIndex) {
                    //若果右子节点的值较大
                    if (data[biggerIndex] < data[biggerIndex + 1]) {
                        //biggerIndex总是记录较大子节点的索引
                        biggerIndex++;
                    }
                }
                //如果k节点的值小于其较大的子节点的值
                if (data[k] < data[biggerIndex]) {
                    //交换他们
                    swap(data, k, biggerIndex);
                    //将biggerIndex赋予k，开始while循环的下一次循环，重新保证k节点的值大于其左右子节点的值
                    k = biggerIndex;
                } else {
                    break;
                }
            }
        }
    }

    /**
     * 简单选择排序
     * 基本思想：在要排序的一组数中，选出最小的一个数与第一个位置的数交换；
     * 然后在剩下的数当中再找最小的与第二个位置的数交换，如此循环到倒数第二个数和最后一个数比较为止。
     *
     * @param list
     */
    private void selectSort(int[] list) {
        long startTime = 0l;//排序开始时间
        long endTime = 0l;//排序结束时间
        int positon = 0;
        Log.i(TAG, "selectSort: start：" + (startTime = System.currentTimeMillis()));
        for (int i = 0; i < list.length; i++) {
            int j = i + 1;
            positon = i;
            int temp = list[i];
            for (; j < list.length; j++) {
                if (list[j] < temp) {
                    temp = list[j];
                    positon = j;
                }
                list[positon] = list[i];
                list[i] = temp;
            }
        }
        Log.i(TAG, "selectSort: end：" + (endTime = System.currentTimeMillis()));
        Log.i(TAG, "selectSort: 用时：" + (endTime - startTime));
        tv_algorithm_selectSort.setText("简单选择排序用时：" + (endTime - startTime));
        tv_algorithm_result.setText("简单选择排序 = " + getListString(list) + "\n排序用时：" + (endTime - startTime));
    }

    /**
     * 希尔排序
     * 基本思想：算法先将要排序的一组数按某个增量d（n/2,n为要排序数的个数）分成若干组，
     * 每组中记录的下标相差d.对每组中全部元素进行直接插入排序，
     * 然后再用一个较小的增量（d/2）对它进行分组，
     * 在每组中再进行直接插入排序。当增量减到1时，进行直接插入排序后，排序完成。
     *
     * @param list
     */
    private void shellSort(int[] list) {
        Toast.makeText(this, "希尔排序！", Toast.LENGTH_SHORT).show();
        long startTime = 0l;//排序开始时间
        long endTime = 0l;//排序结束时间
        //获得排序数组长度
        double d1 = list.length;
        //定义临时变量temp
        int temp = 0;
        Log.i(TAG, "shellSort: start：" + (startTime = System.currentTimeMillis()));
        //循环对比
        while (true) {
            //取+无限整数，每次取1/2数值
            d1 = Math.ceil(d1 / 2);
            //强制转换获得数组长度的一半（或者+1值）
            int d = (int) d1;
            //循环d次数，直接插入排序
            for (int x = 0; x < d; x++) {
                Log.i(TAG, "shellSort: x=" + x + "--d=" + d);
                for (int i = x + d; i < list.length; i += d) {
                    int j = i - d;
                    Log.i(TAG, "shellSort: i=" + i + "--d=" + d + "--j=i-d=" + j + "--list[i]=" + list[i]);
                    temp = list[i];
                    for (; j >= 0 && temp < list[j]; j -= d) {
                        Log.i(TAG, "shellSort: j=" + j + "--list[j]=" + list[j]);
                        list[j + d] = list[j];
                    }
                    list[j + d] = temp;
                }
            }
            if (d == 1) {
                break;
            }
        }
        Log.i(TAG, "shellSort: end：" + (endTime = System.currentTimeMillis()));
        Log.i(TAG, "shellSort: 用时：" + (endTime - startTime));
        tv_algorithm_shellSort.setText("希尔排序用时：" + (endTime - startTime));
        tv_algorithm_result.setText("希尔排序：= " + getListString(list) + "\n排序用时：" + (endTime - startTime));
    }

    /**
     * 插入排序
     * 基本思想：在要排序的一组数中，假设前面(n-1)[n>=2] 个数已经是排
     * 好顺序的，现在要把第n个数插到前面的有序数中，使得这n个数
     * 也是排好顺序的。如此反复循环，直到全部排好顺序。
     */
    private void insertSort(int[] list) {
        Toast.makeText(this, "插入排序！", Toast.LENGTH_SHORT).show();
        long startTime = 0l;//排序开始时间
        long endTime = 0l;//排序结束时间
        int temp = 0;
        Log.i(TAG, "insertSort: start：" + (startTime = System.currentTimeMillis()));
        for (int i = 1; i < list.length; i++) {
            //获得前一位数值下标
            int j = i - 1;
            //将当前位位做临时变量保存
            temp = list[i];
            //将后一位数值与前面所有的数值对比，如果满足临时变量temp大于当前数值时
            for (; j >= 0 && temp < list[j]; j--) {
                //将大于temp的值整体后移一位
                list[j + 1] = list[j];
            }
            //将临时变量赋值给当前位j+1=i下标的数值
            list[j + 1] = temp;
        }
        Log.i(TAG, "insertSort: end：" + (endTime = System.currentTimeMillis()));
        Log.i(TAG, "insertSort: 用时：" + (endTime - startTime));
        tv_algorithm_insertSort.setText("插入排序用时：" + (endTime - startTime));
        tv_algorithm_result.setText("插入排序（直接插入排序）：= " + getListString(list) + "\n排序用时：" + (endTime - startTime));
    }

    /**
     * 将数组转成String
     *
     * @param list
     * @return
     */
    @NonNull
    private String getListString(int[] list) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < list.length; i++) {
            sb.append(list[i]);
            sb.append("<");
        }
        return sb.toString();
    }
}
