package br.com.fkl.app;

import br.com.fkl.app.dto.OperationDTO;
import br.com.fkl.app.dto.OperationListDTO;
import br.com.fkl.app.model.RegisterWithFields;
import br.com.fkl.app.model.SearchableRegister;
import org.apache.commons.text.CaseUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class App {

    public static void main(String[] args) {
        RegisterWithFields register = RegisterWithFields.builder()
                .fieldName1("f1")
                .fieldName2("f2")
                .fieldNameLong1(100l)
                .fieldNameDouble1(50.75)
                .fieldNameInt1(123)
                .build();

        OperationListDTO operationList = OperationListDTO.builder()
                .operationListDTO(Arrays.asList(
                        OperationDTO.builder()
                                .fieldName("FIELD_NAME_1")
                                .operation("in")
                                .evalValue("f1,f2,f3")
                                .build(),
                        OperationDTO.builder()
                                .fieldName("FIELD_NAME_LONG_1")
                                .operation("==")
                                .evalValue("100")
                                .build()
                ))
                .build();

        checkValues(register, operationList);

    }

    private static void checkValues(SearchableRegister register, OperationListDTO operationList) {
        for (OperationDTO operation : operationList.getOperationListDTO()) {
            String fieldName = String.format("get%s", CaseUtils.toCamelCase(operation.getFieldName(), true, '_'));

            try {
                Method instanceMethod = RegisterWithFields.class.getMethod(fieldName);

                String result = String.valueOf(instanceMethod.invoke(register));

                System.out.println(String.format("%s: %s %s %s ????",
                        operation.getFieldName(),
                        result,
                        operation.getOperation(),
                        operation.getEvalValue()
                ));

            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

}
