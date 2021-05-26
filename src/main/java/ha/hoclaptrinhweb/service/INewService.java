package ha.hoclaptrinhweb.service;

import java.util.List;

import ha.hoclaptrinhweb.model.NewModel;
import ha.hoclaptrinhweb.paging.Pageble;

public interface INewService {
	List<NewModel> findByCategoryId(Long categoryId);
	NewModel save(NewModel newModel);
	NewModel update(NewModel updateNew);
	void delete(long[] ids);
	List<NewModel> findAll(Pageble pageble);
	int getTotalItem();
	NewModel findOne(long id);
} 