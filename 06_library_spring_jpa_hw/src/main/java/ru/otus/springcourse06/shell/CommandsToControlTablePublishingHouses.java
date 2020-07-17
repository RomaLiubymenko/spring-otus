package ru.otus.springcourse06.shell;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.table.Table;
import ru.otus.springcourse06.domain.PublishingHouse;
import ru.otus.springcourse06.service.PublishingHousesService;

import java.util.Collections;
import java.util.List;

@ShellComponent
@RequiredArgsConstructor
public class CommandsToControlTablePublishingHouses {

    private final PublishingHousesService publishingHousesService;
    private final TableShell tableShell;

    @ShellMethod(value = "Displays the entire table PublishingHouses", key = "showPH")
    public Table showAllPublishingHouses(){
        List<PublishingHouse> publishingHousesList = publishingHousesService.outputListOfPublishingHouses();
        if(publishingHousesList.isEmpty()){
            return tableShell.printTableError("Something went wrong");
        }
        return tableShell.printTable(publishingHousesList, PublishingHouse.class);
    }

    @ShellMethod(value = "Displays the table with publishing houses by id", key = "showPHByid")
    public Table showPublishingHouseById(int id){
        PublishingHouse publishingHouse = publishingHousesService.getPublishingHouseById(id);
        if(publishingHouse == null){
            return tableShell.printTableError(String.format("Not found publishingHouse with id: %s",id));
        }
        return tableShell.printTable(Collections.singletonList(publishingHouse), PublishingHouse.class);
    }

    @ShellMethod(value = "Insert into publishing houses table", key = {"insPH", "insertPH"})
    public void insertIntoPublishingHousesTable(String publishingName, String country){
        PublishingHouse publishingHouse = new PublishingHouse();
        publishingHouse.setPublishingName(publishingName);
        publishingHouse.setCountry(country);
        publishingHousesService.insertPublishingHouses(publishingHouse);
    }
}
