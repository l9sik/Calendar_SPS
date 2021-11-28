package com.bestgroup.calendar.controllers;

import com.bestgroup.calendar.AppHelper;
import com.bestgroup.calendar.CurrentTime;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.*;
import java.awt.Desktop;
import java.util.ArrayList;

/**
 * Controller for Events.fxml.
 * Contains button to open Excel file and button to filter events
 *
 * @author l9sik
 */


public class EventsController {

    @FXML
    private ComboBox<String> filterChooser;

    @FXML
    private Button mainMenuCancelButton;

    @FXML
    private Button mainMenuCurrentDateButton;

    @FXML
    private Button mainMenuSettingsButton;

    @FXML
    private Button openExcelButton;

    private final NewScene newScene = new NewScene();

    /**
     * Initialize.
     */
    @FXML
    void initialize() {
        filterChooser.getItems().setAll("Нет", "Неделя", "Месяц");

        openExcelButton.setOnAction(actionEvent -> {
            String choice = filterChooser.getValue();
            if (choice == null) choice = "Нет";
            ArrayList<String> list = getList(choice);
            if (!list.isEmpty()) {
                try {
                    setFilter(list);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
                Desktop desktop = Desktop.getDesktop();

                desktop.open(new File("Events.xls"));
            } catch (IOException e) {
                System.out.println("There is something wrong with excel file.");
            }
        });
        mainMenuSettingsButton.setOnAction(actionEvent -> {
            newScene.closeScene(mainMenuSettingsButton);
            newScene.openNewScene("/com/bestgroup/calendar/Settings.fxml");
        });
        mainMenuCancelButton.setOnAction(actionEvent -> {
            newScene.closeScene(mainMenuCancelButton);
            newScene.openNewScene("/com/bestgroup/calendar/MainMenu.fxml");
        });
        mainMenuCurrentDateButton.setOnMouseClicked((event) -> {
            CurrentTime.setYear();
            CurrentTime.setMonthAndDay();
            newScene.closeScene(mainMenuCurrentDateButton);
            newScene.openNewScene("/com/bestgroup/calendar/DayMenu.fxml");
        });
    }

    /**
     * Gets set of week or month from current date
     *
     * @param choice choice from filter-chooser combo-box
     * @return List of week or month dates
     */
    ArrayList<String> getList(String choice){
        String date = AppHelper.getFullDate();
        String newDate;
        ArrayList<String> list = new ArrayList<>();
        if (choice.equals("Неделя")){
            for (int i = 0; i < 7; i++){
                newDate = AppHelper.plusDay(date, i);
                list.add(newDate);
            }
        }
        if (choice.equals("Месяц")){
            for (int i = 0; i < 30; i++){
                newDate = AppHelper.plusDay(date, i);
                list.add(newDate);
            }
        }
        return list;
    }

    /**
     * Method that sets filter to Events.xls file
     * It creates new sheet with filtered data
     * @param list
     * @throws IOException if something goes wrong
     */
    private void setFilter(ArrayList<String> list) throws IOException{
        if (!list.isEmpty()) {
            try (HSSFWorkbook wbFrom = new HSSFWorkbook(new FileInputStream("Events.xls"))) {
                HSSFSheet sheetIn = wbFrom.getSheet("Filtered events");
                //HSSFSheet sheetIn = wbFrom.createSheet("Filtered events");
                HSSFRow topRow = sheetIn.createRow(0);
                HSSFSheet sheetFrom = wbFrom.getSheetAt(0);
                topRow.createCell(0).setCellValue("Date");
                topRow.createCell(1).setCellValue("Theme");
                topRow.createCell(2).setCellValue("Description");
                topRow.createCell(3).setCellValue("Time");
                int lastRowNum = sheetFrom.getLastRowNum() + 1;
                int i = 1;
                while (i < lastRowNum) {
                    HSSFRow rowFrom = sheetFrom.getRow(i);
                    if (list.contains(rowFrom.getCell(0).getStringCellValue())) {
                        HSSFRow rowIn = sheetIn.createRow(i);
                        rowIn.createCell(0).setCellValue(rowFrom.getCell(0).getStringCellValue());
                        rowIn.createCell(1).setCellValue(rowFrom.getCell(1).getStringCellValue());
                        rowIn.createCell(2).setCellValue(rowFrom.getCell(2).getStringCellValue());
                        rowIn.createCell(3).setCellValue(rowFrom.getCell(3).getStringCellValue());
                    }
                    i++;
                }
                OutputStream out = new FileOutputStream("Events.xls");
                wbFrom.write(out);
                out.flush();
                out.close();
            }
        }

    }

}
