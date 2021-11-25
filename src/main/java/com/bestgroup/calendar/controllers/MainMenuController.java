package com.bestgroup.calendar.controllers;

import com.bestgroup.calendar.AppHelper;
import com.bestgroup.calendar.CurrentTime;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.util.Duration;
import javafx.scene.control.ComboBox;

/**
 * Controller for MainMenu.fxml
 * @author eviv2206
 * @author l9sik
 */
public class MainMenuController {

	@FXML
	private Button events;

	@FXML
	private ComboBox<String> chooseYear;

	@FXML
	private Button mainMenuAddEventButton;

	@FXML
	private Button mainMenuAprButton;

	@FXML
	private Button mainMenuAugButton;

	@FXML
	private Button mainMenuCurrentDateButton;

	@FXML
	private Button mainMenuDecButton;

	@FXML
	private Button mainMenuFebButton;

	@FXML
	private Button mainMenuJanButton;

	@FXML
	private Button mainMenuJulyButton;

	@FXML
	private Button mainMenuJuneButton;

	@FXML
	private Button mainMenuMarchButton;

	@FXML
	private Button mainMenuMayButton;

	@FXML
	private Button mainMenuNovButton;

	@FXML
	private Button mainMenuOctButton;

	@FXML
	private Button mainMenuSeptButton;

	@FXML
	private Button mainMenuSettingsButton;

	@FXML
	private Text time;

	private final NewScene nw = new NewScene();

	@FXML
	void initialize() {

		Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> time.setText(CurrentTime.getCurrentTime("UTC+3"))),
				new KeyFrame(Duration.seconds(1))
		);
		clock.setCycleCount(Animation.INDEFINITE);
		clock.play();


		mainMenuCurrentDateButton.setOnMouseClicked(event -> {
			CurrentTime.setYear();
			CurrentTime.setMonthAndDay();
			nw.closeScene(mainMenuCurrentDateButton);
			nw.openNewScene("/com/bestgroup/calendar/DayMenu.fxml");
		});

		mainMenuSettingsButton.setOnMouseClicked(event -> {
			nw.closeScene(mainMenuSettingsButton);
			nw.openNewScene("/com/bestgroup/calendar/Settings.fxml");
		});

		mainMenuAddEventButton.setOnMouseClicked(event -> {
			CurrentTime.resetDate();
			nw.closeScene(mainMenuAddEventButton);
			nw.openNewScene("/com/bestgroup/calendar/AddEvent.fxml");
		});

		chooseYear.getItems().setAll("2014", "2015", "2016", "2017", "2018",
				"2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026",
				"2027", "2028");

		mainMenuJanButton.setOnAction(actionEvent -> openMonthMenu(mainMenuJanButton, 1));
		mainMenuFebButton.setOnAction(actionEvent -> openMonthMenu(mainMenuFebButton, 2));
		mainMenuMarchButton.setOnAction(actionEvent -> openMonthMenu(mainMenuMarchButton, 3));
		mainMenuAprButton.setOnAction(actionEvent -> openMonthMenu(mainMenuAprButton, 4));
		mainMenuMayButton.setOnAction(actionEvent -> openMonthMenu(mainMenuMayButton, 5));
		mainMenuJuneButton.setOnAction(actionEvent -> openMonthMenu(mainMenuJuneButton, 6));
		mainMenuJulyButton.setOnAction(actionEvent -> openMonthMenu(mainMenuJulyButton, 7));
		mainMenuAugButton.setOnAction(actionEvent -> openMonthMenu(mainMenuAugButton, 8));
		mainMenuSeptButton.setOnAction(actionEvent -> openMonthMenu(mainMenuSeptButton, 9));
		mainMenuOctButton.setOnAction(actionEvent -> openMonthMenu(mainMenuOctButton, 10));
		mainMenuNovButton.setOnAction(actionEvent -> openMonthMenu(mainMenuNovButton, 11));
		mainMenuDecButton.setOnAction(actionEvent -> openMonthMenu(mainMenuFebButton, 12));
		events.setOnAction(actionEvent -> {
			nw.closeScene(events);
			nw.openNewScene("/com/bestgroup/calendar/Events.fxml");
		});


	}

	/**
	 * Opens fxml file and sets month-variable in AppHelper class
	 * @see AppHelper#setMonthNumber(int)
	 * @param btn button that had been pushed
	 * @param monthNum number of month (starts from 1)
	 */
	void openMonthMenu(Button btn, int monthNum) {
		boolean isYear = isYear();
		if (!isYear) {
			nw.openNewScene("/com/bestgroup/calendar/FailedChoosingYear.fxml");
		} else {
			AppHelper.setMonthNumber(monthNum);
			AppHelper.setYear(Integer.parseInt(chooseYear.getValue()));
			nw.closeScene(btn);
			nw.openNewScene("/com/bestgroup/calendar/Month.fxml");
		}
	}

	/**
	 * Checks if year was chosen
	 * @return true if the year had been chosen
	 */
	Boolean isYear() {
		boolean isYear = true;
		try {
			Integer.parseInt(chooseYear.getValue());
		} catch (NumberFormatException e) {
			isYear = false;
		}
		return isYear;
	}

}