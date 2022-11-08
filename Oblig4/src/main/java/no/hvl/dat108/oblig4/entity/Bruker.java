package no.hvl.dat108.oblig4.entity;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Entity
@Table(schema = "")
public class Bruker {

   @Id
   @Pattern(regexp = "^\\d{8}$", message = "Telefonnummer må være nøyaktig 8 siffer")
   private String mobil;

   @Size(min = 2, max = 20, message = "Fornavn må være mellom 2-20 bokstaver")
   @Pattern(regexp = "^[A-ZÆØÅ][a-zæøå\\-\\s]+$",message = "Fornavn må starte med stor bokstav, etterfulgt av små")
   private String fornavn;

    @Size(min = 2, max = 20, message = "Etternavn må være mellom 2-20 bokstaver")
     @Pattern(regexp = "^[A-ZÆØÅ][a-zæøå\\-\\s]+$",message = "Etternavn må starte med stor bokstav, etterfulgt av små")
    private String etternavn;


    @Size(min = 8, message = "Passordet må være minst 8 tegn")
    private String passord;

    private String PassordRepetert;

    @Pattern(regexp = "^mann|kvinne$", message = "Kjønn må være mann eller kvinne")
    private String kjonn;

    public String getMobil() {
        return mobil;
    }
    public void setMobil(String mobil) {
        this.mobil = mobil;
    }
    public String getPassord() {
        return passord;
    }
    public void setPassord(String passord) {
        this.passord = passord;
    }
    public String getKjonn() {
        return kjonn;
    }
    public void setKjonn(String kjonn) {
        this.kjonn = kjonn;
    }
    public String getFornavn() {
        return fornavn;
    }
    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }
    public String getEtternavn() {
        return etternavn;
    }
    public void setEtternavn(String etternavn) {
        this.etternavn = etternavn;
    }
}

