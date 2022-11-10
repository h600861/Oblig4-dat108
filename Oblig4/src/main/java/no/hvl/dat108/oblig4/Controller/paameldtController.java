package no.hvl.dat108.oblig4.Controller;

import no.hvl.dat108.oblig4.util.LoginUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("${app.url.paameldt}")
public class paameldtController {

         @Value("${app.message.feilmedling}")
        private String feilMelding;


    @GetMapping
    public String visPaameldt(HttpSession session, RedirectAttributes ra) {
        if (!LoginUtil.erBrukerInnlogget(session)) {
            System.err.println("Prøv igjen");
            ra.addFlashAttribute("error", feilMelding);
            return "redirect:" + "paamelding";
        } else
            return "paameldt";
    }
}