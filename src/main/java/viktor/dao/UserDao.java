package viktor.dao;

import viktor.model.User;

import java.util.List;

public interface UserDao {
    List<User> findAll();

    User findById(long id);

    void save(User user);

    void update(long id, User user);

    void delete(long id);

}
