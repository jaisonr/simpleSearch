package servlets;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import processData.MakeJson;
public class SearchServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SearchServelet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String albumTitle=request.getParameter("albumTitle");
		String callback=request.getParameter("callback");
			try {
				String json=MakeJson.generateJsonData(albumTitle);
				response.setContentType("text/html");
				if(callback==null){					
					response.getWriter().write(json);
				}else{
					
					response.getWriter().write(callback+"("+json+")");
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}
		
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
	

}
