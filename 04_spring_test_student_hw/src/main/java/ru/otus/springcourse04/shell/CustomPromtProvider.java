package ru.otus.springcourse04.shell;

import lombok.RequiredArgsConstructor;
import org.jline.utils.AttributedString;
import org.jline.utils.AttributedStyle;
import org.springframework.shell.jline.PromptProvider;
import org.springframework.stereotype.Component;
import ru.otus.springcourse04.service.StartTestingService;

@Component
@RequiredArgsConstructor
public class CustomPromtProvider implements PromptProvider {

    private final StartTestingService startTestingService;
    private final ApplicationStudentTestingShell applicationShell;

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
