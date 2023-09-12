package restDev;

import static spark.Spark.delete;
import static spark.Spark.get;
import static spark.Spark.options;
import static spark.Spark.post;
import static spark.Spark.put;

import com.google.gson.Gson;

public class SparkRestExample {
    public static void main(String[] args) {
        final UserService userService = new UserServiceMapImpl();
        final Gson gsonConverter = new Gson();

        post("/users", (request, response) -> {
            response.type("application/json");

            User user = gsonConverter.fromJson(request.body(), User.class);
            userService.addUser(user);

            return gsonConverter.toJson(new StandardResponse(StatusResponse.SUCCESS));
        });

        get("/users", (request, response) -> {
            response.type("application/json");

            return gsonConverter.toJson(new StandardResponse(StatusResponse.SUCCESS, gsonConverter.toJsonTree(userService.getUsers())));
        });

        get("/users/:id", (request, response) -> {
            response.type("application/json");

            return gsonConverter.toJson(new StandardResponse(StatusResponse.SUCCESS, gsonConverter.toJsonTree(userService.getUser(request.params(":id")))));
        });

        put("/users/:id", (request, response) -> {
            response.type("application/json");

            User toEdit = gsonConverter.fromJson(request.body(), User.class);
            User editedUser = userService.editUser(toEdit);

            if (editedUser != null) {
                return gsonConverter.toJson(new StandardResponse(StatusResponse.SUCCESS, gsonConverter.toJsonTree(editedUser)));
            } else {
                return gsonConverter.toJson(new StandardResponse(StatusResponse.ERROR, gsonConverter.toJson("User not found or error in edit")));
            }
        });

        delete("/users/:id", (request, response) -> {
            response.type("application/json");

            userService.deleteUser(request.params(":id"));
            return gsonConverter.toJson(new StandardResponse(StatusResponse.SUCCESS, "user deleted"));
        });

        options("/users/:id", (request, response) -> {
            response.type("application/json");

            return gsonConverter.toJson(new StandardResponse(StatusResponse.SUCCESS, (userService.userExist(request.params(":id"))) ? "User exists" : "User does not exists"));
        });

    }

}
