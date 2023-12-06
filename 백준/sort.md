# 정렬 알고리즘


## 삽입정렬
```
public class InsertionSort {

    public static int[] arr;

    public static void main(String[] args) {

        arr = new int[]{5, 4, 1, 3, 2};

        insertionSort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + " ");
        }
    }

    private static void insertionSort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {

            // 선택 데이터
            int key = arr[i];

            // 선택된 데이터보다 이전 데이터
            int j = i - 1;
            // 4,5,1,3,2
            while(j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;

        }
    }


}

```

### 병합 정렬

```

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {3, 9, 4, 7, 5, 0, 1, 6, 8, 2};
        printArr(arr);
        mergeSort(arr);
        printArr(arr);
    }

    private static void mergeSort(int[] arr) {
        int[] temp = new int[arr.length];
        mergeSort(arr, temp, 0, arr.length - 1);
    }
    private static void mergeSort(int[] arr, int[] temp, int start, int end) {
        if(start < end) {
            int mid = (start + end) / 2;
            mergeSort(arr, temp, start, mid);
            mergeSort(arr, temp, mid + 1, end);
            merge(arr, temp, start, mid, end);
        }
    }

    private static void merge(int[] arr, int[] temp, int start, int mid, int end) {
        for (int i = start; i <= end; i++) {
            temp[i] = arr[i];
        }

        int part1 = start;
        int part2 = mid + 1;
        int index = start;

        while (part1 <= mid && part2 <= end) {
            if(temp[part1] <= temp[part2]) {
                arr[index] = temp[part1];
                part1++;
            } else {
                arr[index] = temp[part2];
                part2++;
            }
            index++;
        }

        for (int i = 0; i <= mid - part1 ; i++) {
            arr[index + i] = temp[part1 + i];
        }

    }

    private static void printArr(int[] arr) {
        for (int data : arr) {
            System.out.print(data + ", ");
        }

        System.out.println();
    }


}

```
