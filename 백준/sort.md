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
