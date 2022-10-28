package com.gdu.app01.java04;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class SpringMain {

	public static void main(String[] args) {

		AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(SpringBeanConfig.class);
		
		Soldier soldier = ctx.getBean("soldier", Soldier.class);		// xml에서 생성한 Bean을 
		soldier.info();
		ctx.close();
		
	}

}
