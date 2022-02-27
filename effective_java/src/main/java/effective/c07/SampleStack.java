package effective.c07;

public class SampleStack {
	private int size;
	private Object[] repository;
	private static int LIMIT_SIZE = 10;

	public SampleStack() {
		repository = new Object[LIMIT_SIZE];
	}

	public void push(Object val) {
		if(size> LIMIT_SIZE)
			throw new IllegalArgumentException("용량을 초과하였습니다.");
		repository[size++] = val;
	}

	public Object pop() {
		if(size-1<0)
			throw new IllegalArgumentException("비어 있습니다.");
		return repository[--size];
	}

	public Object popV2() {
		if(size-1<0)
			throw new IllegalArgumentException("비어 있습니다.");
		Object result = repository[--size];
		repository[size] = null;
		return result;
	}

	public void print() {
		System.out.println("repository.length : " + repository.length);
		for(int i=0; i<repository.length; i++) {
			System.out.println("["+i+"]"+repository[i]);
		}
	}
}
