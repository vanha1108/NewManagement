package ha.hoclaptrinhweb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import ha.hoclaptrinhweb.model.CategoryModel;

public class CategoryMapper implements RowMapper<CategoryModel> {

	@Override
	public CategoryModel mapRow(ResultSet resultSet) {
		try {
			CategoryModel category = new CategoryModel();
			category.setId(resultSet.getLong("id"));
			category.setName(resultSet.getString("name"));
			category.setCount_use(resultSet.getInt("count_use"));
			return category;
		} catch (SQLException e) {
			return null;
		}
	}

}
