import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Calculator extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            Integer t1 = Integer.parseInt(request.getParameter("t1"));
            Integer t2 = Integer.parseInt(request.getParameter("t2"));
            String toantu = request.getParameter("operator");
            Integer ketqua = 0;
            switch(toantu) {
                case "Cong":
                    ketqua = t1+t2;
                    break;
                case "Tru":
                    ketqua = t1-t2;
                    break;
                 case "Nhan":
                    ketqua = t1*t2;
                    break;
                case "Chia":
                    ketqua = t1/t2;
                    break;
            }
                    
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Calculator</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<p>Ket qua: " + toantu + "</p>");
            out.println("<p>Ket qua: " + ketqua + "</p>");
            
            out.println("<input type=" + "'button'" + "value=" + "'Back'" + "onclick=" + "'javascript:history.back()'" + ">");
            out.println("<input type=" + "'button'" + "value=" + "'Close'" + "onclick=" + "'return window.close()'" + ">");
            out.println("</body>");
            out.println("</html>");

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
