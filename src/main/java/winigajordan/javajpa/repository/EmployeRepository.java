package winigajordan.javajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import winigajordan.javajpa.domaine.Employe;

import java.util.List;

public interface EmployeRepository extends JpaRepository<Employe, Integer> {


    List<Employe> findByNom(String nom);
    List<Employe> findByPrenom(String prenom);
    List<Employe> findByNomAndPrenom(String nom,String prenom);
    List<Employe> findBySalaire(Integer salaire);
    List<Employe> findBySalaireGreaterThan(Integer salaire);
    List<Employe> findBySalaireLessThan(Integer salaire);
    List<Employe> findBySalaireBetween(Integer salaire1, Integer salaire2);
    List<Employe> findByNomContaining(String m);
    List<Employe> findByNomLike(String m);

}
