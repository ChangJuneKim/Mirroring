
public class StackTest {


	public static void main(String[] args) {
		
		SsafyStack<String> stack = new SsafyStack<String>();
		System.out.println(stack.isEmpty() + "/" + stack.size());
		
		stack.push("비봉이");
		stack.push("대포");
		stack.push("금동이");
		
		System.out.println("peek item: " + stack.peek());
		System.out.println(stack.isEmpty() + "/" + stack.size());
		System.out.println("pop item: " + stack.pop());
		System.out.println("pop item: " + stack.pop());
		System.out.println(stack.isEmpty() + "/" + stack.size());
		System.out.println("pop item: " + stack.pop());
		System.out.println(stack.isEmpty() + "/" + stack.size());
		stack.pop();		
	}

}
