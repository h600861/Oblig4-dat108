package no.hvl.dat108.oblig4.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginUtil {
    public static void loggUtBruker(HttpSession session) {
        session.invalidate();
    }

    public static void loggInnBruker(HttpSession session, int maksInaktivitet) {
       if (!erBrukerInnlogget(session)){
           session.setMaxInactiveInterval(maksInaktivitet);
       }
    }

    public static boolean erBrukerInnlogget(HttpSession session) {
        return session != null && session.getAttribute("bruker") != null;
    }

}
