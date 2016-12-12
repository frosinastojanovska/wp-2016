package mk.ukim.finki.wp.persistence.impl;

import mk.ukim.finki.wp.model.Group;
import mk.ukim.finki.wp.persistence.IGroupRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.List;

/**
 * Created by Frosina on 12.12.2016.
 */
@Repository
public class GroupRepository implements IGroupRepository {

    @PersistenceContext(name = "wp")
    private EntityManager entityManager;

    public List<Group> findAll(){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Group> query = cb.createQuery(Group.class);
        Root<Group> from = query.from(Group.class);
        query.select(from);
        TypedQuery<Group> q = entityManager.createQuery(query);
        return q.getResultList();
    }
    public Group findById(Integer id){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Group> query = cb.createQuery(Group.class);
        Root<Group> from = query.from(Group.class);
        query.select(from);
        query.select(from).where(cb.equal(from.get(Group.FIELDS.ID.toString()), id));
        TypedQuery<Group> q = entityManager.createQuery(query);
        q.setParameter(id, id);
        return q.getSingleResult();
    }
    @Transactional
    public Group save(Group entity){
        entityManager.persist(entity);
        entityManager.flush();
        return entity;
    }
    @Transactional
    public void update(Integer id, Group entity){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaUpdate<Group> update = cb.createCriteriaUpdate(Group.class);
        Root<Group> from = update.from(Group.class);
        update.set(Group.FIELDS.NAME.toString(), entity.getName());
        update.set(Group.FIELDS.CAPACITY.toString(), entity.getCapacity());
        update.set(Group.FIELDS.NO_EXERCISE.toString(), entity.getNoExercise());
        update.where(cb.equal(from.get(Group.FIELDS.ID.toString()),id));

        entityManager.createQuery(update).executeUpdate();
    }
    @Transactional
    public void delete(Integer id){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaDelete<Group> delete = cb.createCriteriaDelete(Group.class);
        Root<Group> from = delete.from(Group.class);

        delete.where(cb.equal(from.get(Group.FIELDS.ID.toString()), id));

        entityManager.createQuery(delete).executeUpdate();
    }
}
