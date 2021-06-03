package ha.hoclaptrinhweb.service;

import ha.hoclaptrinhweb.model.UserModel;
import ha.hoclaptrinhweb.paging.Pageble;

import java.util.List;

public interface IUserService {
    UserModel findByUsernameAndPasswordAndStatus(String userName, String password, int status);

    UserModel save(UserModel userModel);
    
    UserModel update(UserModel updateModel);
    
    void delete(long id);
    
    UserModel findById(long id);

    List<UserModel> findAll(Pageble pageble);
    
    int getTotalItem();
}
 