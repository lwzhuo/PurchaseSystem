package purchasesystem.model.form;

import purchasesystem.model.goods.DetailItem;

import java.sql.Timestamp;
import java.util.List;

public class Form {
    private Long id;
    private String title;
    private Integer status;
    private String comment;
    private List<DetailItem> detailList;
    private Timestamp makeDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public List<DetailItem> getDetailList() {
        return detailList;
    }

    public void setDetailList(List<DetailItem> detailList) {
        this.detailList = detailList;
    }

    public Timestamp getMakeDate() {
        return makeDate;
    }

    public void setMakeDate(Timestamp makeDate) {
        this.makeDate = makeDate;
    }
}
