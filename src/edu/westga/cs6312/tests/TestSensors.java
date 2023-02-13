package edu.westga.cs6312.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs6312.climate.interfaces.Sensor;
import edu.westga.cs6312.climate.model.PrecipitationSensor;
import edu.westga.cs6312.climate.model.TemperatureSensor;
import edu.westga.cs6312.climate.model.WindSensor;

class TestSensors {

	@Test
	void testWindSensorType() {
		assertThrows(IllegalArgumentException.class, () -> {
			Sensor wind1 = new WindSensor("Wind Sensor 1", "test");
		});
	}
	
	@Test
	void testTemperatureSensorType() {
		assertThrows(IllegalArgumentException.class, () -> {
			Sensor temp1 = new TemperatureSensor("Temp Sensor 1", "test");
		});
	}
	
	@Test
	void testPrecipitationSensorType() {
		assertThrows(IllegalArgumentException.class, () -> {
			Sensor precip1 = new PrecipitationSensor("Precip Sensor 1", "test");
		});
	}
	
	@Test
	void testWindSensorGetName() {
		Sensor wind1 = new WindSensor("Wind Sensor 1", "Wind");
		
		assertEquals("Wind Sensor 1", wind1.getName(), "Testing WindSensor getName()");

	}
	
	@Test
	void testTemperatureSensorGetName() {
		Sensor temp1 = new TemperatureSensor("Temp Sensor 1", "Temp");		
		
		assertEquals("Temp Sensor 1", temp1.getName(), "Testing TemperatureSensor getName()");

	}

	@Test
	void testPrecipitationSensorGetName() {
		Sensor precip1 = new PrecipitationSensor("Precip Sensor 1", "Precip");
		
		assertEquals("Precip Sensor 1", precip1.getName(), "Testing PrecipitationSensor getName()");

	}
	
	@Test
	void testWindSensorGetReading() {
		Sensor wind1 = new WindSensor("Wind Sensor 1", "Wind");
		
		double reading = wind1.getReading();
		
		assertEquals(reading, wind1.getReading(), "Testing WindSensor getReading()");

	}
	
	@Test
	void testTemperatureSensorGetReading() {
		Sensor temp1 = new TemperatureSensor("Temp Sensor 1", "Temp");
		
		double reading = temp1.getReading();
		
		assertEquals(reading, temp1.getReading(), "Testing TemperatureSensor getReading()");

	}
	
	@Test
	void testPrecipitationSensorGetReading() {
		Sensor precip1 = new PrecipitationSensor("Precip Sensor 1", "Precip");
		
		double reading = precip1.getReading();
		
		assertEquals(reading, precip1.getReading(), "Testing PrecipitationSensor getReading()");

	}
	
	@Test
	void testWindSensorGetReadingGreater() {
		Sensor wind1 = new WindSensor("Wind Sensor 1", "Wind");
		
		assertTrue(wind1.getReading() >= 0, "Testing WindSensor getReading() greater than or equal to 0");

	}
	
	@Test
	void testWindSensorGetReadingLess() {
		Sensor wind1 = new WindSensor("Wind Sensor 1", "Wind");
		
		assertTrue(wind1.getReading() <= 199, "Testing WindSensor getReading() less than or equal to 199");

	}
	
	@Test
	void testTemperatureSensorGetReadingGreater() {
		Sensor temp1 = new TemperatureSensor("Temp Sensor 1", "Temp");
		
		assertTrue(temp1.getReading() >= -150, "Testing TemperatureSensor getReading() greater than or equal to 0");

	}
	
	@Test
	void testTemperatureSensorGetReadingLess() {
		Sensor temp1 = new TemperatureSensor("Temp Sensor 1", "Temp");
		
		assertTrue(temp1.getReading() <= 150, "Testing TemperatureSensor getReading() less than or equal to 199");

	}
	
	@Test
	void testPrecipitationSensorGetReadingGreater() {
		Sensor precip1 = new PrecipitationSensor("Precip Sensor 1", "Precip");
		
		assertTrue(precip1.getReading() >= 0, "Testing PrecipitationSensor getReading() greater than or equal to 0");

	}
	
	@Test
	void testPrecipitationSensorGetReadingLess() {
		Sensor precip1 = new PrecipitationSensor("Precip Sensor 1", "Precip");
		
		assertTrue(precip1.getReading() <= 25, "Testing PrecipitationSensor getReading() less than or equal to 199");

	}
}
