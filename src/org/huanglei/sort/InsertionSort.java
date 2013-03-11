package org.huanglei.sort;

import org.huanglei.sort.Sort;
import org.huanglei.sort.annotation.SortAnnotation;

/**
 * @author: huanglei
 * @descript 插入排序
 */
@SortAnnotation("InsertionSort")
public class InsertionSort implements Sort {

	@Override
	public void sort(int[] a) {
		int temp = 0, j = 0;
		for (int i = 1; i < a.length; ++i) {
			temp = a[i];
			j = i - 1;
			while (j >= 0 && temp < a[j]) {
				a[j + 1] = a[j];
				--j;
			}
			a[j + 1] = temp;
		}
	}

}
