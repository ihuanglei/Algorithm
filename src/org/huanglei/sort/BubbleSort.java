package org.huanglei.sort;

import org.huanglei.sort.Sort;
import org.huanglei.sort.annotation.SortAnnotation;

/**
 * @author: huanglei
 * @descript 冒泡排序
 */
@SortAnnotation("BubbleSort")
public class BubbleSort implements Sort {

	@Override
	public void sort(int[] a) {
		int temp = 0;
		for (int i = a.length - 1; i > 0; --i) {
			for (int j = 0; j < i; ++j) {
				temp = a[j];
				if (a[j + 1] < a[j]) {
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
			}
		}
	}
}
