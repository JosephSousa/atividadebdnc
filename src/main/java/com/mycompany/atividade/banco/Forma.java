package com.mycompany.atividade.banco;

import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.io.ParseException;
import com.vividsolutions.jts.io.WKTReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @brief Classe NewClass
 * @author Joseph Sousa
 * @mail jsantos.te@gmail.com
 * @date 20/11/2017
 */
public class Forma implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        WKTReader reader = new WKTReader();
        
        String rx = request.getParameter("rx");
        String ry = request.getParameter("ry");
        String cx = request.getParameter("cx");
        String cy = request.getParameter("cy");
        String rx1 = request.getParameter("rx1");
        String ry1 = request.getParameter("ry1");
        String cx1 = request.getParameter("cx1");
        String cy1 = request.getParameter("cy1");

        try {
            Geometry geometria = reader.read("POLYGON (("+rx+","+ry+","+cx+","+cy+"))");
            Geometry geometria2 = reader.read("POLYGON (("+rx1+","+ry1+","+cx1+","+cy1+"))");
            System.out.println("Within: " + geometria.within(geometria2));
            System.out.println("Covers: " + geometria.covers(geometria2));
            System.out.println("Touches: " + geometria.touches(geometria2));
            System.out.println("Equals: " + geometria.equals(geometria2));
            System.out.println("Disjoint: " + geometria.disjoint(geometria2));
            System.out.println("Intersects: " + geometria.intersects(geometria2));
            System.out.println("Crosses: " + geometria.crosses(geometria2));
            System.out.println("Contains: " + geometria.contains(geometria2));
            System.out.println("Overlaps: " + geometria.overlaps(geometria2));
            System.out.println("Coverdedby: " + geometria.coveredBy(geometria2));

            System.out.println("Within: " + geometria2.within(geometria));
            System.out.println("Covers: " + geometria2.covers(geometria));
            System.out.println("Touches: " + geometria2.touches(geometria));
            System.out.println("Equals: " + geometria2.equals(geometria));
            System.out.println("Disjoint: " + geometria2.disjoint(geometria));
            System.out.println("Intersects: " + geometria2.intersects(geometria));
            System.out.println("Crosses: " + geometria2.crosses(geometria));
            System.out.println("Contains: " + geometria2.contains(geometria));
            System.out.println("Overlaps: " + geometria2.overlaps(geometria));
            System.out.println("Coverdedby: " + geometria2.coveredBy(geometria));
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("index.html");
            dispatcher.forward(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(Forma.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
