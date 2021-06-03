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
	public CategoryModel findByName(String name) {
		String sql ="select * from category where name = N?";
		List<CategoryModel> category = query(sql,new CategoryMapper(),name);
		return  category.isEmpty() ? null:category.get(0);
	}

	@Override
	public Long save(CategoryModel categoryModel) {
		StringBuilder sql = new StringBuilder("INSERT INTO category (name,count_use)");
		sql.append("createddate, createdby) VALUES (?)");
		return insert(sql.toString(),categoryModel.getName());
	}

	@Override
	public void update(CategoryModel updateCategory) {
		StringBuilder sql = new StringBuilder("UPDATE category set name = ? and count_use = ? where id = ?");
		update(sql.toString(),updateCategory.getName(), updateCategory.getId());
		
	}

	@Override
	public void delete(long ids) {
		String sql = "DELETE from category WHERE id = ?";
		update(sql,ids);
		
	}

	@Override
	public int getTotalItem() {
		// TODO Auto-generated method stub
		String sql = "SELECT count(*) FROM category";
		return count(sql);
	}
}
