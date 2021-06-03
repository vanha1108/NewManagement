package ha.hoclaptrinhweb.dao.impl;

import ha.hoclaptrinhweb.dao.IUSerDAO;
import ha.hoclaptrinhweb.mapper.UserMapper;
import ha.hoclaptrinhweb.model.UserModel;

import java.util.List;

public class UserDAO extends AbstractDAO<UserDAO> implements IUSerDAO {
    @Override
    public UserModel findByUsernameAndPasswordAndStatus(String userName, String password, int status) {
        StringBuilder sql = new StringBuilder("SELECT * FROM user AS u");
        sql.append(" INNER JOIN role AS r ON r.id = u.roleid");
        sql.append(" WHERE username = ? AND password = ? AND status = ?");
        List<UserModel> users = query(sql.toString(), new UserMapper(), userName, password, status);
        return users.isEmpty() ? null : users.get(0);
    }

    @Override
    public UserModel findById(Long id) {
        String sql = " select * from user where id = ?";
        List<UserModel> user = query(sql, new UserMapper(), id);
        return user.isEmpty() ? null : user.get(0);
    }

    @Override
    public Long save(UserModel userModel) {
        StringBuilder sql = new StringBuilder("INSERT INTO user (username, password, fullname, status, roleid, ");
        sql.append("createddate, createdby) VALUES (?, ?, ?, ?, ?, ?, ?)");
        return insert(sql.toString(), userModel.getUserName(), userModel.getPassword(), userModel.getFullName(), userModel.getStatus(),
                userModel.getRoleId(), userModel.getCreatedDate(), userModel.getCreatedBy());
    }

    @Override
    public void update(UserModel updateUser) {
        StringBuilder sql = new StringBuilder("UPDATE user SET password = ?,");
        sql.append(" fullname = ?, status = ?, roleid = ?,");
        sql.append("modifieddate = ?, modifiedby = ? WHERE id = ?");
        update(sql.toString(), updateUser.getPassword(), updateUser.getFullName(),
                updateUser.getStatus(), updateUser.getRoleId(), updateUser.getModifiedDate(),
                updateUser.getModifiedBy(), updateUser.getId());
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM user WHERE id = ?";
        update(sql, id);

    }

    @Override
    public List<UserModel> findAll() {
        StringBuilder sql = new StringBuilder("SELECT * FROM user where roleid = 2");
        return query(sql.toString(), new UserMapper());
    }

    @Override
    public int getTotalItem() {
        String sql = "SELECT count(*) FROM user where id = 2";
        return count(sql);
    }

    @Override
    public UserModel findByUserName(String userName) {
        StringBuilder sql = new StringBuilder("SELECT * FROM user where username = ? and roleid = 2");
        List<UserModel> users = query(sql.toString(), new UserMapper(), userName);
        return users.isEmpty() ? null : users.get(0);
    }
}
