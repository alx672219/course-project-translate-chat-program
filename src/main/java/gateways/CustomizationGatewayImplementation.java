package gateways;

import entities.User;
import profile_customization_use_case.CustomizationGateway;
import services.DBService;

public class CustomizationGatewayImplementation implements CustomizationGateway {
    DBService dbService;

    public CustomizationGatewayImplementation() {
        this.dbService = new DBService();
    }

    @Override
    public void updateDefaultLang(User user, String default_lang) {
        dbService.updateDefaultLang(user, default_lang);
    }

    @Override
    public void updateName(User user, String name) {
        dbService.updateName(user, name);
    }

    @Override
    public void updatePassword(User user, String password) { dbService.updatePassword(user, password); }

    @Override
    public boolean existName(User user) { return dbService.existName(user); }
}
