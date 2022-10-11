import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.StringTokenizer;

public class Main {
    
    int N, D, K, C;
    int[] arr, visited;
    
    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
    
    public void solution() throws IOException {
        System.setIn(Files.newInputStream(Paths.get("input.txt")));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        arr = new int[N];
        
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        visited = new int[D + 1];
        
        System.out.println(slide());
    }
    
    private int slide() {
        // inSlide는 k 크기의 슬라이드 내에서 먹은 중복없는 스시 개수, chance는 찬스까지 고려해 먹을 수 있는 개수
        int inSlide = 0, chance;
        // 일단 처음 k개의 슬라이드에 담기
        for (int i = 0; i < K; i++) {
            if (visited[arr[i]] == 0) {
                inSlide++;
            }
            visited[arr[i]]++;
        }
        chance = inSlide;
        for (int i = 1; i < N; i++) {
            // 슬라이드에 찬스 번호가 들어있지 않으면 1개 더 먹을 수 있다
            if (chance <= inSlide) {
                if (visited[C] == 0) {
                    chance = inSlide + 1;
                } else {
                    chance = inSlide;
                }
            }
            // 슬라이드 이동 시, 앞쪽 스시는 못먹게 되고, 한번도 먹은적이 없다면 슬라이드 내에서 먹은 스시 개수 -1
            visited[arr[i - 1]]--;
            if (visited[arr[i - 1]] == 0) {
                inSlide--;
            }
            // 슬라이드 이동 시, 뒤쪽 스시 먹게 되고, 한번도 먹은적 없다면 슬라이드 내에서 먹은 스시 개수 +1
            // 회전초밥은 회전하므로 % n 을 사용해야한다
            if (visited[arr[(i + K - 1) % N]] == 0) {
                inSlide++;
            }
            visited[arr[(i + K - 1) % N]]++;
        }
        return chance;
    }
}
