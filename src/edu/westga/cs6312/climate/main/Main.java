package edu.westga.cs6312.climate.main;

import edu.westga.cs6312.climate.interfaces.Sensor;
import edu.westga.cs6312.climate.model.DailySummary;
import edu.westga.cs6312.climate.model.WeatherStation;

public class Main {

	public static void main(String[] args) {
		WeatherStation weatherStation = new WeatherStation("Justin's Weather Station");
		
//		DailySummary dailySum1 = new DailySummary(2, 13, 2023);
//		HourlyMeasurement hour1 = new HourlyMeasurement()
		
		System.out.println(weatherStation.getSensors());
		
		for (Sensor sensor: weatherStation.getSensors()) {
			System.out.print(sensor.getName());
		}

	}

}
