package com.example;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;

public class RocketMQIndicator implements HealthIndicator {

	@Override
	public Health health() {
		
		int errorCode = check();
		if(0 != errorCode){
			return Health.down().withDetail("Error Code", errorCode).build();
		}
		
		return Health.up().build();
	}
	
	private int check(){
		//TODO 逻辑监测判断
		return 0;
	}
	
}
