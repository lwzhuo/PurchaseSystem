package purchasesystem.model.Store;

import purchasesystem.model.Form.Form;

public class OutStoreForm extends Form {
    private Long auditorId;

    public Long getAuditorId() {
        return auditorId;
    }

    public void setAuditorId(long auditorId) {
        this.auditorId = auditorId;
    }
}
