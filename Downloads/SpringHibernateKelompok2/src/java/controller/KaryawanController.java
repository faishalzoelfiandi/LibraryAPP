
package controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.dao.KaryawanDao;
import model.pojo.Karyawan;
import org.hibernate.HibernateException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class KaryawanController implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        ModelAndView mv = new ModelAndView("Karyawan");
        try {
            List<Karyawan> lst = KaryawanDao.layDS();
            mv.addObject("datakaryawan", lst);
            
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return mv;
    }
    
}
