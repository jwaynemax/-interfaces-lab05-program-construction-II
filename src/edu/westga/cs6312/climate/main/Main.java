package edu.westga.cs6312.climate.main;

import edu.westga.cs6312.climate.interfaces.Sensor;
import edu.westga.cs6312.climate.model.DailySummary;
import edu.westga.cs6312.climate.model.HourlyMeasurement;
import edu.westga.cs6312.climate.model.WeatherStation;

public class Main {

	public static void main(String[] args) {
		WeatherStation weatherStation = new WeatherStation("Justin's Weather Station");
		
		DailySummary dailySum1 = new DailySummary(2, 13, 2023, weatherStation.getSensors());
		HourlyMeasurement hour = new HourlyMeasurement(3, dailySum1.getSensorData());
		
		System.out.println(hour.getHourOfDay());
		System.out.println(hour.getTempInF());
		System.out.println(hour.getInchesOfPrecipitation());
		System.out.println(hour.getMeasuredWindSpeed());

		
		for (Sensor sensor: dailySum1.getSensorData()) {
			System.out.println("Daily Summary " + sensor.getType() + ": " + sensor.getReading());
		}

	}

}
