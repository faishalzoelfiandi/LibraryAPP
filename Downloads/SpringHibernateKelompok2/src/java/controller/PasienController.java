
package controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.dao.PasienDao;
import model.pojo.Pasien;
import org.hibernate.HibernateException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class PasienController implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        ModelAndView mv = new ModelAndView("Pasien");
        try {
            List<Pasien> lst = PasienDao.layDS();
            mv.addObject("datapasien", lst);
            
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return mv;
    }
    
}
