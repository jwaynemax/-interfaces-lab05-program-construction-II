package edu.westga.cs6312.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.westga.cs6312.climate.interfaces.Sensor;
import edu.westga.cs6312.climate.model.DailySummary;
import edu.westga.cs6312.climate.model.HourlyMeasurement;
import edu.westga.cs6312.climate.model.WeatherStation;
import edu.westga.cs6312.climate.model.WindSensor;

class TestHourlyMeasurement {
	
	private WeatherStation weatherStation;
	private DailySummary dailySummary;
	private HourlyMeasurement hour;

	@BeforeEach
	void setUp() throws Exception {
		this.weatherStation = new WeatherStation("Test Weather Station");
		this.dailySummary = new DailySummary(2, 13, 2023, this.weatherStation.getSensors());
		this.hour = new HourlyMeasurement(3, this.dailySummary.getSensorData());
	}

	@AfterEach
	void tearDown() throws Exception {
		this.weatherStation = null;
		this.dailySummary = null;
		this.hour = null;
	}

	@Test
	void testHourOfDayBoundry() {
		assertThrows(IllegalArgumentException.class, () -> {
			this.hour = new HourlyMeasurement(-4, this.dailySummary.getSensorData());
		});
	}
	
	@Test
	void testAverageWindSpeed() {
		int avg = 0;
		for (Sensor sensor: this.dailySummary.getSensorData()) {
			if (sensor.getType().equals("Wind")) {
				avg += sensor.getReading();
			}
		}
		avg = avg / 3;
		
		assertEquals(avg, this.hour.getMeasuredWindSpeed(), "Testing getMeasuredWindSpeed()");

	}
	
	@Test
	void testAverageTemp() {
		int avg = 0;
		for (Sensor sensor: this.dailySummary.getSensorData()) {
			if (sensor.getType().equals("Temp")) {
				avg += sensor.getReading();
			}
		}
		avg = avg / 3;
		
		assertEquals(avg, this.hour.getTempInF(), "Testing getTempInF()");

	}
	
	@Test
	void testAveragePrecip() {
		int avg = 0;
		for (Sensor sensor: this.dailySummary.getSensorData()) {
			if (sensor.getType().equals("Precip")) {
				avg += sensor.getReading();
			}
		}
		avg = avg / 3;
		
		assertEquals(avg, this.hour.getInchesOfPrecipitation(), "Testing getInchesOfPrecipitation()");

	}

}
