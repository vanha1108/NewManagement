package ha.hoclaptrinhweb.dao;

import ha.hoclaptrinhweb.model.UserModel;

public interface IUSerDAO {
    UserModel findByUsernameAndPasswordAndStatus(String userName, String password, int status);
}
