/**
 * 
 */
package org.huanglei.sort.test;

import java.util.Random;

import org.huanglei.sort.BubbleSort;
import org.huanglei.sort.InsertionSort;
import org.huanglei.sort.MergeSort;
import org.huanglei.sort.QuickSort;
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

	private final static int MAX = 1000;

	private final int[] arr = { 7427, 7596, 7079, 6783, 553, 3160, 4891, 2123,
			5778, 8413, 314, 3112, 2856, 3460, 2324, 4943, 2129, 3600, 9095,
			793, 4981, 1649, 7991, 3468, 8886, 1269, 1370, 2503, 8003, 1883,
			7030, 4637, 4392, 1256, 5472, 8886, 4803, 8174, 4324, 9461, 7317,
			3098, 9246, 4671, 3172, 35, 1663, 8202, 5715, 9602, 4321, 9532,
			7525, 5986, 2208, 9322, 1196, 1437, 1419, 1120, 3188, 9116, 6390,
			3217, 4604, 5133, 2110, 6441, 9790, 4932, 8814, 6335, 4839, 1425,
			8177, 7261, 4959, 8936, 3440, 4806, 3187, 6455, 6213, 9756, 5186,
			1713, 8574, 3694, 9689, 6642, 2394, 4273, 364, 5837, 3357, 8356,
			8415, 1684, 7415, 7181, 5939, 1921, 4209, 778, 8635, 5451, 1543,
			9772, 8952, 9795, 7585, 4261, 5188, 5922, 8979, 3879, 6038, 7723,
			9944, 1292, 3127, 9109, 6774, 5808, 8758, 3495, 679, 2232, 1248,
			3467, 1241, 4035, 5924, 1282, 512, 9486, 8531, 5276, 5801, 8142,
			7870, 3181, 548, 6075, 1776, 9720, 1728, 7187, 5702, 7173, 9735,
			959, 7660, 7759, 6925, 3975, 2589, 9487, 8623, 7867, 3760, 2407,
			1189, 5469, 4809, 5805, 6952, 3600, 4423, 8691, 8198, 684, 1590,
			4562, 5194, 5873, 8442, 1663, 7845, 4949, 5782, 8714, 3137, 8761,
			5518, 7909, 3442, 8925, 3303, 7240, 8051, 3970, 9335, 8818, 4186,
			372, 1594, 6665, 3216, 5748, 2960, 7914, 2584, 6540, 7932, 1836,
			7827, 9536, 9800, 3452, 7207, 7753, 9597, 693, 9424, 903, 3564,
			4178, 3950, 2310, 464, 1205, 887, 8234, 2573, 2945, 6787, 6366,
			1984, 4322, 8704, 2946, 5056, 4867, 7624, 7759, 3117, 2882, 109,
			6748, 3044, 2585, 8900, 7728, 9516, 912, 2460, 5031, 4473, 9011,
			5495, 522, 1662, 9008, 8852, 5483, 2682, 9899, 458, 7960, 8305,
			5214, 511, 18, 1168, 9405, 4244, 394, 369, 373, 7230, 7164, 9211,
			4455, 1246, 385, 1620, 6738, 4363, 8164, 4945, 6357, 5227, 5415,
			3419, 2800, 3251, 6840, 5141, 2388, 3420, 3428, 5433, 1952, 2551,
			7700, 4406, 3483, 129, 5513, 1100, 7969, 2649, 7288, 1933, 596,
			1616, 3862, 9613, 3687, 5511, 8958, 3828, 8302, 4171, 8683, 237,
			3374, 8444, 4843, 4471, 9597, 4712, 8543, 2967, 1581, 254, 665,
			7468, 4638, 5994, 2988, 2885, 1288, 378, 552, 5574, 9591, 4145,
			2875, 9622, 220, 2168, 1178, 302, 315, 5490, 1540, 8206, 5679,
			2570, 5030, 8247, 7856, 6280, 447, 752, 8077, 2572, 8063, 1127,
			3641, 6725, 181, 4564, 1047, 9314, 8332, 2519, 3945, 1719, 2504,
			176, 413, 1580, 396, 476, 2649, 4759, 3220, 4539, 1582, 3237, 4705,
			8640, 7396, 29, 6545, 5122, 9286, 986, 8071, 9691, 1764, 7509,
			2770, 4369, 908, 8716, 6284, 3859, 6301, 6639, 7499, 8001, 6265,
			693, 3369, 271, 403, 3292, 4997, 9029, 3592, 1728, 1740, 5159,
			3081, 561, 2201, 7031, 3193, 2960, 458, 8873, 607, 4428, 1708,
			9340, 648, 6829, 528, 3457, 7600, 4832, 229, 9587, 6481, 834, 4797,
			2247, 5394, 9634, 3943, 3702, 8556, 8160, 3785, 501, 4160, 9307,
			1456, 2421, 2632, 3830, 4974, 571, 9467, 1159, 5635, 2308, 9962,
			7737, 5488, 8600, 1496, 3566, 5904, 1395, 6228, 4820, 124, 2748,
			6499, 4480, 6961, 7184, 122, 7119, 4095, 5681, 5512, 1016, 2686,
			4066, 8976, 5981, 8653, 5589, 3336, 7405, 1352, 8802, 4445, 9876,
			179, 19, 3502, 9124, 479, 7719, 7283, 5742, 6530, 414, 2883, 8592,
			3741, 1504, 4163, 5116, 2996, 1908, 6858, 2640, 4394, 6714, 7256,
			2064, 8675, 4002, 4957, 510, 1479, 4958, 7990, 9004, 8275, 3481,
			1366, 1721, 1928, 7353, 6606, 9900, 7111, 275, 1626, 9655, 1058,
			4366, 6938, 2648, 8783, 22, 8259, 7493, 2094, 7629, 9737, 4587,
			4648, 2066, 8051, 2831, 9825, 3728, 1304, 7541, 7146, 8031, 2770,
			6971, 5212, 900, 36, 4830, 6873, 7784, 2267, 9139, 7111, 1086,
			5092, 8802, 6159, 9135, 9785, 1842, 1504, 1951, 282, 3607, 4427,
			3779, 9794, 7471, 3634, 4976, 9652, 7143, 9466, 2284, 7039, 3247,
			763, 6902, 6018, 3749, 98, 4296, 8808, 7031, 9542, 389, 5939, 5958,
			9244, 5386, 9927, 6707, 2950, 5912, 4924, 4965, 875, 3836, 4368,
			9440, 6006, 4741, 3962, 3440, 8839, 1574, 6036, 1555, 2684, 7217,
			131, 8396, 7609, 7253, 2357, 4843, 5365, 2259, 8769, 6792, 730,
			4715, 3759, 1186, 1950, 3388, 9678, 9201, 8716, 1561, 8280, 885,
			6894, 4312, 4361, 2784, 9449, 4485, 6947, 8122, 2407, 8204, 8932,
			1256, 9750, 537, 57, 1382, 4589, 7404, 3132, 1445, 9576, 9214,
			8824, 4763, 129, 7588, 8384, 3365, 377, 8822, 3200, 2583, 4776,
			4018, 1742, 2387, 3476, 7039, 3708, 5951, 6271, 4856, 5280, 6135,
			4689, 8123, 435, 551, 3434, 8399, 6548, 4552, 3829, 9962, 2026,
			8799, 592, 8391, 2573, 6984, 7924, 3778, 113, 1746, 7007, 3784,
			4484, 2384, 8213, 5635, 1600, 7736, 1236, 9907, 1112, 5963, 5118,
			2265, 1069, 8482, 6505, 196, 8246, 4729, 8261, 135, 926, 3687,
			9915, 4447, 2686, 9891, 8875, 4587, 4366, 5437, 4613, 645, 1824,
			7072, 8207, 5394, 8401, 8408, 1079, 9343, 1899, 6596, 5345, 1497,
			7391, 3404, 6356, 78, 4894, 9743, 3455, 7981, 1851, 761, 2023,
			3638, 8938, 5549, 9180, 4184, 1931, 5612, 1069, 2656, 2731, 9238,
			3154, 7610, 584, 7479, 6598, 2866, 4766, 1680, 1718, 2674, 5646,
			3424, 152, 3309, 5929, 4343, 5871, 3413, 5175, 5361, 5092, 207,
			5058, 6129, 1607, 5361, 5398, 3692, 4033, 2400, 6476, 3722, 3839,
			4121, 8547, 6082, 1853, 8422, 3131, 5937, 6087, 928, 8760, 7365,
			8507, 307, 8050, 1277, 7613, 9466, 8431, 1617, 6382, 3324, 6253,
			3903, 9163, 8438, 2951, 4704, 9307, 3234, 453, 4140, 3792, 9571,
			3466, 4492, 172, 339, 9893, 8537, 3150, 6342, 4490, 2253, 2587,
			6601, 202, 4386, 8419, 7848, 8651, 6810, 9327, 5571, 3008, 2683,
			2572, 5926, 9588, 5398, 7701, 4754, 561, 2091, 3123, 5263, 8430,
			1102, 2259, 5375, 8755, 8840, 298, 7062, 1328, 7630, 8738, 6225,
			9924, 993, 7593, 8957, 2290, 9414, 383, 4051, 2386, 5956, 11, 1225,
			3512, 9911, 1017, 3748, 9014, 2584, 4482, 217, 4166, 1550, 2390,
			1395, 274, 5086, 9609, 3822, 1412, 5403, 6015, 6746, 221, 1358,
			5479, 4015, 6558, 9095, 9323, 6988, 3372, 9557, 9575, 3920, 5179,
			7787, 2168, 997, 4191, 7155, 9147, 2385, 428, 7390, 3017, 6872,
			4429, 8032, 4851, 8841, 2972, 1931, 6926, 4920, 5552, 5283, 9211,
			7019, 3808, 4728, 3531, 7262, 6874, 2645, 1858, 1989, 5622, 55,
			3322, 7919, 4106, 493, 8227, 5542, 156, 8390, 2291, 5957, 8121,
			6985, 2580, 4705, 8496, 2408, 4700, 901, 6493, 6649, 4629, 459,
			2817, 4073, 4744, 8020, 3545, 2066, 8974, };

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
		SortAnnotation sortAnnotation = sort.getClass().getAnnotation(
				SortAnnotation.class);
		String name;
		if (sortAnnotation == null) {
			name = Sort.class.getName();
		} else {
			name = sortAnnotation.value();
		}
		System.out.println(name + " run " + (end - start) / 1000 + " ms");
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

	@Test
	public void testQuickSort() {
		runTest(new QuickSort());
	}

	@Test
	public void testMergeSort() {
		runTest(new MergeSort());
	}

	public void print(int a[]) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " , ");
		}
		System.out.println("");
	}

}
