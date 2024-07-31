package Dao;

import Model.Course;
import Model.Threads;
import Model.User;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
public class ThreadsDao {

    private final HibernateTemplate hibernateTemplate;

    @Autowired
    public ThreadsDao(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Transactional
    public Long insert(Threads thread) {
        return (Long) this.hibernateTemplate.save(thread);
    }

    @Transactional
    public Threads getThread(Long id) {
        return this.hibernateTemplate.get(Threads.class, id);
    }
    public List<Threads> loadAll() {

    	return (List<Threads>) this.hibernateTemplate.loadAll(Threads.class);

    	}
    @Transactional
    public Long insert(Thread thread) {
        Long id = (Long) this.hibernateTemplate.save(thread);
        System.out.println("Thread added");
        return id;
    }
    @Transactional
    public void updateThread(Threads thread) {
        this.hibernateTemplate.update(thread);
    }

    @Transactional
    public boolean deleteThreadById(Long id) {
        Threads thread = this.hibernateTemplate.get(Threads.class, id);
        if (thread != null) {
            this.hibernateTemplate.delete(thread);
            return true;
        }
        else{
        	return false;
        }
    }
}
