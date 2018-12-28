package purchasesystem.model.Store;

import purchasesystem.model.form.Form;

public class InStoreForm extends Form {
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
