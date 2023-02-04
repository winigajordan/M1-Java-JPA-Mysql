package winigajordan.javajpa.domaine;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "employe")
public class Employe implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer matricule;
    @Column(length = 255, nullable = false)
    private String nom;
    @Column(length = 255, nullable = false)
    private String prenom;
    @Column(length = 255, unique = true, nullable = false)
    private String email;
    @Column( nullable = false)
    private Integer salaire;


    public Employe() {
    }

    public Integer getMatricule() {
        return matricule;
    }

    public void setMatricule(Integer matricule) {
        this.matricule = matricule;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String premom) {
        this.prenom = premom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getSalaire() {
        return salaire;
    }

    public void setSalaire(Integer salaire) {
        this.salaire = salaire;
    }
    
    public void show(){
        System.out.println("Matricule : " + this.getMatricule());
        System.out.println("Nom : " + this.getNom());
        System.out.println("Prenom : " + this.getPrenom());
        System.out.println("Email : " + this.getEmail());
        System.out.println("Salaire : " + this.getSalaire());
    }
}
