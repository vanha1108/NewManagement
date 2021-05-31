package ha.hoclaptrinhweb.service.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import ha.hoclaptrinhweb.dao.ICategoryDAO;
import ha.hoclaptrinhweb.model.CategoryModel;
import ha.hoclaptrinhweb.service.ICategoryService;

public class CategoryService implements ICategoryService {

	@Inject
	private ICategoryDAO categoryDao;

	@Override
	public List<CategoryModel> findAll() {
		return categoryDao.findAll();
	}

	@Override
	public CategoryModel findOne(long id) {
		 CategoryModel categoryModel = categoryDao.findOne(id);
		 
		return categoryModel;
	}

	@Override
	public CategoryModel save(CategoryModel newCategory) {
		newCategory.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		newCategory.setModifiedDate(new Timestamp(System.currentTimeMillis()));
		
		Long newId = categoryDao.save(newCategory);
		return categoryDao.findOne(newId);
	}

	@Override
	public CategoryModel update(CategoryModel updateCategory) {
		CategoryModel categoryModel = categoryDao.findOne(updateCategory.getId());
		
		updateCategory.setCreatedDate(categoryModel.getCreatedDate());
		updateCategory.setModifiedDate(new Timestamp(System.currentTimeMillis()));
		updateCategory.setCreatedBy(categoryModel.getCreatedBy());
		
		categoryDao.update(updateCategory);
		return categoryDao.findOne(updateCategory.getId());
	}

	@Override
	public void delete(long[] ids) {
		for(long id:ids) {
			categoryDao.delete(id);
		}
		
	}

	@Override
	public int getTotalItem() {
		// TODO Auto-generated method stub
		return 0;
	}

}
