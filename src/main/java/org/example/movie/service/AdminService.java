package org.example.movie.service;

import org.example.movie.entity.AdminMovie;
import org.example.movie.repository.AdminRepository;

import java.util.List;

public class AdminService {

    private final AdminRepository adminRepository = new AdminRepository();

    // Method to retrieve all admins
    public List<AdminMovie> getAllAdmins() {
        return adminRepository.getAllAdmins(); // Call repository to get all admins
    }

    // Other methods (addAdmin, getAdminById, removeAdmin)
    public void addAdmin(AdminMovie admin) {
        adminRepository.saveAdmin(admin);
    }

    public AdminMovie getAdminById(Long id) {
        return adminRepository.findAdminById(id);
    }

    public void removeAdmin(Long id) {
        adminRepository.deleteAdmin(id);
    }
}