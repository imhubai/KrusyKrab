package top.hugongzi.dao;

import top.hugongzi.entity.Admin;

import java.util.List;

public interface AdminDao {
    public Admin getAdmin(String adminId) throws Exception;
    public long getAdminCount() throws Exception;
    public List<Admin> getAllAdmin(int last_limit,int next_limit) throws Exception;
    public boolean deleteAdmin(int aid) throws Exception;
}
