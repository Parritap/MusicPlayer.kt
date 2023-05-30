package model.logic;

import model.logic.Exceptions.FieldException;
import model.logic.Exceptions.ModelException;
import model.logic.data.User;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class UserHandler {

    Singleton singleton = Singleton.getInstance();
    private static final ArrayList<User> userList = Singleton.getInstance().getUserList();


    public static boolean userExisits(String email) {
        for (User user : userList) {
            if (user.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    public static User createUser(String... args) throws FieldException, ModelException {

        //Verificamos que los argumentos no sean nulos o vacios. No debe haber ningun usuario sin alguno de estos datos.
        for (String str : args) {
            if (str == null || str.equals("")) throw new FieldException("Existe algún campo vacío o nulo");
        }
        //Verificamos que el usuario no exista meidante su email.
        if (userExisits(args[1])) throw new ModelException("El usuario ya existe");

        User user = new User();
        user.setName(args[0]);
        user.setEmail(args[1]);
        user.setPassword(args[2]);
        user.setNickname(args[3]);
        userList.add(user);
        return user;
    }


}
