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
    private static Map<Integer,Group> idToGroup = new HashMap<Integer, Group>();

    public List<Group> findAll(){
        return new ArrayList<Group>(idToGroup.values());
    }
    public Group findById(Integer id){
        return idToGroup.get(id);
    }
    public void save(Group entity){
        entity.setId(new Random().nextInt(Integer.MAX_VALUE));
        idToGroup.put(entity.getId(), entity);
    }
    public void update(Integer id, Group entity){
        idToGroup.remove(id);
        idToGroup.put(id, entity);
    }
    public void delete(Integer id){
        idToGroup.remove(id);
    }
}
