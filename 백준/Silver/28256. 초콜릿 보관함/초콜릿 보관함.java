// BFS를 몰라 검색해서 풀었음
import java.util.*;


public class Main {
    static int[] dx = {-1, 1, 0, 0}; // 상, 하, 좌, 우 이동
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int t = 0; t < T; t++) {
         
            char[][] grid = new char[3][3];
            for (int i = 0; i < 3; i++) {
                String line = sc.next();
                for (int j = 0; j < 3; j++) {
                    grid[i][j] = line.charAt(j);
                }
            }

            
            int n = sc.nextInt();
            int[] display = new int[n];
            for (int i = 0; i < n; i++) {
                display[i] = sc.nextInt();
            }

            // 연결된 초콜릿 칸의 개수 계산
            List<Integer> connectedSizes = findConnectedComponents(grid);
            Collections.sort(connectedSizes);
            // 화면 숫자와 비교
            if (connectedSizes.size() != n) {
                System.out.println(0);
                continue;
            }
            boolean isValid = true;
            for (int i = 0; i < n; i++) {
                if (connectedSizes.get(i) != display[i]) {
                    isValid = false;
                    break;
                }
            }
            System.out.println(isValid ? 1 : 0);
        }
        sc.close();
    }

    // BFS로 연결된 초콜릿 칸 탐색
    static List<Integer> findConnectedComponents(char[][] grid) {
        boolean[][] visited = new boolean[3][3];
        List<Integer> sizes = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[i][j] == 'O' && !visited[i][j]) {
                    int size = bfs(grid, visited, i, j);
                    sizes.add(size);
                }
            }
        }
        return sizes;
    }

    static int bfs(char[][] grid, boolean[][] visited, int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY});
        visited[startX][startY] = true;
        int size = 1;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            // 상하좌우 탐색
            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                // 격자 범위 내이고, 방문하지 않았으며, 초콜릿이 있는 경우
                if (nx >= 0 && nx < 3 && ny >= 0 && ny < 3 && !visited[nx][ny] && grid[nx][ny] == 'O') {
                    queue.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                    size++;
                }
            }
        }
        return size;
    }
}