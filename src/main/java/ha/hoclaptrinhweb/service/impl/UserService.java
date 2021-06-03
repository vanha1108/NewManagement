package ha.hoclaptrinhweb.service.impl;

import ha.hoclaptrinhweb.dao.IUSerDAO;
import ha.hoclaptrinhweb.model.CategoryModel;
import ha.hoclaptrinhweb.model.NewModel;
import ha.hoclaptrinhweb.model.UserModel;
import ha.hoclaptrinhweb.paging.Pageble;
import ha.hoclaptrinhweb.service.IUserService;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

public class UserService implements IUserService {

    @Inject
    private IUSerDAO userDAO;

    @Override
    public UserModel findByUsernameAndPasswordAndStatus(String userName, String password, int status) {
        return userDAO.findByUsernameAndPasswordAndStatus(userName, password, status);
    }

	@Override
	public UserModel save(UserModel userModel) {
		userModel.setCreatedDate(new Timestamp(System.currentTimeMillis()));		
		Long newId = userDAO.save(userModel);
		return userDAO.findById(newId);	
	}

	@Override
	public UserModel update(UserModel updateModel) {
		UserModel oldUser = userDAO.findById(updateModel.getId());
		
		updateModel.setCreatedDate(oldUser.getCreatedDate());
		updateModel.setModifiedDate(new Timestamp(System.currentTimeMillis()));
		updateModel.setCreatedBy(oldUser.getCreatedBy());
		
		userDAO.update(updateModel);
		return userDAO.findById(updateModel.getId());
	}

	@Override
	public void delete(long id) {
		userDAO.delete(id);
	}

	@Override
	public UserModel findById(long id) {
		UserModel newModel = userDAO.findById(id);
		return newModel;
	}

	@Override
	public List<UserModel> findAll(Pageble pageble) {
		return userDAO.findAll(pageble);
	}

	@Override
	public int getTotalItem() {
		// TODO Auto-generated method stub
		return userDAO.getTotalItem();
	}
}
