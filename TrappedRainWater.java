public class TrappedRainWater {
    // Function rainwater calculate karne ke liye hai
    public static int TrappedRainWaters(int height[]) {
        int n = height.length;

        // Left max boundary ka array calculate karo
        int leftMax[] = new int[n];
        leftMax[0] = height[0];
        // Har position ke liye left side se maximum height dhoondo
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        }

        // Right max boundary ka array calculate karo
        int rightMax[] = new int[n];
        rightMax[n - 1] = height[n - 1];
        // Har position ke liye right side se maximum height dhoondo
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
        }

        int trappedWater = 0;
        // Har position par kitna paani trap hoga, usko calculate karo
        for (int i = 0; i < n; i++) {
            // Paani ka level = min(left max boundary, right max boundary)
            int waterLevel = Math.min(leftMax[i], rightMax[i]);
            // Trapped paani = paani ka level - current height
            trappedWater += waterLevel - height[i];
        }

        // Total trapped water wapas karo
        return trappedWater;
    }

    public static void main(String[] args) {
        int height[] = {4, 2, 0, 6, 3, 2, 5};
        // Function ko call karo aur result print karo
        int result = TrappedRainWaters(height);
        System.out.println("Trapped Rainwater: " + result);
    }
}
