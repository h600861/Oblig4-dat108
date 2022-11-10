package no.hvl.dat108.oblig4.entity;




import no.hvl.dat108.oblig4.util.PassordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Entity
@Table(schema = "oblig4")
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

    @Pattern(regexp = "^mann|kvinne$", message = "Kjønn må være mann eller kvinne")
    private String kjonn;

    private String salt;

    public Bruker (){

    }

    public Bruker(String mobil, String fornavn, String etternavn, String passord, String kjonn, String salt) {
        this.mobil = mobil;
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.passord = passord;
        this.kjonn = kjonn;
        this.salt = salt;
    }
    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

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
        salt = PassordUtil.genererSalt();
        this.passord = PassordUtil.hashMedSalt(passord, salt);
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

    @Override
    public String toString() {
        return "Bruker{" +
                "mobil='" + mobil + '\'' +
                ", fornavn='" + fornavn + '\'' +
                ", etternavn='" + etternavn + '\'' +
                ", passord='" + passord + '\'' +
                ", kjonn='" + kjonn + '\'' +
                ", salt='" + salt + '\'' +
                '}';
    }
}

