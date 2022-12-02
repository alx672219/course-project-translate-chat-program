package profile_customization_use_case;

public class CustomizationFailed extends RuntimeException{

    /**
     * Constructor for CustomizationFailed
     * @param error error message
     */
    public CustomizationFailed(String error) {
        super(error);
    }
}
