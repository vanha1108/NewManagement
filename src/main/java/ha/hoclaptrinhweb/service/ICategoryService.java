package ha.hoclaptrinhweb.service;

import java.util.List;

import ha.hoclaptrinhweb.model.CategoryModel;

public interface ICategoryService {
	List<CategoryModel> findAll();
	
	CategoryModel findOne(long id);
	
	CategoryModel save(CategoryModel newCatgory) ;
	
	CategoryModel update(CategoryModel updateCategory);
	
	void delete(long[] ids);
	
	int getTotalItem();
}
