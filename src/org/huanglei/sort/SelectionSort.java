package org.huanglei.sort;

import org.huanglei.sort.Sort;
import org.huanglei.sort.annotation.SortAnnotation;

/**
 * @author: huanglei
 * @descript 选择排序
 */
@SortAnnotation("SelectionSort")
public class SelectionSort implements Sort {

	@Override
	public void sort(int[] a) {
		int n = a.length, min = 0, temp = 0;
		for (int i = 0; i < n; ++i) {
			min = i;
			for (int j = i + 1; j < n; ++j) {
				if (a[j] < a[min]) {
					min = j;
				}
			}

			if (min != i) {
				temp = a[min];
				a[min] = a[i];
				a[i] = temp;
			}

		}
	}

}
