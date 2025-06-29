import java.util.*;

public class MatrixProcessor {

    public static void rotateAndReplace(char[][] matrix, int row, int col, int size, boolean isOdd) {
        //int n = matrix.length;
        // Go layer by layer
        for (int layer = 0; layer < (size + 1) / 2; layer++) {
            // Calculate positions for current layer
            List<Character> layerElements = new ArrayList<>();
            for (int i = layer; i < size - layer; i++) {
                layerElements.add(matrix[row + layer][col + i]);
            }
            for (int i = layer + 1; i < size - layer; i++) {
                layerElements.add(matrix[row + i][col + size - layer - 1]);
            }
            for (int i = size - layer - 2; i >= layer; i--) {
                layerElements.add(matrix[row + size - layer - 1][col + i]);
            }
            for (int i = size - layer - 2; i > layer; i--) {
                layerElements.add(matrix[row + i][col + layer]);
            }

            int k = layer + 1; // For layer-specific rotation
            int rotation = k % layerElements.size();

            // Optimized rotation and character manipulation
            if (k % 2 == 1) { // Odd layer: rotate left and decrement
                for (int i = 0; i < rotation; i++) {
                    char temp = layerElements.remove(0);
                    layerElements.add(temp);
                }
                for (int i = 0; i < layerElements.size(); i++) {
                    char c = layerElements.get(i);
                    layerElements.set(i, (char) (((c - 'A' - 1 + 26) % 26) + 'A'));
                }
            } else { // Even layer: rotate right and increment
                for (int i = 0; i < rotation; i++) {
                    char temp = layerElements.remove(layerElements.size() - 1);
                    layerElements.add(0, temp);
                }
                for (int i = 0; i < layerElements.size(); i++) {
                    char c = layerElements.get(i);
                    layerElements.set(i, (char) (((c - 'A' + 1) % 26) + 'A'));
                }
            }

            // Write back the modified layer into the matrix
            int index = 0;
            // Top row
            for (int i = layer; i < size - layer; i++) 
                matrix[row + layer][col + i] = layerElements.get(index++);
            // Right column
            for (int i = layer + 1; i < size - layer; i++) 
                matrix[row + i][col + size - layer - 1] = layerElements.get(index++);
            // Bottom row
            for (int i = size - layer - 2; i >= layer; i--) 
                matrix[row + size - layer - 1][col + i] = layerElements.get(index++);
            // Left column
            for (int i = size - layer - 2; i > layer; i--) 
                matrix[row + i][col + layer] = layerElements.get(index++);
        }
    }

    public static String processQueries(int n, char[][] matrix, List<int[]> queries) {
        for (int[] query : queries) {
            int row = query[0];
            int col = query[1];
            int size = query[2];
            rotateAndReplace(matrix, row, col, size, true);
        }
        StringBuilder result = new StringBuilder();
        for (char[] row : matrix) {
            for (char c : row) {
                result.append(c);
            }
        }
        return result.toString();
    }

    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[][] matrix = new char[n][n];
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String[] line = sc.nextLine().split(" ");
            for (int j = 0; j < n; j++) 
                matrix[i][j] = line[j].charAt(0);
        }
        int q = sc.nextInt();
        List<int[]> queries = new ArrayList<>();
        for (int i = 0; i < q; i++) {
            int row = sc.nextInt();
            int col = sc.nextInt();
            int size = sc.nextInt();
            queries.add(new int[]{row, col, size});
        }
        sc.close();
        String result = processQueries(n, matrix, queries);
        System.out.println(result);
        System.out.println();
    }
}