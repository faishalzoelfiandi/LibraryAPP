
package model.dao;

import java.util.List;
import model.pojo.Obat;
import model.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

public class ObatDao {
    public static List<Obat> layDS() {
        List<Obat> lst = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            
            String hql = "from Obat";
            Query query = session.createQuery(hql);
            lst = query.list();
            
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lst;
    }
}
