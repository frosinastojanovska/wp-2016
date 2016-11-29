package mk.ukim.finki.wp.service;

import mk.ukim.finki.wp.model.Group;

import java.util.List;

/**
 * Created by Frosina on 28.11.2016.
 */
public interface IGroupService {
    List<Group> findAll();
    Group findById(Long id);
    void save(Group entity);
    void update(Long id, Group entity);
    void delete(Long id);
}
