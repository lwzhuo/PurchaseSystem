package PurchaseSystem.model.Store;

import PurchaseSystem.model.Form.form;

public class InStoreForm extends form {
    private long auditorId;
    private long receiptId;

    public long getAuditorId() {
        return auditorId;
    }

    public void setAuditorId(long auditorId) {
        this.auditorId = auditorId;
    }

    public long getReceiptId() {
        return receiptId;
    }

    public void setReceiptId(long receiptId) {
        this.receiptId = receiptId;
    }
}
