package lone.wolf.demo.Dao;

import lone.wolf.demo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @ClassName UserDao
 * @Description
 * @Author hechunhui
 * @Date 2018/7/2 18:06
 */
@Repository
public class UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Map<String, Object>> getAllUser() {
        String sql = "select * from user";
        List<Map<String, Object>> users = jdbcTemplate.queryForList(sql);
        return users;
    }

    public boolean deleteUser(String userid) {
        String sql = "delete from user where userid = ?";
        int delCode = jdbcTemplate.update(sql, userid);
        return delCode > 0;
    }

    public boolean addUser(User user) {
        String sql = "insert into user(userid,username,gender,createtime,address) values(?,?,?,?,?)";
        int resultCode = jdbcTemplate.update(sql, new PreparedStatementSetter() {
            public void setValues(PreparedStatement ps) throws SQLException {
                Timestamp createTime = new Timestamp(user.getCreatetime().getTime());

                ps.setString(1, UUID.randomUUID().toString());
                ps.setString(2, user.getUsername());
                ps.setString(3, user.getGender());
                ps.setTimestamp(4, createTime);
                ps.setString(5, user.getAddress());
            }
        });
        return resultCode > 0;
    }

    public User findUserById(String userId) {
        String sql = "select * from user where userid=?";
        User user = new User();
        try {
            user = (User) jdbcTemplate.queryForObject(sql, new MyRowMapper(), userId);
        } catch (EmptyResultDataAccessException e) {
        }
        return user;

    }

    public boolean updateUser(User user) {
        String sql = "update user set username=?,gender=?,address=? where userid=?";
        int updateCode = jdbcTemplate.update(sql,
                user.getUsername(),
                user.getGender(),
                user.getAddress(),
                user.getUserid());
        return updateCode > 0;
    }

}

class MyRowMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        String userid = resultSet.getString("userid");
        String username = resultSet.getString("username");
        String gender = resultSet.getString("gender");
        Date createtime = resultSet.getDate("createtime");
        String address = resultSet.getString("address");
        User user = new User();
        user.setUserid(userid);
        user.setUsername(username);
        user.setGender(gender);
        user.setCreatetime(createtime);
        user.setAddress(address);
        return user;
    }
}