package main.java.hello;

import org.joda.time.LocalDateTime;

public class Mobile {
	private long id;
	private int price;
	private String name;
	private LocalDateTime timeOfDelivery;
	
	public Mobile(long id, int price, String name) {
		super();
		this.id = id;
		this.price = price;
		this.name = name;
	}
	public long getId() {
		return id;
	}
	public LocalDateTime getTimeOfDelivery() {
		return timeOfDelivery;
	}
	public void setTimeOfDelivery(LocalDateTime timeOfDelivery) {
		this.timeOfDelivery = timeOfDelivery;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return String.format("Mobile[id= %d, price = %d, name = %s]", id, price, name);
	}

}
