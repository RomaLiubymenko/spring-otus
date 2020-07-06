package ru.otus.springcourse04.shell;

import org.springframework.shell.Availability;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellMethodAvailability;
import ru.otus.springcourse04.service.ResultTestingService;
import ru.otus.springcourse04.service.StartTestingService;


@ShellComponent
public class ApplicationStudentTestingShell {

    private final StartTestingService startTestingService;
    private final ResultTestingService resultTestingService;

    private boolean isLoggedIn = false;
    private boolean isPassedTheTest = false;
    private boolean isStartGetRes = false;


    public ApplicationStudentTestingShell(
            StartTestingService startTestingService,
            ResultTestingService resultTestingService
    ) {
        this.startTestingService = startTestingService;
        this.resultTestingService = resultTestingService;
    }

    public boolean getIsLoggedIn() {
        return isLoggedIn;
    }

    @ShellMethod(value = "Login student", key = {"login", "lg"})
    @ShellMethodAvailability(value = "availabilityLoggedInCheck")
    private void login(String firstname, String lastname) {
        startTestingService.getFullName(firstname, lastname);
        isLoggedIn = true;
    }

    @ShellMethod(value = "Start testing", key = {"start", "st"})
    @ShellMethodAvailability(value = "availabilityLoginCheck")
    private void startTesting() {
        startTestingService.startTesting();
        isPassedTheTest = true;
    }

    @ShellMethod(value = "Get student test result", key = {"getres", "res"})
    @ShellMethodAvailability(value = "availabilityStartTestingCheck")
    private void getResult() {
        resultTestingService.getResult(startTestingService.getStudent());
        isStartGetRes = true;
    }

    @ShellMethod(value = "Restart student testing", key = {"restart", "rst"})
    @ShellMethodAvailability(value = "availabilityStartTestingCheck")
    private void restartTesting() {
        if(!isStartGetRes){
            getResult();
        }
        resultTestingService.clearResultOfTheStudent(startTestingService.getStudent());
        isPassedTheTest = false;
        isLoggedIn = false;
    }

    private Availability availabilityLoginCheck() {
        return isPassedTheTest ^ isLoggedIn
                ? Availability.available()
                : Availability.unavailable("You are not loggined or you have already passed the test. Check correct input data.");
    }

    private Availability availabilityStartTestingCheck() {
        return isPassedTheTest
                ? Availability.available()
                : Availability.unavailable("You are didn't pass the test. Take a test to get the result.");
    }

    private Availability availabilityLoggedInCheck() {
        return isLoggedIn ? Availability.unavailable("You are logged in. Call restart for loggin") : Availability.available();
    }

}
