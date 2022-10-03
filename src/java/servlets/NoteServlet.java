/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Note;

/**
 *
 * @author Komaldeep Kaur Virk
 */

public class NoteServlet extends HttpServlet {    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // For displaying the form in the view or edit mode.        
       
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        BufferedReader br = new BufferedReader(new FileReader(new File(path)));        
        String title = br.readLine();
        String contents = br.readLine();
        
        if (title == null || contents == null) {
            request.setAttribute("title", title);
            request.setAttribute("contents", contents);
            request.setAttribute("message", "Title and contents cannot be null.");
            getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp")
                    .forward(request, response);            
            return;           
        }
        
        Note note = new Note(title, contents);
        request.setAttribute("note", note);
        
        if (request.getParameter("edit") != null) {
            getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp")
                .forward(request, response);
        }
        else {
            getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp")
                .forward(request, response);
        }
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // For saving the form from the edit mode.
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        
        String title = request.getParameter("title");
        String contents = request.getParameter("contents");
        
        if (title == null || contents == null) {
            request.setAttribute("title", title);
            request.setAttribute("contents", contents);
            request.setAttribute("message", "Title and contents cannot be null.");
            getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp")
                    .forward(request, response);            
            return;           
        }
        
        Note note = new Note(title, contents);        
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path, false))); 
        pw.println(note.getTitle());
        pw.println(note.getContents());
        pw.close();
        
        getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp")
                    .forward(request, response);       
    }
}