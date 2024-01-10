package app.impacto_manager.enums;

public enum Gender {
    FEMININO("Feminino"),
    MASCULINO("Masculino");

    private final String gender;

    Gender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString(){
        return gender;
    }
}