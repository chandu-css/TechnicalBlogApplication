package technical.repository;

import org.springframework.stereotype.Repository;
import technical.model.Post;
import technical.model.User;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.transaction.Transaction;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PostRepository {

    @PersistenceUnit(unitName = "techblog")
    private EntityManagerFactory emf;

    public List<Post> getAllPosts(){
        EntityManager em = emf.createEntityManager();
        TypedQuery<Post> query = em.createQuery("SELECT p from Post p", Post.class);
        List<Post> resultList = query.getResultList();

        return resultList;
    }

    public Post getLatestPost() {
        EntityManager em = emf.createEntityManager();
        Post post = em.find(Post.class, 3);
        return post;
    }

    public Post createPost(Post newPost) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(newPost);
            transaction.commit();
        }catch (Exception ex){
            transaction.rollback();
        }

        return newPost;
    }

    public Post getPost(Integer id){
        EntityManager em = emf.createEntityManager();
        Post post = em.find(Post.class, id);
        return post;
    }

    public void updatePost(Post updatePost) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.merge(updatePost);
            transaction.commit();
        }catch (Exception ex){
            transaction.rollback();
        }

    }
    public void removePost(Integer id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            Post post = em.find(Post.class, id);
            em.remove(post);
            transaction.commit();
        }catch (Exception ex){
            transaction.rollback();
        }

    }

}
