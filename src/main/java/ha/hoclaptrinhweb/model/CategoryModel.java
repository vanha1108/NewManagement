package ha.hoclaptrinhweb.model;

import java.util.Date;

public class CategoryModel extends AbstractModel<CategoryModel>{
	
	private Long id;
	
	private String name;

	private  int count_use;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public int getCount_use() {
		return count_use;
	}

	public void setCount_use(int count_use) {
		this.count_use = count_use;
	}
}
