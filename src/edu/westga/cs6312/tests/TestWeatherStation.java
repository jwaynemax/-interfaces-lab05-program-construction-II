package edu.westga.cs6312.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.westga.cs6312.climate.interfaces.Sensor;
import edu.westga.cs6312.climate.model.PrecipitationSensor;
import edu.westga.cs6312.climate.model.TemperatureSensor;
import edu.westga.cs6312.climate.model.WindSensor;

class TestWeatherStation {
	
	private ArrayList<Sensor> sensors;
	
	@BeforeEach
	void setUp() throws Exception {
		this.sensors = new ArrayList<>();
		
		Sensor wind1 = new WindSensor("Wind Sensor 1", "Wind");
		Sensor wind2 = new WindSensor("Wind Sensor 2", "Wind");
		Sensor wind3 = new WindSensor("Wind Sensor 3", "Wind");
		
		Sensor temp1 = new TemperatureSensor("Temp Sensor 1", "Temp");
		Sensor temp2 = new TemperatureSensor("Temp Sensor 2", "Temp");
		Sensor temp3 = new TemperatureSensor("Temp Sensor 3", "Temp");
		
		Sensor precip1 = new PrecipitationSensor("Precip Sensor 1", "Precip");
		Sensor precip2 = new PrecipitationSensor("Precip Sensor 2", "Precip");
		Sensor precip3 = new PrecipitationSensor("Precip Sensor 3", "Precip");
		
		this.sensors.add(wind1);
		this.sensors.add(wind2);
		this.sensors.add(wind3);
		
		this.sensors.add(temp1);
		this.sensors.add(temp2);
		this.sensors.add(temp3);
		
		this.sensors.add(precip1);
		this.sensors.add(precip2);
		this.sensors.add(precip3);
	}
	
	@AfterEach
	void tearDown() throws Exception {
		this.sensors = null;
	}
		

	@Test
	void testTotalSensorListSize() {
		
		assertEquals(9, this.sensors.size(), "Testing total size of sensors");

	}
	
	@Test
	void testTotalWindListSize() {
		
		int count = 0;
		for (Sensor sensor : this.sensors) {
			if (sensor.getType() .equals("Wind")) {
				count += 1;
			}
		}
		
		assertEquals(3, count, "Testing total size of wind");

	}
	
	@Test
	void testTotalTemperatureListSize() {
		
		int count = 0;
		for (Sensor sensor : this.sensors) {
			if (sensor.getType().equals("Temp")) {
				count += 1;
			}
		}
		
		assertEquals(3, count, "Testing total size of temperature");

	}
	
	@Test
	void testTotalPrecipitationListSize() {
		
		int count = 0;
		for (Sensor sensor : this.sensors) {
			if (sensor.getType().equals("Precip")) {
				count += 1;
			}
		}
		
		assertEquals(3, count, "Testing total size of precipitation");

	}

}
