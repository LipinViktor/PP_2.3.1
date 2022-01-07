package viktor.dao;

import org.springframework.stereotype.Repository;
import viktor.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao{

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<User> findAll() {
        return em.createQuery("SELECT us FROM User us", User.class).getResultList();
    }

    @Override
    public User findById(int id) {
        return em.find(User.class, id);
    }

    @Override
    public void save(User user) {
        em.merge(user);
    }

    @Override
    public void update(int id, User user) {
        user.setId(id);
        em.merge(user);
    }

    @Override
    public void delete(int id) {
        em.createQuery("DELETE FROM User WHERE id=:id").setParameter("id", id).executeUpdate();
    }
}
