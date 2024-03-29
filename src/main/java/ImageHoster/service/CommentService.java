package ImageHoster.service;

import ImageHoster.model.Comment;
import ImageHoster.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    //The method calls the updateComment() method in the Repository and passes the comment of the image to be inserted in the database
    public void updateComment(Comment comment) {
        commentRepository.updateComment(comment);
    }
}
