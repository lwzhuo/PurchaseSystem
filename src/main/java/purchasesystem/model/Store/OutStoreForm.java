package purchasesystem.model.Store;

import purchasesystem.model.Form.form;

public class OutStoreForm extends form {
    private Long auditorId;

    public Long getAuditorId() {
        return auditorId;
    }

    public void setAuditorId(long auditorId) {
        this.auditorId = auditorId;
    }
}
