
public class SsafyStack<E> implements IStack<E> {
	
	private Node<E> top;
	
	@Override
	public void push(E data) {
		
		// 첫번째 노드로 삽입
		top = new Node<E>(data, top);
	}

	@Override
	public E pop() {
		
		if (isEmpty()) {
			System.out.println("공백스택이어서 작업이 불가능합니다.");
			return null;
		}
		
		// 첫번째 노드 삭제
		Node<E> popNode = top;
		top = popNode.link;
		
		popNode.link = null;
		return popNode.data;
	}

	@Override
	public E peek() {

		if (isEmpty()) {
			System.out.println("공백스택이어서 작업이 불가능합니다.");
			return null;
		}
		
		return top.data;
	}
	
	@Override
	public boolean isEmpty() {
		 return top == null;
	}

	@Override
	public String toString() {
		
		// top부터 마지막 노드까지 쭉 돌며 data를 문자열로 합치기
		StringBuilder sb = new StringBuilder();
		sb.append("Stack [");
		
		for (Node<E> curNode = top; curNode != null; curNode = curNode.link) {
			sb.append(curNode.data).append(", ");
		}
		
		if (!isEmpty()) {
			sb.setLength(sb.length() - 2);
		}
		
		sb.append("]");
		return sb.toString();
	}

	@Override
	public int size() {
		int cnt = 0;
		
		for (Node<E> temp = top; temp != null; temp = temp.link) {
			++cnt;
		}
		
		return cnt;
	}
}
