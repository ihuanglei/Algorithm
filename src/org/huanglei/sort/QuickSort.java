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

		int fromTmp = from, toTmp = to;

		if (from < to) {
			int pivokey = a[from];
			while (from < to) {
				while (from < to && a[to] > pivokey) {
					to--;
				}
				if (from < to)
					a[from++] = a[to];
				while (from < to && a[from] < pivokey) {
					from++;
				}
				if (from < to)
					a[to--] = a[from];
			}
			a[from] = pivokey;
			_sort(a, fromTmp, from - 1);
			_sort(a, from + 1, toTmp);

		}

	}

	public static void main(String[] args) {
		new QuickSort().sort(new int[] { 5, 6, 2, 4, 1 });
	}

}
