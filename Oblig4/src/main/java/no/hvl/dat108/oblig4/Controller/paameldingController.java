package no.hvl.dat108.oblig4.Controller;

import no.hvl.dat108.oblig4.database.DeltagerService;
import no.hvl.dat108.oblig4.entity.Bruker;
import no.hvl.dat108.oblig4.util.LoginUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/${app.url.paamelding}")

public class paameldingController {


    private final DeltagerService service;

    public paameldingController(DeltagerService service) {
        this.service = service;
    }

    @Value("${app.message.invalidLogin}")
    private String INVALID_LOGIN_MESSAGE;



    @Value("${app.session.maxTidsInterval}")
        private int maxTid;

    @GetMapping
    public String hentPaameldingSkjema(Model model) {
    model.addAttribute("bruker", new Bruker());
        return "paamelding";
    }

   @PostMapping
    public String visPaameldt (@Valid @ModelAttribute("bruker")Bruker bruker, BindingResult bs, HttpSession session,RedirectAttributes ra ){
       System.out.println(bruker);
        if (bs.hasErrors()){
            ra.addFlashAttribute("redirectMessage", INVALID_LOGIN_MESSAGE);
            return "paamelding";
        }if (service.brukerFinnes(bruker)){
            System.err.println("Mobilnummer finnes fra før");
            ra.addFlashAttribute("redirectMessage","Bruker finnes fra før");
            return "redirect:" + "paamelding";
        }
         service.leggTilDeltager(bruker);
        session.setAttribute("bruker", bruker);
        LoginUtil.loggInnBruker(session,maxTid);

       return  "redirect:" + "paameldt";
    }
}
