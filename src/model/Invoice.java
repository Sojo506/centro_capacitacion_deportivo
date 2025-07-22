package model;

import java.io.Serializable;
import java.time.LocalDateTime;
import util.InvoiceEnum;

public class Invoice implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private int parentId;
    private double total;
    private InvoiceEnum status;
    private boolean active;
    private LocalDateTime createdAt;

    public Invoice() {
    }

    public Invoice(int id, int parentId, double total, InvoiceEnum status, boolean active, LocalDateTime createdAt) {
        this.id = id;
        this.parentId = parentId;
        this.total = total;
        this.status = status;
        this.active = active;
        this.createdAt = createdAt;
    }

    public Invoice(int parentId, double total, InvoiceEnum status, boolean active, LocalDateTime createdAt) {
        this.parentId = parentId;
        this.total = total;
        this.status = status;
        this.active = active;
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public InvoiceEnum getStatus() {
        return status;
    }

    public void setStatus(InvoiceEnum status) {
        this.status = status;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

}
