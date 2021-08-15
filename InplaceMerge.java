import java.util.Arrays;

public class InplaceMerge {
  static void merge(int[] arr, int l, int m, int r) {
    int l2 = m + 1;
    if (arr[m] <= arr[l2]) return;

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

  static void sort(int[] arr, int l, int r) {
    if (l >= r)
      return;
    int m = l + (r - l) / 2;

    sort(arr, l, m);
    sort(arr, m + 1, r);
    merge(arr, l, m, r);
  }

  public static void main(String[] args) {
    int[] test = {12, 7, 9, -3, 15, 26, 39, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 20, 19, 18, 19, 20, 30, 33, -20, 8};
    sort(test, 0, test.length - 1);
    System.out.println(Arrays.toString(test));
  }
}