package controladores;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelos.BaseDatos;

@WebServlet(name = "NewServlet", urlPatterns = {"/NewServlet"})
public class NewServlet extends HttpServlet {
    BaseDatos bd = new BaseDatos();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            switch(request.getParameter("control")){
                case "getCategoria": response.getWriter().write(bd.getCategoria().toString());break;
                case "getPartidas": response.getWriter().write(bd.getPartidas().toString());break;
                case "getTableCategoria": response.getWriter().write(bd.getTableCategoria().toString());break;
                case "getTableJugador": response.getWriter().write(bd.getTableJugador().toString());break;
                case "getTablePartida": response.getWriter().write(bd.getTablePartida().toString());break;
                case "getDataPartida" : response.getWriter().write((bd.getDataPartida(request.getParameter("id"))).toString());break;
                case "getDataCategoria" : response.getWriter().write((bd.getDataCategoria(request.getParameter("id"))).toString());break;
                case "getDataJugador" : response.getWriter().write((bd.getDataJugador(request.getParameter("id"))).toString());break;
            }
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            switch(request.getParameter("control")){
                case "selectPartida": bd.selectPartida(request.getParameter("id_partida"),request.getParameter("id"));break;
                case "deleteJugador": bd.deleteJugador(request.getParameter("id"));break;
                case "deletePartida": bd.deletePartida(request.getParameter("id"));break;
                case "deleteCategoria": bd.deleteCategoria(request.getParameter("id"));break;
                case "setCategoria": bd.setCategoria(request.getParameter("nombre"), request.getParameter("descripcion"));break;
                case "setPartida": bd.setPartida(request.getParameter("nombre"), request.getParameter("capacidad"),request.getParameter("tipo"));break;
                case "setJugador": bd.setJugador(request.getParameter("nombre"), request.getParameter("edad"), request.getParameter("id_categoria"),request.getParameter("id_partida"));break;
                case "updateJugador" : bd.updateJugador(request.getParameter("nombre"), request.getParameter("edad"), request.getParameter("id_categoria"),request.getParameter("id"));break;
                case "updatePartida": bd.updatePartida(request.getParameter("nombre"), request.getParameter("capacidad"),request.getParameter("tipo"),request.getParameter("id"));break;
                case "updateCategoria": bd.updateCategoria(request.getParameter("nombre"), request.getParameter("descripcion"),request.getParameter("id"));break;
            }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}