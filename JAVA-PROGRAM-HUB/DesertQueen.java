import java.util.*;
public class DesertQueen {
    static class Cell implements Comparable<Cell> {
        int x, y, cost;
        Cell(int x, int y, int cost) {
            this.x = x; this.y = y; this.cost = cost;
        }
        @Override
        public int compareTo(Cell other) {
            return Integer.compare(this.cost, other.cost);
        }
    }
    public static int minimumWater(int n, char[][] grid) {
        int[] dx = {-1, 1, 0, 0}; 
        int[] dy = {0, 0, -1, 1}; 
        int startX = 0, startY = 0, endX = 0, endY = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'S') {
                    startX = i;
                    startY = j;
                } else if (grid[i][j] == 'E') {
                    endX = i;
                    endY = j;
                }
            }
        }
        PriorityQueue<Cell> pq = new PriorityQueue<>();
        pq.add(new Cell(startX, startY, 0));
        boolean[][] visited = new boolean[n][n];
        int[][] waterCost = new int[n][n];
        for (int[] row : waterCost) 
            Arrays.fill(row, Integer.MAX_VALUE);
        waterCost[startX][startY] = 0;
        while (!pq.isEmpty()) {
            Cell current = pq.poll();
            if (visited[current.x][current.y]) 
                continue;
            visited[current.x][current.y] = true;
            if (current.x == endX && current.y == endY) 
                return current.cost;
            for (int i = 0; i < 4; i++) {
                int newX = current.x + dx[i];
                int newY = current.y + dy[i];
                if (newX >= 0 && newX < n && newY >= 0 && newY < n && !visited[newX][newY] && grid[newX][newY] != 'M') {
                    int transitionCost = (grid[newX][newY] == 'T' && grid[current.x][current.y] == 'T') ? 0 : 1;
                    int newCost = current.cost + transitionCost;
                    if (newCost < waterCost[newX][newY]) {
                        waterCost[newX][newY] = newCost;
                        pq.add(new Cell(newX, newY, newCost));
                    }
                }
            }
        }
        return -1; 
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        char[][] grid = new char[n][n];
        for (int i = 0; i < n; i++) {
            grid[i] = sc.nextLine().replaceAll(" ", "").toCharArray();
        }
        System.out.println(minimumWater(n, grid));
        System.out.println();
        sc.close();
    }
}
