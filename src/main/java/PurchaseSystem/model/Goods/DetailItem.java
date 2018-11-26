package PurchaseSystem.model.Goods;

public class DetailItem {
    private long detailItemId;
    private long formId;
    private long goodsId;
    private int goodsNum;

    public long getDetailItemId() {
        return detailItemId;
    }

    public void setDetailItemId(long detailItemId) {
        this.detailItemId = detailItemId;
    }

    public long getFormId() {
        return formId;
    }

    public void setFormId(long formId) {
        this.formId = formId;
    }

    public long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(long goodsId) {
        this.goodsId = goodsId;
    }

    public int getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(int goodsNum) {
        this.goodsNum = goodsNum;
    }
}
