package ru.otus.springcourse05.shell;

import org.springframework.shell.table.*;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.List;

@Component
public class TableShell {

    public <T> Table printTable(List<T> list, Object obj){
        return buildTable(list, getClassFields(obj));
    }

    public Table printTableError(String massageError){
        return buildTableIfError(massageError);
    }


    private <T> Table buildTable(List<T> list, LinkedHashMap<String, Object> headers) {
        TableModel model = new BeanListTableModel<>(list, headers);
        TableBuilder tableBuilder = new TableBuilder(model);
        tableBuilder.addHeaderBorder(BorderStyle.fancy_double);
        tableBuilder.addInnerBorder(BorderStyle.fancy_heavy);
        return tableBuilder.build();
    }

    private  <T> Table buildTableIfError(String massage) {
        String[][] strMassage = {{massage}};
        TableModel model = new ArrayTableModel(strMassage);
        TableBuilder tableBuilder = new TableBuilder(model);
        return tableBuilder.build();
    }

    private LinkedHashMap<String, Object> getClassFields(Object obj) {
        Field[] fs = obj.getClass().getDeclaredFields();
        LinkedHashMap<String, Object> fieldsMap = new LinkedHashMap<>();
        for (Field field : fs) { fieldsMap.put(field.getName(), field.getName()); }
        return fieldsMap;
    }
}
