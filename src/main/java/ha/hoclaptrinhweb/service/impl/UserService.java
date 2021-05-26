package ha.hoclaptrinhweb.service.impl;

import ha.hoclaptrinhweb.dao.IUSerDAO;
import ha.hoclaptrinhweb.model.UserModel;
import ha.hoclaptrinhweb.service.IUserService;

import javax.inject.Inject;

public class UserService implements IUserService {

    @Inject
    private IUSerDAO userDAO;

    @Override
    public UserModel findByUsernameAndPasswordAndStatus(String userName, String password, int status) {
        return userDAO.findByUsernameAndPasswordAndStatus(userName, password, status);
    }
}
