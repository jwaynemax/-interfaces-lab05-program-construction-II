/**
 * 
 */
package edu.westga.cs6312.climate.model;

import edu.westga.cs6312.climate.interfaces.Sensor;

/**
 * Define Wind Sensor object -- implements Sensor interface
 * @author justinmaxwell
 * @version 2/10/23
 */
public class WindSensor implements Sensor {
	private String name;
	private String type;
	private double reading;
	
	
	/**
	 * Construct WindSensor
	 * @precondition type must be Wind
	 * @param name
	 * @param type
	 */
	public WindSensor(String name, String type) {
		
		if (!type.equals("Wind")) {
			throw new IllegalArgumentException("Sensor Type must be set to Wind");
		}
		
		this.name = name;
		this.type = type;
		this.setReading();
		this.reading = this.getReading();
	}

	/**
	 * return name
	 */
	@Override
	public String getName() {
		return this.name;
	}
	
	/**
	 * return type
	 */
	@Override
	public String getType() {
		return this.type;
	}

	/**
	 * return reading in miles per hour
	 */
	@Override
	public double getReading() {
		return this.reading;
	}
	
	/**
	 * set reading to a random value between 0 and 231 (max wind speed recorded)
	 */
	@Override
	public void setReading() {
		this.reading = (Math.random() * (231 - 0)) + 0;
	}

}
