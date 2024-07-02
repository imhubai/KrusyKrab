package top.hugongzi.service;

import top.hugongzi.entity.Admin;

import java.util.List;

public interface AdminService {
    boolean validate(String adminId, String adminPassword) throws Exception;
    List<Admin> getAllAdmin(int last_limit, int next_limit) throws Exception;
    boolean deleteAdmin(int aid) throws Exception;
    long getAdminCount() throws Exception;
    Admin getAdminById(int aid) throws Exception;
    boolean editAdmin(int aid, String adminId, String adminName, String adminPassword, String adminType) throws Exception;
}
