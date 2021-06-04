package ha.hoclaptrinhweb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import ha.hoclaptrinhweb.model.NewModel;

public class NewMapper implements RowMapper<NewModel>{

	@Override
	public NewModel mapRow(ResultSet resultSet) {
		try {
			NewModel news = new NewModel();
			news.setId(resultSet.getLong("id"));
			news.setTitle(resultSet.getString("title"));
			news.setContent(resultSet.getString("content"));
			news.setCreatedDate(resultSet.getTimestamp("createddate"));
			news.setCategoryId(resultSet.getLong("categoryid"));
			news.setThumbnail(resultSet.getString("thumbnail"));
			news.setShortDescription(resultSet.getString("shortdescription"));
			news.setCreatedBy(resultSet.getString("createdby"));
			news.setViewClick(resultSet.getLong("viewclick"));

			String createddate = new SimpleDateFormat("dd-MM-yy").format(resultSet.getTimestamp("createddate"));
			news.setDisCreateDate(createddate);

			if(resultSet.getTimestamp("modifieddate") != null) {
				news.setModifiedDate(resultSet.getTimestamp("modifieddate"));
			}
			if(resultSet.getString("modifiedby") != null) {
				news.setModifiedBy(resultSet.getString("modifiedby"));
			}
			return news;
		} catch (SQLException e) {
			return null;
		}
		
	}

}
