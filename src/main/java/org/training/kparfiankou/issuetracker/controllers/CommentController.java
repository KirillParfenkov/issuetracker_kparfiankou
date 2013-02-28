package org.training.kparfiankou.issuetracker.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.training.kparfiankou.issuetracker.Constants;
import org.training.kparfiankou.issuetracker.beans.Comment;
import org.training.kparfiankou.issuetracker.beans.User;
import org.training.kparfiankou.issuetracker.dao.IIssueDAO;
import org.training.kparfiankou.issuetracker.factories.IssueDAOFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Kiryl_Parfiankou
 * Date: 2/28/13
 * Time: 8:00 PM
 */
@Controller
public class CommentController {

    @RequestMapping(value = Constants.INSERT_COMMENT_CONTROLLER,
                    method = {RequestMethod.GET, RequestMethod.POST})
    public String insertCommentController(HttpServletRequest request,
                                          @RequestParam(Constants.KEY_ISSUE_ID) long issueId,
                                          @RequestParam(Constants.KEY_CONTENT) String content) {

        HttpSession session = request.getSession();
        IIssueDAO issueDAO = IssueDAOFactory.getClassFromFactory();

        long maxCommentId = issueDAO.getMaxCommetnId();

        User user = (User) session.getAttribute(Constants.KEY_USER);
        Date date = issueDAO.getCurrentDate();

        Comment comment = new Comment(++maxCommentId);

        comment.setContent(content);
        comment.setAddDate(date);
        comment.setAutor(user);

        issueDAO.insertComment(comment, issueDAO.getIssue(issueId));

        return Constants.CREATE_UPDATE_ISSUE_CONTROLLER;
    }
}