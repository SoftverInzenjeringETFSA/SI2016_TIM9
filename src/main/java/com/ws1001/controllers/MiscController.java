package com.ws1001.controllers;

import com.ws1001.services.MiscService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class MiscController {

    protected MiscService miscService;

    @Autowired
    public void setMiscService(MiscService miscService) {
        this.miscService = miscService;
    }

    @ResponseBody
    public MiscService.GlobalStats stats() {
        return miscService.getGlobalStats();
    }

    @ResponseBody
    public ResponseEntity catchAllOptions(String path) {
        return ResponseEntity.ok(true);
    }

    public String index(Model model) {
        return "index";
    }
}