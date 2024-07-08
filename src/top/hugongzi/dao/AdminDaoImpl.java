package top.hugongzi.dao;

import top.hugongzi.entity.Admin;
import top.hugongzi.framework.db.JDBCTemplate;
import top.hugongzi.framework.db.RowMapper;

import java.util.List;

public class AdminDaoImpl implements AdminDao {
    private final RowMapper<Admin> rowMapper = (rs, rowNum) -> {
        Admin admin = new Admin();
        admin.setAid(rs.getLong("aid"));
        admin.setAdminId(rs.getString("admin_id"));
        admin.setAdminName(rs.getString("admin_name"));
        admin.setAdminPassword(rs.getString("admin_password"));
        admin.setAdminType(rs.getLong("admin_type"));
        admin.setCreatetime(rs.getTimestamp("createtime"));
        return admin;
    };

    public RowMapper<Admin> getRowMapper() {
        return rowMapper;
    }

    @Override
    public Admin getAdmin(String adminId) throws Exception {
        String sql = "select * from admin where admin_id = ?";
        return JDBCTemplate.queryForObject(sql, rowMapper, adminId);
    }

    @Override
    public long getAdminCount() throws Exception {
        String sql = "select count(*) from admin";
        return JDBCTemplate.queryForObject(sql, (rs, rowNum) -> rs.getLong(1), null);
    }

    @Override
    public List<Admin> getAllAdmin(int last_limit, int next_limit) {
        String sql = "select * from admin limit ?,?";
        return JDBCTemplate.query(sql, rowMapper, last_limit, next_limit);
    }

    @Override
    public boolean deleteAdmin(int aid) {
        String sql = "delete from admin where aid = ?";
        return JDBCTemplate.update(sql, aid) >= 1;
    }

    @Override
    public Admin getAdmin(int aid) throws Exception {
        String sql = "select * from admin where aid = ?";
        return JDBCTemplate.queryForObject(sql, rowMapper, aid);
    }

    @Override
    public boolean updateAdmin(int aid, String adminId, String adminName, String adminPassword, String adminType) {
        String sql = "update admin set admin_id= ? ,admin_name= ? ,admin_password= ? ,admin_type= ?  where aid= ?";
        return JDBCTemplate.update(sql, adminId, adminName, adminPassword, adminType, aid) >= 1;
    }
}
