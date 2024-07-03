package top.hugongzi.dao;

import top.hugongzi.entity.User;
import top.hugongzi.framework.db.JDBCTemplate;
import top.hugongzi.framework.db.RowMapper;

public class UserDaoImpl implements UserDao{
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

    @Override
    public User getUser(String username) throws Exception {
        String sql = "select * from user where user_id = ?";
        return JDBCTemplate.queryForObject(sql, rowMapper, username);
    }
}
