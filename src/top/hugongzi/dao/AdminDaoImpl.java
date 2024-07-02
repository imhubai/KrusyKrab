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
        String sql = "select * from admin where admin_id = '" + adminId + "'";
        return JDBCTemplate.queryForObject(sql, rowMapper, (Object[]) null);
    }

    @Override
    public long getAdminCount() throws Exception {
        String sql = "select count(*) from admin";
        return JDBCTemplate.queryForObject(sql, (rs, rowNum) -> rs.getLong(1), null);
    }

    @Override
    public List<Admin> getAllAdmin(int last_limit, int next_limit) {
        String sql = "select * from admin limit " + last_limit + "," + next_limit;
        return JDBCTemplate.query(sql, rowMapper, (Object[]) null);
    }

    @Override
    public boolean deleteAdmin(int aid) throws Exception {
        String sql = "delete from admin where aid = " + aid;
        return JDBCTemplate.update(sql, null) >= 1;
    }
}
