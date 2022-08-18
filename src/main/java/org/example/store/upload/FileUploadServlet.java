package org.example.store.upload;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

@WebServlet(name = "FileUploadServlet", urlPatterns = {"/fileuploadservlet"})
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 10,
        maxRequestSize = 1024 * 1024 * 100,
        location = "/tmp"
)
public class FileUploadServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        final Collection<Part> parts = rq.getParts();
        final PrintWriter writer = rs.getWriter();
        if (parts.isEmpty()) {
            writer.print("No parts provided.");
        } else {
            for (Part part : parts) {
                final String submittedFileName = part.getSubmittedFileName();
                final String partName = part.getName();
                if (submittedFileName.isBlank()) {
                    writer.printf("File name is empty for %s.", partName);
                } else {
                    writer.printf(" getSubmittedFileName: %s, ", submittedFileName);
                    writer.printf(" getName: %s, ", partName);
                    part.write(submittedFileName);
                    writer.printf("The file %s uploaded sucessfully.", submittedFileName);
                }
            }
        }
        writer.close();
    }
}
