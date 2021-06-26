
package model.dao;

import java.util.List;
import model.pojo.Pasien;
import model.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

public class PasienDao {
    public static List<Pasien> layDS() {
        List<Pasien> lst = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            
            String hql = "from Pasien";
            Query query = session.createQuery(hql);
            lst = query.list();
            
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lst;
    }
}
