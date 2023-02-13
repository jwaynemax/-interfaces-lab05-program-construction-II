package edu.westga.cs6312.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.westga.cs6312.climate.interfaces.Sensor;
import edu.westga.cs6312.climate.model.PrecipitationSensor;
import edu.westga.cs6312.climate.model.TemperatureSensor;
import edu.westga.cs6312.climate.model.WeatherStation;
import edu.westga.cs6312.climate.model.WindSensor;

class TestWeatherStation {
	
	private WeatherStation weatherStation;
	
	@BeforeEach
	void setUp() throws Exception {
		
		this.weatherStation = new WeatherStation("Test Station");
	}
	
	@AfterEach
	void tearDown() throws Exception {
		this.weatherStation = null;
	}
		

	@Test
	void testTotalSensorListSize() {
		
		
		assertEquals(9, this.weatherStation.getSensors().size(), "Testing total size of sensors");
		
	}
	
	@Test
	void testTotalWindListSize() {
		
		int count = 0;
		for (Sensor sensor : this.weatherStation.getSensors()) {
			if (sensor.getType().equals("Wind")) {
				count += 1;
			}
		}
		
		assertEquals(3, count, "Testing total size of wind");

	}
	
	@Test
	void testTotalTemperatureListSize() {
		
		int count = 0;
		for (Sensor sensor : this.weatherStation.getSensors()) {
			if (sensor.getType().equals("Temp")) {
				count += 1;
			}
		}

	}
	
	@Test
	void testTotalPrecipitationListSize() {
		
		int count = 0;
		for (Sensor sensor : this.weatherStation.getSensors()) {
			if (sensor.getType().equals("Precip")) {
				count += 1;
			}
		}

	}

}
