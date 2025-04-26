package org.example.movie.controller;

import org.example.movie.entity.AdminMovie;
import org.example.movie.service.AdminService;

import java.util.Scanner;

public class AdminController {

    private final AdminService adminService = new AdminService();

    public void manageAdmins() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nAdmin Management:");
            System.out.println("1. Add Admin");
            System.out.println("2. View All Admins");
            System.out.println("3. Find Admin by ID");
            System.out.println("4. Remove Admin");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Enter Admin Email:");
                    String email = scanner.nextLine();
                    System.out.println("Enter Admin Username:");
                    String username = scanner.nextLine();
                    System.out.println("Enter Admin Password:");
                    String password = scanner.nextLine();

                    AdminMovie newAdmin = new AdminMovie();
                    newAdmin.setEmail(email);
                    newAdmin.setUsername(username);
                    newAdmin.setPassword(password);

                    adminService.addAdmin(newAdmin);
                    System.out.println("Admin added successfully!");
                    break;

                case 2:
                    System.out.println("All Admins:");
                    adminService.getAdmins().forEach(admin ->
                            System.out.println("ID: " + admin.getId() + ", Email: " + admin.getEmail() + ", Username: " + admin.getUsername()));
                    break;

                case 3:
                    System.out.println("Enter Admin ID:");
                    Long id = scanner.nextLong();
                    AdminMovie admin = adminService.getAdminById(id);
                    if (admin != null) {
                        System.out.println("Admin Details -> ID: " + admin.getId() + ", Email: " + admin.getEmail() + ", Username: " + admin.getUsername());
                    } else {
                        System.out.println("Admin not found!");
                    }
                    break;

                case 4:
                    System.out.println("Enter Admin ID to Remove:");
                    Long adminId = scanner.nextLong();
                    adminService.removeAdmin(adminId);
                    System.out.println("Admin removed successfully!");
                    break;

                case 5:
                    System.out.println("Exiting Admin Management...");
                    return;

                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
}