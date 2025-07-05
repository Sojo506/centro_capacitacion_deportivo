package model;

public class InvoiceRoutine {

    private int id;
    private int invoiceId;
    private int routineId;

    public InvoiceRoutine() {
    }

    public InvoiceRoutine(int invoiceId, int routineId) {
        this.invoiceId = invoiceId;
        this.routineId = routineId;
    }

    public InvoiceRoutine(int id, int invoiceId, int routineId) {
        this.id = id;
        this.invoiceId = invoiceId;
        this.routineId = routineId;
    }

    public int getId() {
        return id;
    }

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public int getRoutineId() {
        return routineId;
    }

    public void setRoutineId(int routineId) {
        this.routineId = routineId;
    }

}
