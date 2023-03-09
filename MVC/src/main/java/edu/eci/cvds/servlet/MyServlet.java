package edu.eci.cvds.servlet;

import java.io.IOException;
import java.io.Writer;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.eci.cvds.servlet.model.Todo;
@WebServlet(
urlPatterns = "/myServlet"
)
public class MyServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Optional<String> optId = Optional.ofNullable(req.getParameter("id"));
		try {
			int id;
			if (optId.isPresent() && !optId.get().isEmpty())id = Integer.parseInt(optId.get());	
			else throw new NumberFormatException();	
			Writer responseWriter = resp.getWriter();
			if (id > 0 && id < 201) {
				Todo todo = Service.getTodo(id);
				resp.setStatus(HttpServletResponse.SC_OK);
				List<Todo> list = new ArrayList<>();
				list.add(todo);
				responseWriter.write(Service.todosToHTMLTable(list));
			}
			else {
				resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
				responseWriter.write(notFound());
			}
			responseWriter.flush();
		} catch (NumberFormatException e) {
			resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		} catch (MalformedURLException e) {
			resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		} catch (Exception e) {
			resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Optional<String> optId = Optional.ofNullable(req.getParameter("id"));
		try {
			int id;
			if (optId.isPresent() && !optId.get().isEmpty())id = Integer.parseInt(optId.get());	
			else throw new NumberFormatException();	
			Writer responseWriter = resp.getWriter();
			if (id > 0 && id < 201) {
				Todo todo = Service.getTodo(id);
				resp.setStatus(HttpServletResponse.SC_OK);
				List<Todo> list = new ArrayList<>();
				list.add(todo);
				responseWriter.write(Service.todosToHTMLTable(list));
			}
			else {
				resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
				responseWriter.write(notFound());
			}
			responseWriter.flush();
		} catch (NumberFormatException e) {
			resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		} catch (MalformedURLException e) {
			resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		} catch (Exception e) {
			resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}	
	}
	
	
	public static String notFound() {
		return new StringBuilder("<head>")
		.append("<title>Elemento no encontrado</title>")
		.append("</head>")
		.append("<body>")
		.append("<h1>El elemento no fue encontrado</h1>")
		.append("<p>Lo sentimos, no existe ningún elemento con el identificador dado.</p>")
		.append("</body>")
		.toString();
	}
}

