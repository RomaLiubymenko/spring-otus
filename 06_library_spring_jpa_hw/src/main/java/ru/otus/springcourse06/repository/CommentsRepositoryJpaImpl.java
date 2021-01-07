package ru.otus.springcourse06.repository;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import ru.otus.springcourse06.domain.Comment;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
@Scope(proxyMode = ScopedProxyMode.INTERFACES)
public class CommentsRepositoryJpaImpl implements CommentsRepository {

    private final EntityManager entityManager;

    public CommentsRepositoryJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void insert(Comment comment) {
        entityManager.persist(comment);
    }

    @Override
    public List<Comment> getAll() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Comment> commentCriteria = criteriaBuilder.createQuery(Comment.class);
        Root<Comment> commentRoot = commentCriteria.from(Comment.class);
        TypedQuery<Comment> commentTypedQuery = entityManager.createQuery(commentCriteria);
        return  commentTypedQuery.getResultList();
    }

    @Override
    public Comment getById(int id) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Comment> commentCriteria = criteriaBuilder.createQuery(Comment.class);
        Root<Comment> model = commentCriteria.from(Comment.class);
        commentCriteria.where(criteriaBuilder.equal(model.get("idComment"), id));
        TypedQuery<Comment> commentTypedQuery = entityManager.createQuery(commentCriteria);
        return commentTypedQuery.getSingleResult();
    }
}
