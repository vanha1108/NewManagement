package ha.hoclaptrinhweb.model;

public class NewModel extends AbstractModel<NewModel> {
    private String title;

    private String thumbnail;

    private String shortDescription;

    private String content;

    private Long categoryId;

    private  String categoryName;

    private  Long viewClick;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Long getViewClick() {
        return viewClick;
    }

    public void setViewClick(Long viewClick) {
        this.viewClick = viewClick;
    }
}
