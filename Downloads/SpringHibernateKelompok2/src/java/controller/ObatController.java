
package controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.dao.ObatDao;
import model.pojo.Obat;
import org.hibernate.HibernateException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class ObatController implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        ModelAndView mv = new ModelAndView("Obat");
        try {
            List<Obat> lst = ObatDao.layDS();
            mv.addObject("dataobat", lst);
            
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return mv;
    }
    
}
