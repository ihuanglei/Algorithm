package org.huanglei.sort;

import org.huanglei.sort.annotation.SortAnnotation;

/**
 * @author: huanglei
 * @descript Shell排序(插入排序改进)
 */
@SortAnnotation("ShellSort")
public class ShellSort implements Sort {

	@Override
	public void sort(int[] a) {
		int n = a.length;
		for (int gap = n / 2; gap > 0; gap /= 2) {
			for (int i = gap; i < n; ++i) {
				int temp = a[i];
				int j = i - gap;
				while (j >= 0 && temp < a[j]) {
					a[j + gap] = a[j];
					j -= gap;
				}
				a[j + gap] = temp;

			}
		}
	}

}