package ha.hoclaptrinhweb.dao.impl;

import java.util.List;

import ha.hoclaptrinhweb.dao.ICategoryDAO;
import ha.hoclaptrinhweb.mapper.CategoryMapper;
import ha.hoclaptrinhweb.mapper.NewMapper;
import ha.hoclaptrinhweb.model.CategoryModel;
import ha.hoclaptrinhweb.model.NewModel;

public class CategoryDAO extends AbstractDAO<CategoryModel> implements ICategoryDAO {

	@Override
	public List<CategoryModel> findAll() {
		String sql = "SELECT * FROM category";
		return query(sql, new CategoryMapper());
	}

    @Override
    public CategoryModel findOne(Long id) {
		String sql = "SELECT * FROM category WHERE id = ?";
		List<CategoryModel> categories = query(sql, new CategoryMapper(), id);
		return categories.isEmpty() ? null : categories.get(0);
    }

	@Override
	public CategoryModel findOneByCode(String code) {
		String sql = "SELECT * FROM category WHERE code = ?";
		List<CategoryModel> categories = query(sql, new CategoryMapper(), code);
		return categories.isEmpty() ? null : categories.get(0);
	}
}
