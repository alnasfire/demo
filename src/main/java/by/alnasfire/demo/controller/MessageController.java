package by.alnasfire.demo.controller;

import by.alnasfire.demo.model.Message;
import by.alnasfire.demo.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by alnasfire on 7/12/16.
 */

@Controller
public class MessageController {

    private MessageService messageService;

    @Autowired(required = true)
    @Qualifier(value = "messageService")
    public void setMessageService(MessageService messageService) {
        this.messageService = messageService;
    }

    @RequestMapping(value = "/messages", method = RequestMethod.GET)
    public String listMessages(Model model){
        model.addAttribute("message", new Message());
        model.addAttribute("listMessages", this.messageService.listMessages());

        return "messages";
    }

    @RequestMapping(value = "/messages/add", method = RequestMethod.POST)
    public String addMessage(@ModelAttribute("messageid") String messageId){

        Message message = this.messageService.getMessage(messageId);
        if (message != null) {
            this.messageService.addMessage(message);
        }

        return "redirect:/messages";
    }
}
