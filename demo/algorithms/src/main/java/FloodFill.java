import java.util.Arrays;

public class FloodFill {
	static public int[][] floodFill(int[][] image, int sr, int sc, int color) {
		if (image[sr][sc] == color) return image;
		dfs(image, sr, sc, image[sr][sc], color);
		return image;
	}

	static void dfs(int[][] image, int sr, int sc, int color, int newColor) {
		if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != color)
			return;
		image[sr][sc] = newColor;
		dfs(image, sr + 1, sc, color, newColor);
		dfs(image, sr - 1, sc, color, newColor);
		dfs(image, sr, sc + 1, color, newColor);
		dfs(image, sr, sc - 1, color, newColor);
	}

	public static void main(String[] args) {
		int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
		int sr = 1, sc = 1 , color = 2;
		System.out.println(Arrays.deepToString(floodFill(image, sr, sc, color)));
	}
}
