package ru.otus.springcource01.dao;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import au.com.bytecode.opencsv.bean.CsvToBean;
import ru.otus.springcource01.domain.Question;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class QuestionDaoImpl implements QuestionDao {
    private String path;

    public QuestionDaoImpl(String path) {
        this.path = path;
    }

    @Override
    public ArrayList<Question> readFile() throws Exception {
        ArrayList<Question> questionArrayList = new ArrayList<>();
        try(CSVReader reader = new CSVReader(new FileReader(path))) {
            CsvToBean csv = new CsvToBean();
            List list = csv.parse(setColumMapping(), reader);
            for (Object object : list) {
                questionArrayList.add((Question) object);
            }
        }
        return questionArrayList;
    }

    private ColumnPositionMappingStrategy setColumMapping() {
        ColumnPositionMappingStrategy strategy = new ColumnPositionMappingStrategy();
        strategy.setType(Question.class);
        String[] columns = new String[] {"question", "answer"};
        strategy.setColumnMapping(columns);
        return strategy;
    }
}