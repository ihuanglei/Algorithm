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
		for (int i = 1; i < a.length; ++i) {
			int temp = a[i];
			int j = i - 1;
			while (j >= 0 && temp < a[j]) {
				a[j + 1] = a[j];
				--j;
			}
			a[j + 1] = temp;
		}
	}

}
