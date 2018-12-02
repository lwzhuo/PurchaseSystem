package PurchaseSystem.model.Form;

import PurchaseSystem.model.Goods.DetailItem;

import java.util.Date;
import java.util.List;

public abstract class form {
    private Long id;
    private String name;
    private Integer status;
    private String comment;
    private List<DetailItem> detailList;
    private Date makeDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Date getMakeDate() {
        return makeDate;
    }

    public void setMakeDate(Date makeDate) {
        this.makeDate = makeDate;
    }
}
