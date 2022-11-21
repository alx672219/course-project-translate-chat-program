package profile_customization_use_case;

public class CustomizationFailed extends RuntimeException{
    public CustomizationFailed(String error) {
        super(error);
    }
}
