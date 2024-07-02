package top.hugongzi.dao;

import top.hugongzi.entity.Admin;

import java.util.List;

public interface AdminDao {
    Admin getAdmin(String adminId) throws Exception;
    long getAdminCount() throws Exception;
    List<Admin> getAllAdmin(int last_limit, int next_limit) throws Exception;
    boolean deleteAdmin(int aid) throws Exception;
    Admin getAdmin(int aid) throws Exception;
    boolean updateAdmin(int aid, String adminId, String adminName, String adminPassword, String adminType);
}
