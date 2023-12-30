package app.impacto_manager.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Students {
    private long id= 1L;
    private String name;
    private String gender;
    private String CPF;
    private String phone;
}
