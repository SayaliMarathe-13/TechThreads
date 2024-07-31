package Dao;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import Model.User;

@Component
public class UserDao {

    private final HibernateTemplate hibernateTemplate;

    @Autowired
    public UserDao(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Transactional
    public String insert(User user) {
        String id = (String) this.hibernateTemplate.save(user);
        return id;
    }

    @Transactional
    public User getAccount(String contact) {
        return this.hibernateTemplate.get(User.class, contact); 
    }
}
