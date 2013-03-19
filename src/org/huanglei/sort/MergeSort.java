package org.huanglei.sort;

import org.huanglei.sort.annotation.SortAnnotation;

/**
 * @author: huanglei
 * @descript 归并排序
 */
@SortAnnotation("MergeSort")
public class MergeSort implements Sort {

	@Override
	public void sort(int[] a) {
		_sort(a, 0, a.length - 1);
	}

	public void _sort(int[] a, int from, int to) {
		if (from < to) {
			int center = (from + to) / 2;
			_sort(a, from, center);
			_sort(a, center + 1, to);
			merge(a, from, center, to);
		}
	}

	private void merge(int a[], int from, int center, int to) {
		int length = to - from + 1;
		int[] temp = new int[length];
		int i = from, j = center + 1, k = 0;

		while (i <= center && j <= to) {
			if (a[i] < a[j]) {
				temp[k++] = a[i++];
			} else {
				temp[k++] = a[j++];
			}
		}

		while (i <= center) {
			temp[k++] = a[i++];
		}
		while (j <= to) {
			temp[k++] = a[j++];
		}

		k = 0;
		for (int l = from; l <= to; ++l, ++k) {
			a[l] = temp[k];
		}

	}
}
