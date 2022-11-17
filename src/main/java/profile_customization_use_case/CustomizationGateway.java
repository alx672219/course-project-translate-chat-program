package profile_customization_use_case;

import entities.User;
import services.DBService;

public class CustomizationGateway {

    DBService dbService;

    public CustomizationGateway() {
        dbService = new DBService();
    }

    public void updateDefaultLang(User user, String default_lang) {
        dbService.updateDefaultLang(user, default_lang);
    }

    public void updateName(User user, String name) {
        dbService.updateName(user, name);
    }

    public void updatePassword(User user, String password) {
        dbService.updatePassword(user, password);
    }
}
