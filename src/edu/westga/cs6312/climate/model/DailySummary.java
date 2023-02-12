package edu.westga.cs6312.climate.model;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Summary of weather data for a particular day.
 * 
 * @author justinmaxwell
 * @version 2/10/23
 *
 */
public class DailySummary {
	private int abnormalFreezingPoint = -40;
	
	private LocalDate date;
	private ArrayList<HourlyMeasurement> hourlyMeasurements;
	
	/**
	 * Creates a new DailySummary, with no hourly measurements, for the given month, day, and year. 
	 * 
	 * @precondition month/day/year is a valid date
	 * @postcondition getYear()==year && getDay()==day && getMonth()==month && getNumberOfMeasurements()==0
	 * 
	 * @param month the month for this measurement
	 * @param day the day-of-the-month for this measurement
	 * @param year the year of this measurement
	 */
	public DailySummary(int month, int day, int year) {
		try {
			this.date = LocalDate.of(year, month, day);
		} catch (DateTimeException e) {
			throw new IllegalArgumentException("invalid date");
		}
		
		this.hourlyMeasurements = new ArrayList<HourlyMeasurement>();
	}
	
	/**
	 * Gets the LocalDate object of this summary
	 * @return the LocalDate object
	 */
	public LocalDate getDate() {
		return this.date;
	}
	
	/**
	 * Gets the year associated with this daily summary
	 * 
	 * @return the year
	 */
	public int getYear() {
		return this.date.getYear();
	}
	
	/**
	 * Gets the month (as a number between 1 and 12) associated with this daily summary
	 * 
	 * @return the month
	 */
	public int getMonth() {
		return this.date.getMonthValue();
	}
	
	/**
	 * Gets the day-of-the-month associated with this daily summary
	 * 
	 * @return the day-of-the-month
	 */
	public int getDay() {
		return this.date.getDayOfMonth();
	}
	
	/**
	 * Gets the number of measurements for the day.
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the number of measurements for the day.
	 */
	public int getNumberOfMeasurements() {
		return this.hourlyMeasurements.size();
	}
	
	
	
	/**
	 * Gets the hourly measurements for this DailySummary
	 * 
	 * @return the hourly measurements
	 */
	public ArrayList<HourlyMeasurement> getHourlyMeasurements() {
		return this.hourlyMeasurements;
	}

	/**
	 * Adds an HourlyMeasurement to this summary.
	 * 
	 * @precondition measurement != null && measurement.getHourOfDay() does not match the getHourOfDay() of an already-added measurement
	 * @postcondition getNumberOfMeasurements() = getNumberOfMeasurements()@prev + 1
	 * 
	 * @param measurement the measurement to add
	 */
	public void addHourlyMeasurement(HourlyMeasurement measurement) {
		if (measurement == null) {
			throw new IllegalArgumentException("measurement can not be null");
		}
		
		if (this.hasMeasurementFor(measurement.getHourOfDay())) {
			throw new IllegalArgumentException("can not add a different measurement for the same hour");
		}
		
		this.hourlyMeasurements.add(measurement);
	}
	
