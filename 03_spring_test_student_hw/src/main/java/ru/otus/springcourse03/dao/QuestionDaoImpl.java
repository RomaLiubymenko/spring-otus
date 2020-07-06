package ru.otus.springcourse03.dao;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import au.com.bytecode.opencsv.bean.CsvToBean;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Repository;
import ru.otus.springcourse03.config.BasicConfiguration;
import ru.otus.springcourse03.domain.Question;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Repository
public class QuestionDaoImpl implements QuestionDao {

    private final String path;
    private final MessageSource messageSource;
    private final Locale locale;

    public QuestionDaoImpl(
            BasicConfiguration basicConfiguration,
            MessageSource messageSource

    ) {
        this.path = basicConfiguration.getPath();
        this.locale = basicConfiguration.getLocale();
        this.messageSource = messageSource;

    }

    @Override
    public ArrayList<Question> readFile() throws IOException {
        ArrayList<Question> questionArrayList = new ArrayList<>();
        try(CSVReader reader = new CSVReader(new FileReader(path))) {
            CsvToBean csv = new CsvToBean();
            List list = csv.parse(setColumMapping(), reader);
            for (Object object : list) {
                questionArrayList.add((Question) object);
            }
        }
        catch (IOException exception){
            throw new IOException(messageSource.getMessage("startTestingService.IOException", null, locale));
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
