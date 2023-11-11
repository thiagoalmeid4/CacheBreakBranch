package cache.io;

import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Thiago
 */
public class Cache {
    
    private final String nameCache = "v@sc0-c@ch3";
    
    private EntityManager getConnection() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cacheBreakBranch");
        return emf.createEntityManager();
    }
       
    public static void put(Object key, Object value){
        EntityManager em = getConnection();
        DataCache dc = em.find(DataCache.class, nameCache);
        em.getTransaction().begin();
        if(dc!=null){
            dc.getDatas().put(key, value);
            em.merge(dc);
        }else{
            Map<Object, Object> datas = new HashMap<>();
            datas.put(key, value);
            em.persist(new DataCache(nameCache, datas));
        }
        em.getTransaction().commit();
    }
    
    public static Object get(Object key) throws Exception{
        EntityManager em = getConnection();
        DataCache dc = em.find(DataCache.class, nameCache);
        if(dc!=null && dc.getDatas()!=null){
            return dc.getDatas().get(key);
        }else{
            throw new Exception("Informação em cache não encontrado");
        }
    }
    
    public static void clean(Object key) throws Exception{
        EntityManager em = getConnection();
        DataCache dc = em.find(DataCache.class, nameCache);
        if(dc!=null && dc.getDatas()!=null){
            dc.getDatas().remove(key);
            em.getTransaction().begin();
            em.merge(dc);
            em.getTransaction().commit();
        }else{
            throw new Exception("Informação em cache não encontrado");
        }
    }
}
