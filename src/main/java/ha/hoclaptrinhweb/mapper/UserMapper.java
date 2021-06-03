package ha.hoclaptrinhweb.mapper;

import ha.hoclaptrinhweb.model.NewModel;
import ha.hoclaptrinhweb.model.RoleModel;
import ha.hoclaptrinhweb.model.UserModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<UserModel> {

    @Override
    public UserModel mapRow(ResultSet resultSet) {
        try {
            UserModel user = new UserModel();
            user.setId(resultSet.getLong("id"));
            user.setUserName(resultSet.getString("username"));
            user.setPassword(resultSet.getString("password"));
            user.setFullName(resultSet.getString("fullname"));
            user.setStatus(resultSet.getInt("status"));
            user.setRoleId(resultSet.getLong("roleId"));
            try {
                if (resultSet.getString("name") != null) {
                    RoleModel roleModel = new RoleModel();
                    roleModel.setName(resultSet.getString("name"));
                    user.setRole(roleModel);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return user;
        } catch (SQLException e) {
            return null;
        }
    }
}
