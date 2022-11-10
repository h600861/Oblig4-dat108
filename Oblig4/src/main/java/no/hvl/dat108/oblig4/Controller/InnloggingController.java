package no.hvl.dat108.oblig4.Controller;

import no.hvl.dat108.oblig4.database.DeltagerService;
import no.hvl.dat108.oblig4.entity.Bruker;
import no.hvl.dat108.oblig4.util.LoginUtil;
import no.hvl.dat108.oblig4.util.PassordUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
@Controller
@RequestMapping("${app.url.innlogging}")
public class InnloggingController {
    private final DeltagerService service;

    public InnloggingController(DeltagerService service) {
        this.service = service;
    }

    @Value("${app.session.maxTidsInterval}")
    private int maxTid;
    @GetMapping
    public String innlogging(){
        return "innlogging";
    }
    @PostMapping
    public String behandleInnlogging(@RequestParam String mobil, @RequestParam String passord, RedirectAttributes ra, HttpSession session){
        if(service.brukerFinnes(mobil)){
            Bruker bruker = service.hentBruker(mobil);


            if(PassordUtil.validerMedSalt(passord, bruker.getSalt(), bruker.getPassord())){
                session.setAttribute("bruker", bruker);
                LoginUtil.loggInnBruker(session, maxTid);
                return "redirect:" + "deltagerliste";
            }else {
                ra.addFlashAttribute("error", "Feil passord/brukernavn");
                ra.addFlashAttribute("mobil", mobil);
                return "redirect:" + "innlogging";
            }
            }else{
                ra.addFlashAttribute("mobil", mobil);
                ra.addFlashAttribute("error", "Feil passord/brukernavn");
                return "redirect:" + "innlogging";
            }
        }
    }


