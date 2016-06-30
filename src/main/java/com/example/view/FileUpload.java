package com.example.view;

import javax.annotation.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.Part;
import java.io.IOException;


@ManagedBean
@SessionScoped
public class FileUpload {

    private Part file1;
    private Part file2;

    public Part getFile1() {
        return file1;
    }

    public void setFile1(Part file1) {
        this.file1 = file1;
    }

    public Part getFile2() {
        return file2;
    }

    public void setFile2(Part file2) {
        this.file2 = file2;
    }

    public String upload() throws IOException {
//        file1.write("/home/bcc/Downloads" + getFilename(file1) );
//        file2.write("/home/bcc/Downloads" + getFilename(file2) );

        file1.write("/home/bcc/Downloads"+getFilename(file1));
//        file2.write("/home/bcc/Downloads"+getFilename(file2));

        return "success";
    }

    private static String getFilename(Part part) {

        if (part != null){
            for (String cd : part.getHeader("content-disposition").split(";")) {
                if (cd.trim().startsWith("filename")) {
                    String filename = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
                    return filename.substring(filename.lastIndexOf('/') + 1).substring(filename.lastIndexOf('\\') + 1); // MSIE fix.
                }
            }
        }
        return null;
    }
}
