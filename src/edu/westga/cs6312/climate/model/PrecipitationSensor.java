/**
 * 
 */
package edu.westga.cs6312.climate.model;

import edu.westga.cs6312.climate.interfaces.Sensor;

/**
 * Define Precipitation Sensor object -- implements Sensor interface
 * @author justinmaxwell
 * @version 2/10/23
 */
public class PrecipitationSensor implements Sensor {
	private String name;
	private String type;
	private double reading;

	/**
	 * Construct WindSensor
	 * @precondition type must be Wind
	 * @param name
	 * @param type
	 */
	public PrecipitationSensor(String name, String type) {
		
		if (!type.equals("Precip”")) {
			throw new IllegalArgumentException("Sensor Type must be set to Precip”");
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
	 * return reading in inches
	 */
	@Override
	public double getReading() {
		return this.reading;
	}
	
	/**
	 * set reading to a random value between 0 and 25 (max precipitation in antarctica)
	 */
	@Override
	public void setReading() {
		this.reading = (Math.random() * (25 - 0)) + 0;
	}

}

