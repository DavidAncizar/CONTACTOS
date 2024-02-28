/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import com.mycompany.directorio.Contacto;
import com.mycompany.directorio.controladorContacto;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author danie
 */

@WebServlet(name = "SvEliminarContacto", urlPatterns = {"/SvEliminarContacto"})
public class SvEliminarContacto extends HttpServlet {

    private controladorContacto contacto;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

 
   @Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    // No es necesario llamar a processRequest(request, response) aquí

    System.out.println("Estoy en el servlet eliminar");
    String nombre = request.getParameter("nombre");

    // Utiliza el controlador de contactos para eliminar el contacto por nombre
    controlador.eliminarContactoPorNombre(nombre);

    // Obtén la lista actualizada de contactos después de eliminar
    ServletContext context = getServletContext();
    ArrayList<Contacto> misContactos = controlador.obtenerContactos(context);

    // Establece la lista actualizada como atributo de solicitud
    request.setAttribute("contactos", misContactos);

    // Redirige de vuelta a la página principal
    request.getRequestDispatcher("index.jsp").forward(request, response);
}

    private static class controlador {

    private static void eliminarContactoPorNombre(String nombre) {
        // Lógica para eliminar un contacto por nombre
        // Puedes llamar al método correspondiente en controladorContacto si es necesario
    }

    private static ArrayList<Contacto> obtenerContactos(ServletContext context) {
        // Lógica para obtener la lista de contactos
        // Puedes llamar al método correspondiente en controladorContacto si es necesario
        return new ArrayList<Contacto>(); // Devuelve una lista vacía por ahora
    }
}

}

   
    