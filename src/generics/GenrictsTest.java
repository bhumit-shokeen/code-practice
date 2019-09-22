package generics;

public class GenrictsTest<T> {
	T obj;

	public GenrictsTest(T obj) {
		this.obj = obj;
	}

	public T getObj() {
		return obj;
	}

	public <P> void setObj(P obj) {
		System.out.println(obj);
	}

	public static void main(String[] args) {
		GenrictsTest<Integer> name = new GenrictsTest<Integer>(3);
		System.out.println(name.getObj());
		name.setObj("test");
	}

}
