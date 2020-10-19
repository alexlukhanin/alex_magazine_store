package ua.uz.alex.utils;

import java.io.PrintWriter;

@Deprecated
public class PrintHTML {


    public static void printHTMLBackWithBlock(PrintWriter out, String blockHTML) {

        out.println("<script type=\"text/javascript\">");
        out.println("document.write(" + blockHTML + ");");
        out.println("document.write('<a href=\"' + document.referrer + '\">Go Back</a>');");
        out.println("</script>");
    }

}
