package br.com.fkl.app.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OperationDTO {
    private String fieldName;
    private String operation;
    private String evalValue;
}
