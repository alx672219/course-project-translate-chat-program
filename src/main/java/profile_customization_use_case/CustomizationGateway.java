package profile_customization_use_case;

import entities.User;

import java.util.concurrent.ExecutionException;

public interface CustomizationGateway {

    void updateDefaultLang(User user, String default_lang);

    void updateName(User user, String name);

    void updatePassword(User user, String password) throws ExecutionException, InterruptedException;

    boolean existName(User user);
}
