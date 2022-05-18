package Service;

import Model.Reimbursement;

import java.util.ArrayList;

public class ReimbursementService {
    ArrayList<Reimbursement> reimbursementArrayList;
    public ReimbursementService(){
        reimbursementArrayList = new ArrayList<>();
        addReimbursement(new Reimbursement("Paid", "Refunded", Reimbursement.Status.APPROVED));
        addReimbursement(new Reimbursement("Paid", "Not Refunded", Reimbursement.Status.DENIED));
        addReimbursement(new Reimbursement("Paid", "Payment Pending", Reimbursement.Status.PENDING));

    }
    public ArrayList<Reimbursement> getAllReimbursements(){
        return reimbursementArrayList;
    }
    public void addReimbursement(Reimbursement f){

        reimbursementArrayList.add(f);
        f.setReimbursementID(reimbursementArrayList.size()-1);
    }
    public void updateReimbursement(Reimbursement f){
        reimbursementArrayList.set(f.getReimbursementID(), f);
    }
    public Reimbursement getReimbursement(int id){
        return reimbursementArrayList.get(id);
    }
    public void deleteReimbursement(int id){
        reimbursementArrayList.remove(id);
    }
    public ArrayList<Reimbursement> getAllNonrefundableReimbursements(){
        ArrayList<Reimbursement> nonrefundableReimbursements = new ArrayList<>();

        for(Reimbursement f : reimbursementArrayList){
            if(f.getStatus() == Reimbursement.Status.DENIED){
                nonrefundableReimbursements.add(f);
            }
        }
        return nonrefundableReimbursements;
    }
}
