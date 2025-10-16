package com.example.labjpa.entity.task;
import jakarta.persistence.Entity;
@Entity
public class BillableTask extends Task {
    private java.math.BigDecimal hourlyRate;
    public java.math.BigDecimal getHourlyRate(){return hourlyRate;}
    public void setHourlyRate(java.math.BigDecimal hourlyRate){this.hourlyRate=hourlyRate;}
}
