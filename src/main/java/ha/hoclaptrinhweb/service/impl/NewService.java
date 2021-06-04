package ha.hoclaptrinhweb.service.impl;

import ha.hoclaptrinhweb.dao.ICategoryDAO;
import ha.hoclaptrinhweb.dao.INewDAO;
import ha.hoclaptrinhweb.model.CategoryModel;
import ha.hoclaptrinhweb.model.NewModel;
import ha.hoclaptrinhweb.paging.Pageble;
import ha.hoclaptrinhweb.service.INewService;

import javax.inject.Inject;
import java.sql.Timestamp;
import java.util.List;

public class NewService implements INewService {

    @Inject
    private INewDAO newDao;

    @Inject
    private ICategoryDAO categoryDAO;

    @Override
    public List<NewModel> findByCategoryId(Long categoryId) {
        return newDao.findByCategoryId(categoryId);
    }

    @Override
    public NewModel save(NewModel newModel) {
        newModel.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        CategoryModel categoryModel = categoryDAO.findOne(newModel.getCategoryId());
        newModel.setCategoryId(categoryModel.getId());
        Long newId = newDao.save(newModel);
        int countUse = categoryModel.getCount_use();
        categoryModel.setCount_use(countUse + 1);
        categoryDAO.update(categoryModel);
        return newDao.findOne(newId);
    }

    @Override
    public NewModel update(NewModel updateNew) {
        NewModel oldNew = newDao.findOne(updateNew.getId());
        updateNew.setCreatedDate(oldNew.getCreatedDate());
        updateNew.setModifiedDate(new Timestamp(System.currentTimeMillis()));
        updateNew.setCreatedBy(oldNew.getCreatedBy());
        CategoryModel categoryModel = categoryDAO.findOne(updateNew.getCategoryId());
        updateNew.setCategoryId(categoryModel.getId());
        newDao.update(updateNew);
        return newDao.findOne(updateNew.getId());
    }

    @Override
    public void delete(long[] ids) {
        for (long id : ids) {
            // delete comment of new
            newDao.delete(id);
        }
    }

    @Override
    public List<NewModel> findAll(Pageble pageble) {
        return newDao.findAll(pageble);
    }

    @Override
    public List<NewModel> findTopView(int number) {
        return newDao.findTopView(number);
    }

    @Override
    public List<NewModel> findByCategory(Long categoryId, int limit) {
        return newDao.findByCategory(categoryId,limit);
    }

    @Override
    public int getTotalItem() {
        return newDao.getTotalItem();
    }

    @Override
    public NewModel findOne(long id) {
        NewModel newModel = newDao.findOne(id);
        return newModel;
    }
}
