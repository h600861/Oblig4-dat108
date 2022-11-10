package no.hvl.dat108.oblig4.database;

import no.hvl.dat108.oblig4.entity.Bruker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrukerRepo extends JpaRepository<Bruker, String> {
    Bruker findBrukerByMobil(String id);
}

