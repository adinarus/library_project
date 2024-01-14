package com.library.library_project.ejb;

import com.library.library_project.dto.DtoConverter;
import com.library.library_project.dto.UserDto;
import com.library.library_project.entities.User;
import com.library.library_project.entities.UserGroup;
import jakarta.ejb.EJBException;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Stateless
public class UserBean {
    private static final Logger LOG = Logger.getLogger(UserBean.class.getName());

    @Inject
    PasswordBean passwordBean;

    @PersistenceContext
    EntityManager entityManager;

    public List<UserDto> findAllUsers(){
        LOG.info("findAllUsers");
        try{
            TypedQuery<User> typedQuery=entityManager.createQuery("SELECT user FROM User user",User.class);
            List<User> users=typedQuery.getResultList();
            return copyUsersToDto(users);
        }
        catch (Exception ex) {
            throw new EJBException(ex);
        }
    }

    public List<UserDto> copyUsersToDto(List<User> users){
        DtoConverter converter=new DtoConverter();
        return converter.toDtoUsers(users);
    }

    public UserDto findById(int userId) {
        User user = entityManager.find(User.class, userId);
        return new UserDto(user.getId(),user.getFirstname(), user.getLastname(), user.getUsername(), user.getEmail());
    }

    public void createUser(String firstname, String lastname, String username, String email, String password){
        LOG.info("createUser");

        String usergroup = "grup2";

        User user= new User();
        user.setFirstname(firstname);
        user.setLastname(lastname);
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(passwordBean.convertToSha256(password));

        try {
            entityManager.persist(user);
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Error during user creation", e);
            throw new EJBException("Error during user creation", e);
        }

        assignGroupsToUser(username,usergroup);
    }

    private void assignGroupsToUser(String username, String usergroup){
        LOG.info("assignGroupsToUser");

        UserGroup userGroup = new UserGroup();
        userGroup.setUsername(username);
        userGroup.setUserGroup(usergroup);
        entityManager.persist(userGroup);
    }

    public void deleteUser(int userId) {
        LOG.info("deleteUser");

        User user = entityManager.find(User.class, userId);
        if (user != null) {
            entityManager.remove(user);
        } else {
            LOG.log(Level.WARNING, "User with id {0} not found", userId);
        }
    }
}
