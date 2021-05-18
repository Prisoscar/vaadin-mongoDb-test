package com.example.application.threads;

import org.springframework.beans.factory.annotation.Autowired;

public class QueueObject {
	
	public long start;
	int number;
	public QueueObject(int number) {
		start = System.currentTimeMillis();
		this.number = number;
	}
}
