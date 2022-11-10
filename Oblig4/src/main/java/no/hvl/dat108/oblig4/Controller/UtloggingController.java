package no.hvl.dat108.oblig4.Controller;

import no.hvl.dat108.oblig4.util.LoginUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping ("${app.url.loggut}")
public class UtloggingController {

    @PostMapping
    public String utlogg (HttpSession session){
        LoginUtil.loggUtBruker(session);
        return "redirect:" + "innlogging";
    }
}
