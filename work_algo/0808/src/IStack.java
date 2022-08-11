
// 스택 명세역할의 인터페이스
public interface IStack<T> {

	void push(T data); // 마지막 원소로 추가

	T pop(); // 마지막 원소 삭제 및 리턴

	T peek(); // 마지막 원소 리턴

	boolean isEmpty(); // 공백스택여부 확인
	
	int size(); // 크기

}


