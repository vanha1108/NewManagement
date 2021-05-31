package ha.hoclaptrinhweb.model;

import java.util.Date;

public class CategoryModel extends AbstractModel<CategoryModel>{
	
	private Long id;
	
	private String name;
	
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
	
}
