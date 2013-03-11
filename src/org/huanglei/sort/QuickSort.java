package org.huanglei.sort;

import org.huanglei.sort.annotation.SortAnnotation;

/**
 * @author: huanglei
 * @descript 快速排序
 */
@SortAnnotation("QuickSort")
public class QuickSort implements Sort {

	@Override
	public void sort(int[] a) {
		_sort(a, 0, a.length - 1);
	}

	private void _sort(int[] a, int from, int to) {
		if (from < to) {
			int temp = a[to];
			int i = from - 1;
			for (int j = from; j < to; j++) {
				if (a[j] <= temp) {
					i++;
					int tempValue = a[j];
					a[j] = a[i];
					a[i] = tempValue;
				}
			}
			a[to] = a[i + 1];
			a[i + 1] = temp;
			_sort(a, from, i);
			_sort(a, i + 1, to);
		}

	}

	public static void main(String[] args) {
		new QuickSort().sort(new int[] { 5, 6, 2, 4, 1 });
	}

}
