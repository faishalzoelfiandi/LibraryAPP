
package model.dao;

import java.util.List;
import model.pojo.Karyawan;
import model.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

public class KaryawanDao {
    public static List<Karyawan> layDS() {
        List<Karyawan> lst = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            
            String hql = "from Karyawan";
            Query query = session.createQuery(hql);
            lst = query.list();
            
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lst;
    }
}
