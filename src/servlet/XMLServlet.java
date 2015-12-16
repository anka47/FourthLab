package servlet;

import bean.statefull.ActionBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Den on 14.10.15.
 */
@WebServlet(name = "XMLServlet", urlPatterns = "/result.xml")
public class XMLServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/xml;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        try {
            ActionBean actionBean = (ActionBean) req.getSession().getAttribute("actionBean");
            if (actionBean != null) {
                JAXBContext context = JAXBContext.newInstance(ActionBean.class);
                Marshaller marshaller = context.createMarshaller();
                marshaller.marshal(actionBean, out);
            } else {
                out.println("<error>Нет объекта для создания XML</error>");
            }
        } catch (JAXBException ex) {
            out.println("<error>При создании XML возникла ошибка" + ex.getMessage() + "</error>");
        } finally {
            out.close();
        }
    }
}
