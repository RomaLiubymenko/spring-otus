package ru.otus.springcourse02.dao;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import au.com.bytecode.opencsv.bean.CsvToBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import ru.otus.springcourse02.domain.Question;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

@Repository
public class QuestionDaoImpl implements QuestionDao {

    private String path;

    public QuestionDaoImpl(@Value("${file.question}") String path) {
        this.path = path;
    }

    @Override
    public ArrayList<Question> readFile() throws Exception {
        ArrayList<Question> questionArrayList = new ArrayList<>();
        try(CSVReader reader = new CSVReader(new FileReader(path))) {
            CsvToBean csv = new CsvToBean();
            List list = csv.parse(setColumnMapping(), reader);
            for (Object object : list) {
                questionArrayList.add((Question) object);
            }
        }
        return questionArrayList;
    }

    private ColumnPositionMappingStrategy setColumnMapping() {
        ColumnPositionMappingStrategy strategy = new ColumnPositionMappingStrategy();
        strategy.setType(Question.class);
        String[] columns = new String[] {"question", "answer"};
        strategy.setColumnMapping(columns);
        return strategy;
    }
}
