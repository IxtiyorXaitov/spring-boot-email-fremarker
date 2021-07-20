package dev.ikhtiyor.springbootemailfremarker.controller;

import dev.ikhtiyor.springbootemailfremarker.payload.Request;
import dev.ikhtiyor.springbootemailfremarker.payload.Response;
import dev.ikhtiyor.springbootemailfremarker.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EmailController {

    final
    EmailService emailService;

    @Autowired
    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/sendEmail")
    public Response sendEmail(@RequestBody Request request) {
        Map<String, Object> model = new HashMap<>();
        model.put("Name", request.getName());
        model.put("location", "Bangalore,India");
        return emailService.sendEmail(request, model);
    }


}
