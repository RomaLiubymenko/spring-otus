package ru.otus.springcourse05.shell;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.table.Table;
import ru.otus.springcourse05.domain.PublishingHouses;
import ru.otus.springcourse05.service.PublishingHousesService;

import java.util.Collections;
import java.util.List;

@ShellComponent
@RequiredArgsConstructor
public class ControlCommandsForTablePublishingHouses {

    private final PublishingHousesService publishingHousesService;
    private final TableShell tableShell;

    @ShellMethod(value = "Displays the entire table PublishingHouses", key = "showPH")
    public Table showAllPublishingHouses(){
        List<PublishingHouses> publishingHousesList = publishingHousesService.outputListOfPublishingHouses();
        if(publishingHousesList == null){
            return tableShell.printTableError("Something went wrong");
        }
        return tableShell.printTable(publishingHousesList, new PublishingHouses());
    }

    @ShellMethod(value = "Displays the table with publishing houses by id", key = "showPHByid")
    public Table showPublishingHouseById(int id){
        PublishingHouses publishingHouse = publishingHousesService.getPublishingHouseById(id);
        if(publishingHouse == null){
            return tableShell.printTableError(String.format("Not found publishingHouse with id: %s",id));
        }
        return tableShell.printTable(Collections.singletonList(publishingHouse), new PublishingHouses());
    }

    @ShellMethod(value = "Insert into publishing houses table", key = {"insPH", "insertPH"})
    public void insertIntoPublishingHousesTable(String publishingName, String country){
        PublishingHouses publishingHouse = new PublishingHouses();
        publishingHouse.setPublishingName(publishingName);
        publishingHouse.setCountry(country);
        System.out.println(publishingHousesService.insertPublishingHouses(publishingHouse));
    }
}
