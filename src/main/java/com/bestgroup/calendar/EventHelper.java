package com.bestgroup.calendar;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Row;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
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

    public boolean isEventExist() {
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
    private void writeIntoExcel(Date eDate, String eTheme, String eDescription, String eTimeNotification){
        try {
            File log = new File("Events.xls");
            FileInputStream file = new FileInputStream(log);
            HSSFWorkbook wb = new HSSFWorkbook(file);
            HSSFSheet sheet = wb.getSheetAt(wb.getActiveSheetIndex());
            Row row = sheet.createRow(sheet.getLastRowNum() + 1);

            Cell date = row.createCell(0);
            DataFormat format = wb.createDataFormat();
            CellStyle dateStyle = wb.createCellStyle();
            dateStyle.setDataFormat(format.getFormat("yyyy-MM-dd"));
            date.setCellStyle(dateStyle);
            date.setCellValue(eDate);
            sheet.autoSizeColumn(0);

            Cell theme = row.createCell(1);
            theme.setCellValue(eTheme);

            Cell description = row.createCell(2);
            description.setCellValue(eDescription);

            Cell time = row.createCell(3);
            time.setCellValue(eTimeNotification);

            FileOutputStream out = new FileOutputStream(log);
            wb.write(out);
            out.close();
            wb.close();
        }catch (IOException e){
            System.out.println("Something wrong with excel file");
        }
    }
}
