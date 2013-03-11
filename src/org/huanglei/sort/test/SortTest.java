/**
 * 
 */
package org.huanglei.sort.test;

import java.util.Random;

import org.huanglei.sort.BubbleSort;
import org.huanglei.sort.InsertionSort;
import org.huanglei.sort.SelectionSort;
import org.huanglei.sort.ShellSort;
import org.huanglei.sort.Sort;
import org.huanglei.sort.annotation.SortAnnotation;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author huanglei
 * 
 */
public class SortTest {

	private final static int MAX = 100;

	private final int[] arr = { 871, 141, 677, 30, 974, 763, 392, 10, 544, 677,
			329, 926, 413, 341, 110, 950, 964, 679, 954, 934, 674, 602, 115,
			151, 580, 995, 679, 710, 85, 13, 645, 518, 482, 393, 323, 182, 779,
			640, 918, 287, 35, 799, 935, 216, 900, 9, 604, 777, 40, 490, 585,
			502, 406, 717, 288, 797, 83, 384, 699, 841, 856, 376, 852, 456,
			657, 70, 153, 19, 616, 225, 943, 653, 4, 166, 176, 967, 57, 3, 439,
			463, 523, 470, 440, 37, 470, 738, 592, 469, 967, 918, 914, 853,
			505, 499, 364, 624, 54, 579, 274, 813 };

	@Test
	@Ignore
	public void array() {

		Random random = new Random();
		for (int i = 0; i < MAX; ++i) {
			System.out.print(Math.abs(random.nextInt() % (MAX * 10)) + ",");
		}
	}

	@Before
	public void testBefort() {
	}

	@After
	public void testAfter() {
	}

	public void runTest(Sort sort) {
		long start, end;
		start = System.nanoTime();
		sort.sort(arr);
		end = System.nanoTime();
		SortAnnotation name = sort.getClass().getAnnotation(
				SortAnnotation.class);
		System.out.println(name.value() + " run " + (end - start) / 1000
				+ " ms");
		print(arr);
	}

	@Test
	public void testBubbleSort() {
		runTest(new BubbleSort());
	}

	@Test
	public void testInsertionSort() {
		runTest(new InsertionSort());
	}

	@Test
	public void testShellSort() {
		runTest(new ShellSort());
	}

	@Test
	public void testSelectionSort() {
		runTest(new SelectionSort());
	}

	public void print(int a[]) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " , ");
		}
		System.out.println("");
	}

}
