import java.util.Arrays;

class IterativeSplit {

  static void merge(int[] arr, int l, int m, int r) {
    int l2 = m + 1;
    if (arr[m] <= arr[l2 > r ? r : l2]) return;

    while (l <= m && l2 <= r) {
      if (arr[l] <= arr[l2]) { l++; }
      else {
        // shift left elements 1 to right
        int shift = arr[l2];
        int idx = l2;
        while (l < idx) {
          arr[idx] = arr[idx - 1];
          idx--;
        }
        arr[l] = shift;
        // step one to the right
        l++; m++; l2++;
      }
    }
  }

	static void sort(int[] arr, int n) {
		for (int len = 1; len <= n; len = 2*len) {
			for (int left = 0; left < n; left += 2*len) {
				int mid = Math.min(left + len - 1, n);
				int right = Math.min(left + 2*len - 1, n);
				merge(arr, left, mid, right);
			}
		}
	}

  public static void main(String[] args) {
    int[] test = {12, 7, 9, -3, 15, 26, 39, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 20, 19, 18, 19, 20, 30, 33, -20, 8};
    sort(test, test.length - 1);
    System.out.println(Arrays.toString(test));
  }
}