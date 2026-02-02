package com.ironlady.participant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.awt.Desktop;
import java.net.URI;

@SpringBootApplication
public class IronLadyParticipantManagementApplication {

    public static void main(String[] args) {
        // Force disable headless mode so Desktop can work on Windows desktop
        System.setProperty("java.awt.headless", "false");

        SpringApplication.run(IronLadyParticipantManagementApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void openBrowserWhenReady() {
        try {
            String url = "http://localhost:8080";

            if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                Desktop.getDesktop().browse(new URI(url));
                System.out.println("Browser opened automatically → " + url);
            } else {
                System.out.println("Desktop browse not supported on this environment.");
            }
        } catch (Exception e) {
            System.err.println("Failed to open browser automatically: " + e.getClass().getSimpleName() + " - " + e.getMessage());
            e.printStackTrace();  // print full stack for better debugging
        }
    }
}