package phonePe;

public class WaterContainer {
    public int maxArea(int[] height) {
        if (height.length == 0 || height == null) return 0;
        if (height.length == 2) {
            if (height[0] < height[1]) return height[0] * 1;
            else return height[1] * 1;
        }
        int i = 0;
        int j = height.length - 1;
        int mid = i + j / 2;
        int width = 0;
        int maxArea=0;
            while (i <= mid && mid <= j) {
                width = j - i;
                if (height[i] <= height[j]) {
                    maxArea = Math.max(calculateArea(height[i], width), maxArea);
                    i++;
                } else {
                    maxArea = Math.max(calculateArea(height[j], width), maxArea);
                    j--;
                }
                if(i>=mid||j<=mid) {
                    mid=(i+j)/2;
                }
            }
        return maxArea;
    }

    public int calculateArea(int x, int y){
        return x*y;
    }

    public static void main(String[] args) {
        int[] arr={1,1000,1000,6,2,5,4,8,3,7};
        System.out.println(new WaterContainer().maxArea(arr));
    }

}
