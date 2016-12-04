package mk.ukim.finki.wp.service;

import mk.ukim.finki.wp.model.Group;

import java.util.List;

/**
 * Created by Frosina on 28.11.2016.
 */
public interface IGroupService {
    List<Group> findAll();
    Group findById(Integer id);
    Group save(Group entity);
    void update(Integer id, Group entity);
    void delete(Integer id);
}
