package edu.westga.cs6312.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.westga.cs6312.climate.interfaces.Sensor;
import edu.westga.cs6312.climate.model.DailySummary;
import edu.westga.cs6312.climate.model.WeatherStation;

class TestDailySummary {
	private WeatherStation weatherStation;
	private DailySummary dailySummary;

	@BeforeEach
	void setUp() throws Exception {
		this.weatherStation = new WeatherStation("Test Weather Station");
		this.dailySummary = new DailySummary(2, 13, 2023, this.weatherStation.getSensors());
	}

	@AfterEach
	void tearDown() throws Exception {
		this.weatherStation = null;
		this.dailySummary = null;
	}

	@Test
	void testDailySummarySensorSize() {
		assertEquals(9, this.dailySummary.getSensorData().size(), "Testing total size of sensors");
	}
	
	@Test
	void testGetWindData() {
		
		int count = 0;
		for (Sensor sensor : this.dailySummary.getSensorData()) {
			if (sensor.getType().equals("Wind")) {
				count += 1;
			}
		}
		
		assertEquals(3, count, "Testing able to get Wind Sensor Data");

	}
	
	@Test
	void testGetTempData() {
		
		int count = 0;
		for (Sensor sensor : this.dailySummary.getSensorData()) {
			if (sensor.getType().equals("Temp")) {
				count += 1;
			}
		}
		
		assertEquals(3, count, "Testing able to get Temp Sensor Data");

	}
	
	@Test
	void testGetPrecipData() {
		
		int count = 0;
		for (Sensor sensor : this.dailySummary.getSensorData()) {
			if (sensor.getType().equals("Precip")) {
				count += 1;
			}
		}
		
		assertEquals(3, count, "Testing able to get Precip Sensor Data");

	}

}
