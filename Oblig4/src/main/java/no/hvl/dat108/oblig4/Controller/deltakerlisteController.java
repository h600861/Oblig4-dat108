package no.hvl.dat108.oblig4.Controller;

import no.hvl.dat108.oblig4.database.DeltagerService;
import no.hvl.dat108.oblig4.entity.Bruker;
import no.hvl.dat108.oblig4.util.LoginUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("${app.url.deltagerliste}")
public class deltakerlisteController {

    private final DeltagerService service;

    @Value("${app.message.InvalidLogin}")
    private String INVALID_LOGIN_MESSAGE;

   public deltakerlisteController(DeltagerService service) {
       this.service = service;
    }

    @GetMapping
    public String Deltagere (Model model, HttpSession session, RedirectAttributes ra ){
        if (!LoginUtil.erBrukerInnlogget(session)){
            ra.addFlashAttribute("redirectMessage", INVALID_LOGIN_MESSAGE);
            return "redirect:" + "innlogging";
        }
       model.addAttribute("brukere", service.hentAlleDeltagere());
        return "deltagerliste";
    }
}