package no.hvl.dat108.oblig4;

import no.hvl.dat108.oblig4.database.BrukerRepo;
import no.hvl.dat108.oblig4.database.DeltagerService;
import no.hvl.dat108.oblig4.entity.Bruker;
import no.hvl.dat108.oblig4.util.PassordUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.validation.Validation;
import javax.validation.Validator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;




@ExtendWith(MockitoExtension.class)
public class Tester {

    @InjectMocks
    DeltagerService ds;

    @Mock
    BrukerRepo br;


    //Test1, tester om bruker finnes
    @Test
     void TestBrukerFinnes (){
        when (br.findBrukerByMobil("19191919")).thenReturn(
                new Bruker ("19191919","Tom", "Tomssen", "hemmelig","mann" ,"salt"));

        Bruker bruker1 = ds.hentBruker("19191919");
        boolean finnes = ds.brukerFinnes(bruker1);

        assertTrue(finnes);
    }

    //Test2, tester om alle deltagere blir hentet
    @Test
    void TesthentAlleDeltagere (){

        when (ds.hentAlleDeltagere()).thenReturn(List.of(
                new Bruker ("19191919","Tom", "Tomssen", "hemmelig","mann" ,"salt"),
                new Bruker ("19191920","Håkon", "Iversen", "hemmelig2","mann" ,"salt"),
                new Bruker ("19191930","Ivar", "Ivarson", "hemmelig3","mann" ,"salt")));

        List<Bruker> brukere = ds.hentAlleDeltagere();
        assertEquals(3, brukere.size());
    }

    //Test3, tester at bruker ikke skal finnes dersom vi legger inn feil tlfnr
    @Test
    void TestBrukerIkkeFinnes (){
        when (br.findBrukerByMobil("11111111")).thenReturn(
                new Bruker ("19191919","Harald", "Haraldsen", "hemmelig4","mann" ,"salt"));

        Bruker bruker2 = ds.hentBruker("11111111");
        boolean finnesIkke = ds.brukerFinnes(bruker2);
        assertFalse(finnesIkke);
    }

    //Test 4, tester om bruker har gyldig etternavn
    private Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
    @Test
    public void gyldigEtternavn() {
        Bruker bruker5 = new Bruker("19191919","Harald", "Haraldsen", "hemmelig4","mann" ,"salt");
        assertTrue(harGyldig("fornavn", bruker5));
    }

    //hjelpemetode for test 4
    private boolean harGyldig(String feltnavn, Bruker bruker) {
        List<String> ugyldigeFelt = validator.validate(bruker).stream()
                .map(v -> v.getPropertyPath().toString())
                .toList();

        return !ugyldigeFelt.contains(feltnavn);
    }

    //Test 5, tester at det blir kastet en IllegalArgumentException
    @Test
    void ThrowsArgumentExeptionTest(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> PassordUtil.hashMedSalt(null, null));
    }
}