	/**
	 * Checks if this DailySummary already has an HourlyMeasurement for the given hour.
	 * 
	 * @precondition hour >=0 && hour <= 23
	 * @postcondition none
	 * 
	 * @param hour the hour of the day, as a number from 0 (midnight) to 23 (11pm)
	 * @return true if an HourlyMeasurement with the given hour-of-day already exists in
	 * 		this DailySummary; false otherwise
	 */
	public boolean hasMeasurementFor(int hour) {
		if (hour < 0 || hour > 23) {
			throw new IllegalArgumentException("hour must be between 0 and 23");
		}
		for (HourlyMeasurement hourlyMeasurement: this.hourlyMeasurements) {
			if (hourlyMeasurement.getHourOfDay() == hour) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Finds the highest recorded temperature for the day.
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the highest recorded temperature for the day, or Integer.MIN_VALUE if no measurements recorded.
	 */
	public int findHiTempInF() {
		int max = Integer.MIN_VALUE;
		for (HourlyMeasurement measurement: this.hourlyMeasurements) {
			int tempF = measurement.getTempInF();
			if (tempF > max) {
				max = tempF;
			}
		}
		return max;
	}
	
	/**
	 * Finds the lowest recorded temperature for the day
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the lowest recorded temperature for the day, or Integer.MAX_VALUE if no measurements recorded
	 */
	public int findLowTempInF() {
		int currentMin = Integer.MAX_VALUE;
	
		for (HourlyMeasurement currentMeasurement : this.hourlyMeasurements) {		
			if (currentMeasurement.getTempInF() < currentMin) {
				currentMin = currentMeasurement.getTempInF();
			}
		}
		return currentMin;
	}
	
	/**
	 * Gets the average of all recorded temperatures for the day.
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the average of all recorded temperatures for the day, or Double.MIN_VALUE if no measurements recorded.
	 */
	public double getAverageTemp() {
		
		if (this.hourlyMeasurements.isEmpty()) {
			return Double.MIN_VALUE;
		}
		
		double sum = 0;
		for (HourlyMeasurement measurement: this.hourlyMeasurements) {
			int tempF = measurement.getTempInF();
			sum += tempF;
		}
		return sum / this.hourlyMeasurements.size();
	}
	
	/**
	 * Checks if the temperature for this day was over some threshold.
	 * 
	 * @precondition temp >= HourlyMeasurement.FAHRENHEIT_MIN && temp <= HourlyMeasurement.FAHRENHEIT_MAX
	 * @postcondition none
	 * 
	 * @param temp the threshold temperature
	 * @return true if this day's high was greater than temp; false otherwise
	 */
	public boolean wasHighTempOver(int temp) {
		if (temp < HourlyMeasurement.FAHRENHEIT_MIN || temp > HourlyMeasurement.FAHRENHEIT_MAX) {
			throw new IllegalArgumentException("temp is out of range to perform a valid check");
		}
		
		if (this.hourlyMeasurements.size() == 0) {
			return false;
		}
		
		int highForDay = HourlyMeasurement.FAHRENHEIT_MIN;
		
		for (HourlyMeasurement currentMeasurement : this.hourlyMeasurements) {
			if (currentMeasurement.getTempInF() > highForDay) {
				highForDay = currentMeasurement.getTempInF();
			}
		}
		
		return highForDay > temp;
	}
	
	/**
	 * Checks if the temperature for the day ever dropped to or below abnormal freezing.
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return true if the temperature for the day dropped to or below the abnormal freezing temperature; false otherwise
	 */
	public boolean hadAbnormalFreezingTemps() {		
		if (this.hourlyMeasurements.size() == 0) {
			return false;
		}
		
		for (HourlyMeasurement currentMeasurement : this.hourlyMeasurements) {
			if (currentMeasurement.getTempInF() <= this.getAbnormalFreezingPoint()) {
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * Gets the HourlyMeasurement for the given hour.
	 * 
	 * @precondition 0 <= hour <= 23
	 * @postcondition none
	 * 
	 * @param hour the hour-of-the-day
	 * @return the HourlyMeasurement with the given hour, or null if none found
	 */
	public HourlyMeasurement getMeasurementAt(int hour) {
		if (hour < 0 || hour > 23) {
			throw new IllegalArgumentException("invalid hour-of-day");
		}
		
		for (HourlyMeasurement measurement: this.hourlyMeasurements) {
			if (measurement.getHourOfDay()  == hour) {
				return measurement;
			}
		}
		return null;
	}
	
	/**
	 * Gets the total precipitation for the day.
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the total precipitation for the day
	 */
	public int getTotalPrecipitation() {
		int currentDailyTotal = 0; 
		
		if (this.hourlyMeasurements.size() == 0) {
			return currentDailyTotal;
		}
		
		for (HourlyMeasurement currentMeasurement : this.hourlyMeasurements) {
			currentDailyTotal += currentMeasurement.getInchesOfPrecipitation();
		}
		
		return currentDailyTotal;
	}

	/**
	 * Getter
	 * @return the abnormalFreezingPoint
	 */
	public int getAbnormalFreezingPoint() {
		return this.abnormalFreezingPoint;
	}

	/**
	 * Setter
	 * @param abnormalFreezingPoint the abnormalFreezingPoint to set
	 */
	public void setAbnormalFreezingPoint(int abnormalFreezingPoint) {
		this.abnormalFreezingPoint = abnormalFreezingPoint;
	}
}