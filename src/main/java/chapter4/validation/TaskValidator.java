package chapter4.validation;

import java.util.concurrent.Callable;

public class TaskValidator implements Callable<String> {
    private UserValidator validator;
    private String user;
    private String password;

    public TaskValidator(UserValidator userValidator, String name, String password) {
        this.validator = userValidator;
        this.user = name;
        this.password = password;
    }

    @Override
    public String call() throws Exception {
        if (!validator.validate(user, password)) {
            System.out.printf("%s: The user has not been found\n",validator.getName());
            throw new Exception("Error validating user");
        }
        System.out.printf("%s: The user has been found\n",validator.getName());

        return validator.getName();
    }
}
