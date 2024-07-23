package Epic.fusiongames.security;


import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.MethodSecurityExpressionOperations;
import org.springframework.stereotype.Component;

@Component
public class Authorizer {

    public boolean canAddGame (MethodSecurityExpressionOperations methodSecurityExpressionOperations){
        return methodSecurityExpressionOperations.hasAuthority("games:add");
    }

}
