package Timer;

public class Main {
	public static void main(String[] srgs) throws InterruptedException {
		MonTimer t = new MonTimer(10000);
		t.start();
		int i = t.delay;
		System.out.println(i);
	}
}
