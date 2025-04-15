class Solution {
    public int maxArea(int[] height) {
        // height 배열에서 두 선을 고른다음 그 도형의 넓이를 구하면 될듯하다.
        // two pointer
        int extent = 0;
        int left = 0;
        int right = height.length - 1; // right-left가 곧 width

        while (left < right) {
            extent = Math.max(extent, (right - left) * Math.min(height[left], height[right]));

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return extent;
    }
}