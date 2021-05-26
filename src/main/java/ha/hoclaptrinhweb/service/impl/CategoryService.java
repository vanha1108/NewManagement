package ha.hoclaptrinhweb.service.impl;

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

}
