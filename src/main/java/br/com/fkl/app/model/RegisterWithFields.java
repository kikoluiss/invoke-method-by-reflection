package br.com.fkl.app.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterWithFields implements SearchableRegister {

    private int id;

    private String fieldName1;
    private String fieldName2;
    private long fieldNameLong1;
    private double fieldNameDouble1;
    private int fieldNameInt1;

}
