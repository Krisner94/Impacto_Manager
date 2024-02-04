package app.impacto_manager.model;

import app.impacto_manager.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Students {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id = 1L;
    private String name;
    private Gender gender;
    private String CPF;
    private String phone;
    private String parentName;
    private String parentPhone;
    private String parentEmail;

    public Students(String name, Gender gender, String phone, String CPF) {
        this.name = name;
        this.gender = gender;
        this.phone = phone;
        this.CPF = CPF;

    }
}
