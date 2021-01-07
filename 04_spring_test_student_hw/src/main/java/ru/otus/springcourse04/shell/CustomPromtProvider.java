package ru.otus.springcourse04.shell;

import org.jline.utils.AttributedString;
import org.jline.utils.AttributedStyle;
import org.springframework.shell.jline.PromptProvider;
import org.springframework.stereotype.Component;
import ru.otus.springcourse04.service.StartTestingService;

@Component
public class CustomPromtProvider implements PromptProvider {

    private final StartTestingService startTestingService;
    private final ApplicationStudentTestingShell applicationShell;

    public CustomPromtProvider(StartTestingService startTestingService, ApplicationStudentTestingShell applicationShell) {
        this.startTestingService = startTestingService;
        this.applicationShell = applicationShell;
    }

    @Override
    public AttributedString getPrompt() {
        if (startTestingService.getStudent() != null && applicationShell.getIsLoggedIn()) {
            return new AttributedString("logged in user:>",
                    AttributedStyle.DEFAULT.foreground(AttributedStyle.GREEN));
        }
        else {
            return new AttributedString( "not logged in:>",
                    AttributedStyle.DEFAULT.foreground(AttributedStyle.RED));
        }
    }
}
