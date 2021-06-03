package ha.hoclaptrinhweb.dao;

import java.util.List;

import ha.hoclaptrinhweb.model.CategoryModel;
import ha.hoclaptrinhweb.model.NewModel;
import ha.hoclaptrinhweb.paging.Pageble;

public interface ICategoryDAO extends GenericDAO<CategoryModel> {
	List<CategoryModel> findAll();
	
	CategoryModel findOne(Long id);

	CategoryModel findByName(String name);
	
    Long save(CategoryModel categoryModel);
	
	void update(CategoryModel updateNew);
	
	void delete(long ids);
	
	int getTotalItem();
	
}
