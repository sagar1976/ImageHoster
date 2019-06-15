package ImageHoster.controller;

import ImageHoster.model.Comment;
import ImageHoster.model.Image;
import ImageHoster.model.User;
import ImageHoster.service.CommentService;
import ImageHoster.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class CommentController {
    @Autowired
    private CommentService commentService;

    @Autowired
    private ImageService imageService;

    @RequestMapping(value ="/image/{imageId}/{imageTitle}/comment", method = RequestMethod.POST)
    public String updateComment(@RequestParam("comment") String comments, @PathVariable("imageId") Integer imageId, @PathVariable("imageTitle") String imageTitle, Comment newComment, HttpSession session) {
        User user = (User) session.getAttribute("loggeduser");
        newComment.setUser(user);
        newComment.setText(comments);
        Image image = imageService.getImage(imageId);
        newComment.setImage(image);
        commentService.updateComment(newComment);
        return "redirect:/images/{imageId}/{imageTitle}";

    }
}
