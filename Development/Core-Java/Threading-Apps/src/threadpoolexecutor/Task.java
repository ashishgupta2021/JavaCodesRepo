package threadpoolexecutor;

public class Task implements Runnable {
	private String name = null;

	public Task(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Executing : " + name);
	}
}
