package app.impacto_manager.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Students {
    private long id = 1L;
    private String name;
    private String gender;
    private String CPF;
    private String phone;
    private String parentName;
    private String parentPhone;
    private String parentEmail;

    public Students(long id, String name, String gender, String CPF, String phone) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.CPF = CPF;
        this.phone = phone;
    }
}
