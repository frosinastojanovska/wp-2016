package mk.ukim.finki.wp.service.impl;

import mk.ukim.finki.wp.model.Group;
import mk.ukim.finki.wp.service.IGroupService;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by Frosina on 28.11.2016.
 */
@Service
public class GroupServiceImpl implements IGroupService{
    private static Map<Long,Group> idToGroup = new HashMap<Long, Group>();

    public List<Group> findAll(){ return new ArrayList<Group>(idToGroup.values()); }
    public Group findById(Long id){
        return idToGroup.get(id);
    }
    public void save(Group entity){
        entity.setId(new Random().nextLong());
        idToGroup.put(entity.getId(), entity);
    }
    public void update(Long id, Group entity){
        idToGroup.remove(id);
        idToGroup.put(id, entity);
    }
    public void delete(Long id){ idToGroup.remove(id); }
}
