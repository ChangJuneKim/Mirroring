import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*10
1 4
1 6
6 10
5 7
3 8
5 9
3 5
8 11
2 13
12 14*/
public class MeetingRoomTest {

	private static class Meeting implements Comparable<Meeting> {
		
		int start, end;  // 회의 시작, 종료 시간

		public Meeting(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Meeting o) {
			// 종료시간 기준 오름차순, 종료시간이 같다면 시작시간 기준 오름차순
			return this.end != o.end ? this.end - o.end : this.start - o.start;
		}
		
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();  // 총 회의 개수
		
		Meeting meetings[] = new Meeting[N];
		for (int i = 0; i < N; i++) {
			meetings[i] = new Meeting(sc.nextInt(), sc.nextInt());
		}

		List<Meeting> result = getSchedule(meetings);
		
		StringBuilder sb = new StringBuilder();
		sb.append(result.size()).append("\n");
		
		for (Meeting meeting : result) {
			sb.append(meeting.start).append(" ").append(meeting.end).append("\n");
		}

		System.out.println(sb);
	}

	private static List<Meeting> getSchedule(Meeting[] meetings) {
		
		List<Meeting> result = new ArrayList<Meeting>();
		
		// 모든 회의를 종료시간 기준 오름차순, 종료시간이 같다면 시작시간 기준 오름차순
		Arrays.sort(meetings);
		result.add(meetings[0]);  // 첫 회의 스케쥴에 추가
		
		for (int i = 1; i < meetings.length; i++) {
			// 확정된 앞 회의의 종료시간이 다음 회의시작보다 같거나 크다면 회의 확정
			if (result.get(result.size() - 1).end <= meetings[i].start) {
				result.add(meetings[i]);
			}
		}
		
		return result;
	}
}
