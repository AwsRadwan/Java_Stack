package com.aws.belt.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.aws.belt.models.User;
import com.aws.belt.services.UserService;

@Component
public class UserValidator implements Validator {
	
	private UserService userService;
	
	public UserValidator(UserService userService) {
		this.userService = userService;
	}
	
	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = 
    	    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    
    // 1
    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }
    
    // 2
    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        
        Matcher validEmail = VALID_EMAIL_ADDRESS_REGEX .matcher(user.getEmail());
        
        if (!user.getPasswordConfirmation().equals(user.getPassword())) {
            // 3
            errors.rejectValue("passwordConfirmation", "Match");
        }
        
//        if (!validEmail.find()) {
//        	errors.rejectValue("email", "EmailFormat");
//        }
        

        
    }
}
