package ru.otus.springcourse07.shell;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.table.Table;
import ru.otus.springcourse07.domain.Comment;
import ru.otus.springcourse07.service.BooksService;
import ru.otus.springcourse07.service.CommentsService;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@ShellComponent
@RequiredArgsConstructor
public class CommandsToControlTableComments {

    private final CommentsService commentsService;
    private final BooksService booksService;
    private final TableShell tableShell;

    @ShellMethod(value = "Displays the entire table Comments", key = "showC")
    public Table showAllComments(){
        List<Comment> commentList = commentsService.outputListOfComment();
        if(commentList.isEmpty()){
            return tableShell.printTableError("Something went wrong");
        }
        return tableShell.printTable(commentList, Comment.class);
    }

    @ShellMethod(value ="Displays the table with comments by book title", key = "showCbyTitle")
    public Table showCommentsByTitle(String title){
       return tableShell.printTable(commentsService.getCommentsByBookTitle(title), Comment.class);
    }

    @ShellMethod(value = "Displays the table with comments by id", key = "showCbyid")
    public Table showCommentsById(int id){
        Comment comment = commentsService.getCommentById(id);
        if(comment == null){
            return tableShell.printTableError(String.format("Not found comment with id: %s",id));
        }
        return tableShell.printTable(Collections.singletonList(comment), Comment.class);
    }

    @ShellMethod(value = "Insert into genres table", key = {"insC", "insertC"})
    public void insertIntoGenreTable(int idBook, String text){
        Comment comment = new Comment();
        if(booksService.getBookById(idBook) == null){
            System.out.println("There is no such book in the library");
        }else{
            comment.setBook(booksService.getBookById(idBook));
            comment.setText(text);
            comment.setPublicationTime(LocalDateTime.now());
            commentsService.insertComment(comment);
        }
    }
}
