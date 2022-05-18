package Controller;

import Model.User;
import Model.Reimbursement;
import Service.UserService;
import Service.ReimbursementService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.javalin.Javalin;

public class UserController {

    public UserController(){

    }

    public void startController(){
        Javalin app = Javalin.create();
        UserService userService = new UserService();
        ReimbursementService reimbursementService = new ReimbursementService();
        app.start(5000);


        app.get("reimbursements", context -> context.json(reimbursementService.getAllReimbursements()));
        app.get("reimbursement/reimbursementID/{id}", context -> {

            int reimbursementID = Integer.parseInt(context.pathParam("id"));
            context.json(reimbursementService.getReimbursement(reimbursementID));
        });
        app.get("users", context -> context.json(userService.getAllUsers()));
        app.post("reimbursement", context -> {

            ObjectMapper mapper = new ObjectMapper();
            Reimbursement reimbursementToBeAdded = mapper.readValue(context.body(), Reimbursement.class);
            reimbursementService.addReimbursement(reimbursementToBeAdded);
        });
        app.put("reimbursement", context -> {

            ObjectMapper mapper = new ObjectMapper();
            Reimbursement reimbursementToBeUpdated = mapper.readValue(context.body(), Reimbursement.class);
            reimbursementService.updateReimbursement(reimbursementToBeUpdated);
        });
        app.post("user", context -> {
            ObjectMapper mapper = new ObjectMapper();
            User userToBePosted = mapper.readValue(context.body(), User.class);
            userService.addUser(userToBePosted);
        });
        app.delete("reimbursement/reimbursementID/{id}", context -> {
            int reimbursementID = Integer.parseInt(context.pathParam("id"));
            reimbursementService.deleteReimbursement(reimbursementID);
        });
        app.get("reimbursement/nonrefundable", context -> context.json(reimbursementService.getAllNonrefundableReimbursements()));
    }


}
