

package com.mycompany.atividade.banco;

/**
 *
 * @author Joseph Sousa
 * @mail Jsantos.te@gmail.com
 * @Since 15/07/2017 , 18:30:56
 */
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {
    
     public void execute(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException;
}
