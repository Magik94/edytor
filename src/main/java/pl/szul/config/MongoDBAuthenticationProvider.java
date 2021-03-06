package pl.szul.config;

import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.security.authentication.InternalAuthenticationServiceException;  
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;  
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;  
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;  
import org.springframework.stereotype.Service;
import pl.szul.entity.UserEnity;
import pl.szul.repository.UserRepository;

@Service
public class MongoDBAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

    @Autowired
    private UserRepository userRepository;

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
    }

    @Override
    protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
        UserDetails loadedUser;

        try {
            UserEnity userEnity = userRepository.findByUsername(username);
            loadedUser = new User(userEnity.getUsername(), userEnity.getPassword(), AuthorityUtils.createAuthorityList(userEnity.getRoles().toArray(new String[0])));
        } catch (Exception repositoryProblem) {
            throw new InternalAuthenticationServiceException(repositoryProblem.getMessage(), repositoryProblem);
        }

        if (loadedUser == null) {
            throw new InternalAuthenticationServiceException(
                    "UserDetailsService returned null which is an interface contract violation");
        }
        return loadedUser;
    }
}