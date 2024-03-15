package com.example.BookMyShowBackend.Controllers;

import com.example.BookMyShowBackend.Requests.AddShowRequest;
import com.example.BookMyShowBackend.Services.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("shows")
public class ShowController {

    @Autowired
    private ShowService showService;

//    @PostMapping("/addShow")
//    public String addShow(@RequestBody AddShowRequest addShowRequest){
//        String result = showService.addShow(addShowRequest);
//        return result;
//    }

    @PostMapping("addShow")
    public String addShow(@RequestBody AddShowRequest addShowRequest){

//        try {
//            String result = showService.addShow(addShowRequest);
//            return new ResponseEntity(result, HttpStatus.OK);
//
//        }catch (Exception e) {
//            return new ResponseEntity(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
//        }

        String result = showService.addShow(addShowRequest);
//        return new ResponseEntity(result, HttpStatus.OK);
        return result;

    }
}
