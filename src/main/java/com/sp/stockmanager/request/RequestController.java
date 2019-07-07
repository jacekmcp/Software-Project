package com.sp.stockmanager.request;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RequestMapping("/requests")
@RestController
public class RequestController {

    private final RequestService requestService;

    @Autowired
    public RequestController(RequestService requestService) {
        this.requestService = requestService;
    }

    @PostMapping
    public void addRequest(@RequestBody List<Request> requests) {
        requestService.addRequests(requests);
    }

    @GetMapping(path = "{date}")
    public List<Request> getRequestsByDate(@PathVariable("date") @DateTimeFormat(pattern="dd-MM-yyyy") LocalDate date){
        return requestService.getRequestsByDate(date);
    }

    @GetMapping
    public List<Request> getAllRequests() {
        return requestService.getAllRequests();
    }

    @PutMapping
    public void updateRequests(@RequestBody List<Request> requests){
        requestService.updateManyRequests(requests);
    }


}
