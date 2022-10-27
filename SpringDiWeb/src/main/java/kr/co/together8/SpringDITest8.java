package kr.co.together8;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Component;



@Component("engine") class Engine{}										//<bean id="engine" class="kr.co.together6.Engine"/>과 동일
@Component class SuperEngine extends Engine{}
@Component class TurboEngine extends Engine{}
@Component class Door{}


@Component
class Car{
@Value("blue")	String color;
@Value("500")	int oil;
@Autowired	
@Qualifier("turboEngine")
Engine engine;	// byType - 타입으로 먼저 검색, 여러 개면 이름으로 검색 - engine. superEngine, TurboEngine
@Autowired	Door[] doors;
	
	public Car() {}			// 기본 생성자를 꼭 만들어줘야 한다.

	public Car(String color, int oil, Engine engine, Door[] doors) {
		super();
		this.color = color;
		this.oil = oil;
		this.engine = engine;
		this.doors = doors;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void setOil(int oil) {
		this.oil = oil;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	public void setDoors(Door[] doors) {
		this.doors = doors;
	}

	@Override
	public String toString() {
		return "Car [color=" + color + ", oil=" + oil + ", engine=" + engine + ", doors=" + Arrays.toString(doors)
				+ "]";
	}
	
}
public class SpringDITest8 {
	
	
	 public static void main(String[] args) {
		 ApplicationContext ac = new GenericXmlApplicationContext("config7.xml");
		Car car = (Car)ac.getBean("car");							// by Name
		
		Engine engine = (Engine)ac.getBean("turboEngine");

		
		System.out.println(" car = " + car);
		System.out.println(" engine = " + engine);
		
	 }
}