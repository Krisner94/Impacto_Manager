package app.impacto_manager.data.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentPojo {
    private long id;
    private String name;
    private String gender;
    private String phone;
    private String cpf;
}
