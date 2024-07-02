package top.hugongzi.service;

import top.hugongzi.dao.AdminDao;
import top.hugongzi.dao.AdminDaoImpl;
import top.hugongzi.entity.Admin;

import java.util.List;
import java.util.Objects;

public class AdminServiceImpl implements AdminService {

    @Override
    public boolean validate(String adminId, String adminPassword) throws Exception {
        AdminDao adminDao = new AdminDaoImpl();
        Admin admin = adminDao.getAdmin(adminId);
        if (admin == null) return false;
        else return Objects.equals(adminPassword, admin.getAdminPassword());
    }

    @Override
    public List<Admin> getAllAdmin(int last_limit, int next_limit) throws Exception {
        AdminDao adminDao = new AdminDaoImpl();
        return adminDao.getAllAdmin(last_limit, next_limit);
    }

    @Override
    public boolean deleteAdmin(int aid) throws Exception {
        AdminDao adminDao = new AdminDaoImpl();
        return adminDao.deleteAdmin(aid);
    }

    @Override
    public long getAdminCount() throws Exception {
        AdminDao adminDao = new AdminDaoImpl();
        return adminDao.getAdminCount();
    }
}
