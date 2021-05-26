package ha.hoclaptrinhweb.dao;

import java.util.List;

import ha.hoclaptrinhweb.model.CategoryModel;

public interface ICategoryDAO extends GenericDAO<CategoryModel> {
	List<CategoryModel> findAll();
	CategoryModel findOne(Long id);
	CategoryModel findOneByCode(String code);
}
