package PurchaseSystem.model.Store;

import PurchaseSystem.model.Form.form;

public class InStoreForm extends form {
    private Long auditorId;
    private Long receiptId;

    public Long getAuditorId() {
        return auditorId;
    }

    public void setAuditorId(Long auditorId) {
        this.auditorId = auditorId;
    }

    public Long getReceiptId() {
        return receiptId;
    }

    public void setReceiptId(Long receiptId) {
        this.receiptId = receiptId;
    }
}
