package Model;

public class Reimbursement {

    private int reimbursementID;
    private String initialPayment;
    private String reimbursedPayment;
    private Status status;

    public Reimbursement(){

    }

    public Reimbursement(String initialPayment, String reimbursedPayment, Status status) {
        this.reimbursementID = reimbursementID;
        this.initialPayment = initialPayment;
        this.reimbursedPayment = reimbursedPayment;
        this.status = status;
    }

    public enum Status{
        APPROVED,
        DENIED,
        PENDING
    }

    public int getReimbursementID() {
        return reimbursementID;
    }

    public void setReimbursementID(int reimbursementID) {
        this.reimbursementID = reimbursementID;
    }

    public String getInitialPayment() {
        return reimbursedPayment;
    }

    public void setInitialPayment(String initialPayment) {
        this.initialPayment = initialPayment;
    }

    public String getReimbursedPayment() {
        return reimbursedPayment;
    }

    public void setReimbursedPayment(String reimbursedPayment) {
        this.reimbursedPayment = reimbursedPayment;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Reimbursement{" +
                "reimbursementID=" + reimbursementID +
                ", initialPayment='" + initialPayment + '\'' +
                ", reimburesedPayment='" + reimbursedPayment + '\'' +
                ", status=" + status +
                '}';
    }
}
