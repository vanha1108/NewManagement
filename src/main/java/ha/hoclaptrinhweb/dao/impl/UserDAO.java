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
}
