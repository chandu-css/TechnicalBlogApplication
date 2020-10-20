package technical.repository;

import org.springframework.stereotype.Repository;
import technical.model.User;

import javax.persistence.*;

@Repository
public class UserRepository {

    @PersistenceUnit(unitName = "techblog")
    private EntityManagerFactory emf;

    public void registerUser(User newUser) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(newUser);
            transaction.commit();
        }catch (Exception ex){
            transaction.rollback();
        }

    }

    public User checkUser(String userName, String password){
        try {
            EntityManager em = emf.createEntityManager();
            TypedQuery<User> query = em.createQuery("SELECT u from User u where u.userName = :username AND u.password = :password", User.class);
            query.setParameter("username", userName);
            query.setParameter("password", password);

            return query.getSingleResult();
        }
        catch (Exception ex){
            return null;
        }
    }
}
