package com.bestgroup.calendar;

import java.io.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class EventHelper {
	private String fullDate = AppHelper.getFullDate();
	private String description;
	private String theme;
	private String timeNotification;

	public void setFullDate(String fd) {
		fullDate = fd;
	}

	public String getFullDate() {
		return fullDate;
	}

	public void setTimeNotification(String tm) {
		timeNotification = tm;
	}

	public String getTimeNotification() {
		return timeNotification;
	}

	public void setTheme(String th) {
		theme = th;
	}

	public String getTheme() {
		return theme;
	}

	public void setDescription(String ds) {
		description = ds;
	}

	public String getDescription() {
		return description;
	}

	private static final Logger logger = Logger.getLogger("EventHelper.class");

	public boolean isEventExist() {
		boolean isExist = false;
		File file = new File("Events.txt");
		String errorMessage = "File is not found";
		Scanner scanner = null;
		try {
			scanner = new Scanner(file);
		} catch (FileNotFoundException e) {
			logger.log(Level.INFO, errorMessage);
		}

		while (true) {
			assert scanner != null;
			if (!scanner.hasNextLine()) break;
			String line = scanner.nextLine();
			if (line.equals(fullDate)) {
				isExist = true;
			}
		}
		scanner.close();
		return isExist;
	}

	public void getEvent() {
		File file = new File("Events.txt");
		String errorMessage = "File is not found";
		Scanner scanner = null;
		try {
			scanner = new Scanner(file);
		} catch (FileNotFoundException e) {
			logger.log(Level.INFO, errorMessage);
		}
		while (true) {
			assert scanner != null;
			if (!scanner.hasNextLine()) break;
			String line = scanner.nextLine();
			if (line.equals(fullDate)) {
				setTheme(scanner.nextLine());
				setDescription(scanner.nextLine());
				setTimeNotification(scanner.nextLine());
			}
		}
		scanner.close();
	}
}
