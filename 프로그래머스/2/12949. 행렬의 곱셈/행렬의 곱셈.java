class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
	int[][] matrix = new int[arr1.length][arr2[0].length];
	
	for(int i = 0; i < arr1.length; i++) {
		for(int j = 0; j < arr2[0].length; j++) {
			int temp = 0;
			for(int k = 0; k < arr2.length; k++) {
				temp += arr1[i][k] * arr2[k][j];
			}
			matrix[i][j] = temp; 
		}
	}
	
	return matrix;
}
//     public int[][] solution(int[][] arr1, int[][] arr2) {
//         int[][] answer = new int[arr1.length][arr1[0].length];

//         // 행렬의 곱셈
//         for (int i = 0; i < arr1.length; i++) {
//             for (int j = 0; j < arr1[i].length; j++) {
//                 for (int k = 0; k < arr2[j].length; k++) {
//                     answer[i][j] += arr1[i][k] * arr2[k][j];
//                 }
//             }
//         }

//         return answer;
//     }
}