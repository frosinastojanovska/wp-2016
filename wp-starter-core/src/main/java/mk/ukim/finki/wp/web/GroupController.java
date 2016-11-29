package mk.ukim.finki.wp.web;

import mk.ukim.finki.wp.model.Group;
import mk.ukim.finki.wp.service.IGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Frosina on 28.11.2016.
 */

@RestController
@RequestMapping(value = "/api/groups", produces = "application/json")
public class GroupController {

    @Autowired
    private IGroupService groupService;

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody List<Group> findAll(){
        return groupService.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public Group findById(@PathVariable Long id){
        return groupService.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void save(@RequestBody Group group){
        groupService.save(group);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public void update(@PathVariable Long id, @RequestBody Group group){
        groupService.update(id, group);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void delete(@PathVariable Long id){
        groupService.delete(id);
    }


}
