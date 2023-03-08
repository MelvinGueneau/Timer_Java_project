package Timer;

import java.util.*;
import java.lang.Thread;
import java.io.*;


public class Timer extends Thread{
	private int seconde;
	private int minute;
	private int heure;
	private int delay;
	
	public Timer(int delay) {
		this.delay = delay;
		this.seconde = 0;
		this.minute = 0;
		this.heure = 0;
	}
	
	public int getDelay() {
		return delay;
	}

	public void setTimer(int delay) {
		this.seconde = 0;
		this.minute = 0;
		this.heure = 0;
		
		for (int i = delay/1000; i != 0; i--) {
			seconde++;
			if (seconde == 60) {
				minute++;
				seconde = 0;
			}
			if (minute == 60) {
				heure++;
				minute = 0;
			}
		}
	}
	
	public void decompte() throws InterruptedException {
		setTimer(this.delay);
		int delay = this.delay;
		afficher_timer();
		while (delay != 0) {
			Thread.sleep(1000);
			delay = delay - 1000;
			setTimer(delay);
			afficher_timer();
		}
	}
	
	public void afficher_timer() {
		System.out.println("Timer : " + heure + ":" + minute + ":" + seconde);
	}
	
	static public void main(String[] srg) throws InterruptedException {
		Timer t = new Timer(10000);
		t.decompte();
	}
	
	@Override
	public void run() {
		try {
			decompte();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}
