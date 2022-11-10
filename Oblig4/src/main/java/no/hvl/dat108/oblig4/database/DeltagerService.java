package no.hvl.dat108.oblig4.database;

import no.hvl.dat108.oblig4.entity.Bruker;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DeltagerService {
private final BrukerRepo brukerRepo;

public DeltagerService(BrukerRepo brukerRepo){
    this.brukerRepo = brukerRepo;
}
public boolean brukerFinnes (Bruker bruker){
    return brukerRepo.findBrukerByMobil(bruker.getMobil()) != null;
}
public boolean brukerFinnes (String mobil){
    return brukerRepo.findBrukerByMobil(mobil) != null;
}
public Bruker hentBruker (String mobil){
    return brukerRepo.findBrukerByMobil(mobil);
}
public void leggTilDeltager (Bruker bruker){
    brukerRepo.save(bruker);
}
public List<Bruker> hentAlleDeltagere(){
    return brukerRepo.findAll().stream().sorted((a, b)->{
        int compare = a.getFornavn().compareTo(b.getFornavn());
        if(compare == 0){
            return a.getEtternavn().compareTo((b.getEtternavn()));
        }
        return compare;
    }).toList();
}
}
