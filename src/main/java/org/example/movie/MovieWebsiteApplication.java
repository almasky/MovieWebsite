package org.example.movie;

import org.example.movie.controller.AdminController;

public class MovieWebsiteApplication {
    public static void main(String[] args) {
        AdminController adminController = new AdminController();
        adminController.manageAdmins();
    }
}
