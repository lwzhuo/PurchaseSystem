package purchasesystem.model.goods;

public class DetailItem {
    private Long detailItemId;
    private Long formId;
    private Long goodsId;
    private Integer goodsNum;

    public Long getDetailItemId() {
        return detailItemId;
    }

    public void setDetailItemId(Long detailItemId) {
        this.detailItemId = detailItemId;
    }

    public Long getFormId() {
        return formId;
    }

    public void setFormId(Long formId) {
        this.formId = formId;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
    }
}
