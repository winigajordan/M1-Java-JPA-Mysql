package winigajordan.javajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import winigajordan.javajpa.domaine.Employe;
import winigajordan.javajpa.repository.EmployeRepository;

import java.util.List;

@SpringBootApplication
public class JavaJpaApplication implements CommandLineRunner {
   @Autowired
    private EmployeRepository employeRepository;
    public static void main(String[] args) {
        SpringApplication.run(JavaJpaApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        //createEmploye();
        //showAllEmployees();
        //deleteEmployee();
        //showAllEmployees();
        //ifExists();
        //seachEmployee();
        //sameName();
        //sameSalaire();
        //salaireSup();
        salaireBetween();
    }

    public void createEmploye(){
        Employe employe = new Employe();
        employe.setNom("REMA");
        employe.setPrenom("Winiga-Jordane");
        employe.setEmail("winigajordan@gmail.com");
        employe.setSalaire(200000);
        employeRepository.save(employe);

        Employe employe1 = new Employe();
        employe1.setNom("AKLOYO");
        employe1.setPrenom("Rose");
        employe1.setEmail("rose@gmail.com");
        employe1.setSalaire(220000);
        employeRepository.save(employe1);

        Employe employe2 = new Employe();
        employe2.setNom("REMA");
        employe2.setPrenom("Eunice");
        employe2.setEmail("eunice@gmail.com");
        employe2.setSalaire(180000);
        employeRepository.save(employe2);
    }

    public void showAllEmployees(){
        List<Employe> list = employeRepository.findAll();
        for (Employe x : list) {
            System.out.println("------------------");
            x.show();
        }
        System.out.println("------------------");
    }

    public void ifExists(){
        Integer matricule = 4;
        boolean found = employeRepository.existsById(matricule);
        if (found) {
            System.out.println("Employe trouve");
        } else {
            System.out.println("Employe non-trouve");
        }
    }

    public void seachEmployee(){
        Integer matricule = 1;
        boolean found = employeRepository.existsById(matricule);
        if (found) {
            Employe employe = employeRepository.findById(matricule).get();
            System.out.println("------------------");
            employe.show();
            System.out.println("------------------");
        } else {
            System.out.println("Employe non-trouve");
        }
    }

    public void deleteEmployee(){
        Integer matricule = 1;
        boolean found = employeRepository.existsById(matricule);
        if (found) {
            employeRepository.deleteById(matricule);
            System.out.println("Employee avec l'id "+ matricule+ " a ete supprime");
        } else {
            System.out.println("Employe non-trouve");
        }
    }

    public void sameName(){
        List<Employe> list = employeRepository.findByNom("REMA");
        if (list.size()==0){
            System.out.println("Liste vide");
        } else {
            for (Employe x : list) {
                System.out.println("------------------");
                x.show();
            }
            System.out.println("------------------");
        }
    }

    public void sameSalaire(){
        List<Employe> list = employeRepository.findBySalaire(200000);
        if (list.size()==0){
            System.out.println("Liste vide");
        } else {
            for (Employe x : list) {
                System.out.println("------------------");
                x.show();
            }
            System.out.println("------------------");
        }
    }

    public void salaireSup(){
        List<Employe> list = employeRepository.findBySalaireGreaterThan(180000);
        if (list.size()==0){
            System.out.println("Liste vide");
        } else {
            for (Employe x : list) {
                System.out.println("------------------");
                x.show();
            }
            System.out.println("------------------");
        }
    }

    public void salaireBetween(){
        List<Employe> list = employeRepository.findBySalaireBetween(180000, 200000);
        if (list.size()==0){
            System.out.println("Liste vide");
        } else {
            for (Employe x : list) {
                System.out.println("------------------");
                x.show();
            }
            System.out.println("------------------");
        }
    }
}
