package ha.hoclaptrinhweb.service;

import ha.hoclaptrinhweb.model.UserModel;

public interface IUserService {
    UserModel findByUsernameAndPasswordAndStatus(String userName, String password, int status);
}
