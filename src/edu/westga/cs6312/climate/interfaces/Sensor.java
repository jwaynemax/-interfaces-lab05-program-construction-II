package edu.westga.cs6312.climate.interfaces;


/**
 * Interface for sensor
 * 
 * @author justinmaxwell
 * @version 2/10/23
 *
 */
public interface Sensor {
	String getName();
	String getType();
	double getReading();
	void setReading();
}
