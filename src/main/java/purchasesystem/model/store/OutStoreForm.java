package purchasesystem.model.store;

import purchasesystem.model.form.Form;

public class OutStoreForm extends Form {
    private Long auditorId;

    public Long getAuditorId() {
        return auditorId;
    }

    public void setAuditorId(long auditorId) {
        this.auditorId = auditorId;
    }
}
