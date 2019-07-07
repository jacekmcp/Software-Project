package com.sp.stockmanager.record;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RequestMapping("/records")
@RestController
public class RecordController {

    private final RecordService recordService;

    @Autowired
    public RecordController(RecordService recordService) {
        this.recordService = recordService;
    }

    @PostMapping
    public void addRecord(@RequestBody Record record) {
        recordService.addRecord(record);
    }


    @GetMapping
    public List<Record> getAllRecords() {
        return recordService.getAllRecords();
    }


}
