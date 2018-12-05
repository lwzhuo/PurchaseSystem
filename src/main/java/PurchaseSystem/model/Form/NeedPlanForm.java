package PurchaseSystem.model.Form;

import java.sql.Timestamp;
import java.util.Date;

public class NeedPlanForm extends form {
    private Timestamp receiveDate;
    private Long makerId;
    private Integer apartment;

    public Timestamp getReceiveDate() {
        return receiveDate;
    }

    public void setReceiveDate(Timestamp receiveDate) {
        this.receiveDate = receiveDate;
    }

    public Long getMakerId() {
        return makerId;
    }

    public void setMakerId(Long makerId) {
        this.makerId = makerId;
    }

    public Integer getApartment() {
        return apartment;
    }

    public void setApartment(Integer apartment) {
        this.apartment = apartment;
    }
}
