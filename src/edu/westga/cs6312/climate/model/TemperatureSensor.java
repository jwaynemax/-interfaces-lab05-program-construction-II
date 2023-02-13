/**
 * 
 */
package edu.westga.cs6312.climate.model;

import edu.westga.cs6312.climate.interfaces.Sensor;

/**
 * Define Temp Sensor object -- implements Sensor interface
 * @author justinmaxwell
 * @version 2/10/23
 */
public class TemperatureSensor implements Sensor {
	private String name;
	private String type;
	private double reading;
	
	/**
	 * Construct TemperatureSensor
	 * @precondition type must be Temp
	 * @param name
	 * @param type
	 */
	public TemperatureSensor(String name, String type) {
		
		if (!type.equals("Temp")) {
			throw new IllegalArgumentException("Sensor Type must be set to Temp");
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
	 * return reading in Fahrenheit
	 */
	@Override
	public double getReading() {
		return this.reading;
	}
	
	/**
	 * set reading to a random value between -150 and 100
	 */
	@Override
	public void setReading() {
		this.reading = (Math.random() * (100 - (-150))) + (-150);
	}


}
