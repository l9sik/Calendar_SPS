package com.bestgroup.calendar.controllers;

import java.io.*;
import java.time.LocalDate;

import com.bestgroup.calendar.EventHelper;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;


public class FilledEventController {

	@FXML
	private Button cancelButton;

	@FXML
	private Button deleteEventButton;

	@FXML
	private Button settingsButton;

	@FXML
	private DatePicker textData;

	@FXML
	private TextField textDescription;

	@FXML
	private TextField textTheme;

	@FXML
	private TextField textTimeNotification;

	@FXML
	void initialize() {
		NewScene nw = new NewScene();
		filedFields();
		cancelButton.setOnAction(actionEvent -> {
			nw.closeScene(cancelButton);
			nw.openNewScene("/com/bestgroup/calendar/MainMenu.fxml");
		});
		settingsButton.setOnAction(actionEvent -> {
			nw.closeScene(settingsButton);
			nw.openNewScene("/com/bestgroup/calendar/Settings.fxml");
		});
		deleteEventButton.setOnAction(actionEvent -> {
			nw.closeScene(deleteEventButton);
			try {
				if (deleteEvent())
					nw.openNewScene("/com/bestgroup/calendar/SuccessDelete.fxml");
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		});
	}

	public void filedFields() {
		EventHelper ev = new EventHelper();
		ev.getEvent();
		textData.setValue(LocalDate.parse(ev.getFullDate()));
		textDescription.setText(ev.getDescription());
		textTheme.setText(ev.getTheme());
		textTimeNotification.setText(ev.getTimeNotification());
	}

	public boolean deleteEvent() throws IOException {
		String line;
		boolean isDeleted = false;
		String outputLine = String.valueOf(textData.getValue());
		File sourceFile = new File("Events.txt");
		File outputFile = new File("Dictio2.txt");
		try (BufferedReader reader = new BufferedReader(new FileReader(sourceFile))) {
			try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
				while ((line = reader.readLine()) != null) {
					if (!line.equals(outputLine)) {
						writer.write(line);
						writer.newLine();
					} else {
						reader.readLine();
						reader.readLine();
						reader.readLine();
					}
				}
			}
		}
		try (HSSFWorkbook wb = new HSSFWorkbook(new FileInputStream("Events.xls"))){
			HSSFSheet sheet = wb.getSheetAt(wb.getActiveSheetIndex());
			int lastRowNum = sheet.getLastRowNum() + 1;

			int i = 1;
			boolean isNotFound = true;
			int index = -1;
			while (i < lastRowNum && isNotFound) {
				HSSFRow row = sheet.getRow(i);
				line = row.getCell(0).getStringCellValue();
				if (line.equals(outputLine)){
					index = i;
					isNotFound = false;
				}
				i++;
			}

			if (index > 0){
				removeRow(sheet, index);
				isDeleted = true;
			}else System.out.println("There is no such event in excel file.");
			OutputStream out = new FileOutputStream("Events.xls");
			wb.write(out);
			out.flush();
			out.close();

		}
		sourceFile.delete();
		outputFile.renameTo(sourceFile);
		return isDeleted;
	}

	public static void removeRow(HSSFSheet sheet, int rowIndex) {
		int lastRowNum = sheet.getLastRowNum();
		if (rowIndex >= 0 && rowIndex < lastRowNum) {
			sheet.shiftRows(rowIndex + 1, lastRowNum, -1);
		}
		if (rowIndex == lastRowNum) {
			HSSFRow removingRow = sheet.getRow(rowIndex);
			if (removingRow != null) {
				sheet.removeRow(removingRow);
			}
		}
	}

}
