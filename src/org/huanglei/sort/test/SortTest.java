/**
 * 
 */
package org.huanglei.sort.test;

import org.huanglei.sort.BubbleSort;
import org.huanglei.sort.InsertionSort;
import org.huanglei.sort.SelectionSort;
import org.huanglei.sort.ShellSort;
import org.huanglei.sort.Sort;
import org.huanglei.sort.annotation.SortAnnotation;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author huanglei
 * 
 */
public class SortTest {

	private final int[] arr = { 9, 8, 5, 2, 1, 7, 3, 4, 8888, 43, 23525, 232,
			12, 34, 53, 75, 13, 15, 17 };

	
	public void createRandomArray(){
		
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
