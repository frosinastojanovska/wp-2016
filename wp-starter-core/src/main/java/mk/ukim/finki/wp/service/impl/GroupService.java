package mk.ukim.finki.wp.service.impl;

import mk.ukim.finki.wp.model.Group;
import mk.ukim.finki.wp.persistence.IGroupRepository;
import mk.ukim.finki.wp.service.IGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by Frosina on 28.11.2016.
 */
@Service
public class GroupService implements IGroupService{

    private IGroupRepository repository;

    @Autowired
    public GroupService(IGroupRepository repository) {
        this.repository = repository;
    }

    public List<Group> findAll(){
        return repository.findAll();
    }
    public Group findById(Integer id){
        return repository.findById(id);
    }
    public Group save(Group entity){
        return repository.save(entity);
    }
    public void update(Integer id, Group entity){
        repository.update(id, entity);
    }
    public void delete(Integer id){
        repository.delete(id);
    }
}
