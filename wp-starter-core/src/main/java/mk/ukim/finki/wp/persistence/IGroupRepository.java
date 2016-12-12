package mk.ukim.finki.wp.persistence;

import mk.ukim.finki.wp.model.Group;

import java.util.List;

/**
 * Created by Frosina on 12.12.2016.
 */
public interface IGroupRepository {
    List<Group> findAll();
    Group findById(Integer id);
    Group save(Group entity);
    void update(Integer id, Group entity);
    void delete(Integer id);
}
