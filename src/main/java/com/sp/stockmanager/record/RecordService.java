package com.sp.stockmanager.record;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecordService {

    private RecordRepository recordRepository;

    @Autowired
    public RecordService(RecordRepository recordRepository) {
        this.recordRepository = recordRepository;
    }


    public void addRecord(Record record) {
        recordRepository.save(record);
    }

    public List<Record> getAllRecords() {
        List<Record> records = new ArrayList<>();

        recordRepository.findAll().forEach(records::add);
        return records;
    }
}
