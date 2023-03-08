package Timer;
import java.lang.Thread;


public class MonTimer extends Thread{
	int time;
	int delay;
	Timer t;
	public MonTimer(int time) {
		this.time = time;
		this.delay = time;
		this.t = new Timer(time);
	}
	
	public void start() {
		t.start();
		try {
			delay();
			run();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void delay() throws InterruptedException {
		for (this.delay = t.getDelay(); this.delay >= 0;this.delay = this.delay - 1000) {
			System.out.println("Delay :" + this.delay);
			Thread.sleep(999);
		}
	}
	
	public int getDelay() {
		return this.delay;
	}
}
