package ha.hoclaptrinhweb.dao;

import java.util.List;

import ha.hoclaptrinhweb.model.NewModel;
import ha.hoclaptrinhweb.paging.Pageble;

public interface INewDAO extends GenericDAO<NewModel> {
	List<NewModel> findByCategoryId(Long categoryId);
	
	Long save(NewModel newModel);
	
	NewModel findOne(Long id);
	
	void update(NewModel updateNew);
	
	void delete(long ids);
	
	List<NewModel> findAll(Pageble pageble);

	List<NewModel> findTopView(int number);

	List<NewModel> findByCategory(Long categoryId, int limit);

	void upViewClick(Long id);

	int getTotalItem();
}
