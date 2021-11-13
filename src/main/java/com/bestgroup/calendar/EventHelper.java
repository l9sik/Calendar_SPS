package com.bestgroup.calendar;

import java.io.*;
import java.util.Scanner;

public class EventHelper {
    private String fullDate = AppHelper.getFullDate();
    private String description;
    private String theme;
    private String timeNotification;

    public void setFullDate(String fd){fullDate = fd;}
    public String getFullDate() {return fullDate;}
    public void setTimeNotification (String tm){ timeNotification = tm;}
    public String getTimeNotification (){ return timeNotification; }
    public void setTheme(String th){ theme = th;}
    public String getTheme (){ return theme; }
    public void setDescription (String ds){ description = ds;}
    public String getDescription (){ return description; }

    public Boolean isEventExist() {
        boolean isExist = false;
        File file = new File("Events.txt");
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.equals(fullDate)) {
                isExist = true;
            }
        }
        scanner.close();
        return isExist;
    }

    public void getEvent(){
        File file = new File("Events.txt");
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        while (scanner.hasNextLine()) {
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
