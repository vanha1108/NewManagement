package ha.hoclaptrinhweb.dao;

import ha.hoclaptrinhweb.model.CategoryModel;

import java.util.List;

public interface ICategoryDAO extends GenericDAO<CategoryModel> {
    List<CategoryModel> findAll();

    CategoryModel findOne(Long id);

    CategoryModel findByName(String name);

    Long save(CategoryModel categoryModel);

    void update(CategoryModel updateNew);

    void delete(long ids);

    int getTotalItem();
}
