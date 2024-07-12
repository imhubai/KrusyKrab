package top.hugongzi.dao;

import top.hugongzi.entity.User;
import top.hugongzi.framework.db.JDBCTemplate;
import top.hugongzi.framework.db.RowMapper;

import java.util.List;

public class UserDaoImpl implements UserDao {
    private final RowMapper<User> rowMapper = (rs, rowNum) -> {
        User user = new User();
        user.setUid(rs.getLong("uid"));
        user.setUserId(rs.getString("user_id"));
        user.setPassword(rs.getString("password"));
        user.setNickname(rs.getString("nickname"));
        user.setEmail(rs.getString("email"));
        user.setSex(rs.getString("sex"));
        user.setPhone(rs.getString("phone"));
        user.setBirthday(rs.getDate("birthday"));
        user.setUsertype(rs.getLong("usertype"));
        user.setCreatetime(rs.getTimestamp("createtime"));
        user.setAvatar(rs.getString("avatar"));
        return user;
    };

    public RowMapper<User> getRowMapper() {
        return rowMapper;
    }

    @Override
    public User getUser(String username) throws Exception {
        String sql = "select * from user where user_id = ?";
        return JDBCTemplate.queryForObject(sql, rowMapper, username);
    }

    @Override
    public long getUserCount() throws Exception {
        String sql = "select count(*) from user";
        return JDBCTemplate.queryForObject(sql, (rs, rowNum) -> rs.getLong(1), null);
    }

    @Override
    public List<User> getAllUser(int last_limit, int next_limit) throws Exception {
        String sql = "select * from user limit ?,?";
        return JDBCTemplate.query(sql, rowMapper, last_limit, next_limit);
    }

    @Override
    public boolean deleteUser(Long uid) throws Exception {
        String sql = "delete from user where uid = ?";
        return JDBCTemplate.update(sql, uid) >= 1;
    }

    @Override
    public User getUser(Long uid) throws Exception {
        String sql = "select * from user where uid = ?";
        return JDBCTemplate.queryForObject(sql, rowMapper, uid);
    }

    @Override
    public User getUserByName(String username) throws Exception {
        String sql = "select * from user where user_id = ?";
        return JDBCTemplate.queryForObject(sql, rowMapper, username);
    }

    @Override
    public boolean updateUser(Long uid, String userId, String password, String nickname, String email, String sex, String phone, String birthday, String usertype, String avatar) {
        String sql = "update user set user_id = ?,password = ?,nickname = ?,email = ?,sex = ?,phone = ?,birthday = ?,usertype = ?,avatar = ? where uid = ?";
        return JDBCTemplate.update(sql, userId, password, nickname, email, sex, phone, birthday, usertype, avatar, uid) >= 1;
    }
}
