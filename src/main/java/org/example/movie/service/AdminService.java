package org.example.movie.service;
import org.example.movie.entity.AdminMovie;
import org.example.movie.repository.AdminRepository;

import java.util.List;

public class AdminService {
    private final AdminRepository adminRepository = new AdminRepository();

    // Add a new admin
    public void addAdmin(AdminMovie admin) {
        adminRepository.saveAdmin(admin);
    }

    // Get all admins
    public List<AdminMovie> getAdmins() {
        return adminRepository.getAllAdmins();
    }

    // Find admin by ID
    public AdminMovie getAdminById(Long id) {
        return adminRepository.findAdminById(id);
    }

    // Remove an admin
    public void removeAdmin(Long id) {
        adminRepository.deleteAdmin(id);
    }

}
