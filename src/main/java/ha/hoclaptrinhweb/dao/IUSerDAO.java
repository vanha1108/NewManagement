package ha.hoclaptrinhweb.dao;

import java.util.List;

import ha.hoclaptrinhweb.model.UserModel;
import ha.hoclaptrinhweb.paging.Pageble;

public interface IUSerDAO {
    UserModel findByUsernameAndPasswordAndStatus(String userName, String password, int status);

    UserModel findById(Long id);
    
    Long save(UserModel userModel);
    
    void update(UserModel updateUser);
    
    void delete(Long id);
    
    List<UserModel> findAll(Pageble pageble);
    
    int getTotalItem();
    
}
