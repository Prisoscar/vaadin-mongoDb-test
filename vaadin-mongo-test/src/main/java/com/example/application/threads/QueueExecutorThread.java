package com.example.application.threads;

import java.util.Date;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;

public class QueueExecutorThread {

	public int counter = 0;
	public BlockingQueue<QueueObject> requestQueue = new LinkedBlockingQueue<QueueObject>();

	public QueueExecutorThread() {

		new Thread(theThread).start();
	}

	Runnable theThread = new Runnable() {

		@Override
		public void run() {
			System.out.println("Thread Started");
			try {
				for (;;) {
					var analyzed = requestQueue.take();
					//var analyzed = requestQueue.poll(10,TimeUnit.SECONDS);
					if ( analyzed ==null ) continue;
					System.out.println("task " + analyzed.number + " arrived at " + new Date(analyzed.start) + "\ntook in charge at "
							+ new Date(System.currentTimeMillis()));
					Thread.sleep(6_000);
					var finish = System.currentTimeMillis();
					System.out.println("finishing executing at " + new Date(finish) + "\ntotal elapsed time = "
							+ (finish - analyzed.start));
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		}
	};
}
