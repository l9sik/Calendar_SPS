package com.bestgroup.calendar;

import java.awt.*;

/**
 * Real author RAnders00
 * This class shows notifications
 * @author l9sik
 */
public class Notifications {
    /**
     * Displays windows notification
     * @param theme theme to show in notification
     * @param description description to show in notification
     */
    public void displayTray(String theme, String description) {
        try {
            SystemTray tray = SystemTray.getSystemTray();
            Image image = Toolkit.getDefaultToolkit().createImage(getClass().getResource("icon.png"));

            TrayIcon trayIcon = new TrayIcon(image, "Tray Demo");
            trayIcon.setImageAutoSize(true);
            trayIcon.setToolTip("System tray icon demo");
            tray.add(trayIcon);

            trayIcon.displayMessage(theme, description, TrayIcon.MessageType.INFO);
        }catch (AWTException e){
            System.out.println("Error. Notification can't be displayed");
        }
    }
}
