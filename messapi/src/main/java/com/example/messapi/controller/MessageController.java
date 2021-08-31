package com.example.messapi.controller;

import com.example.messapi.domain.Message;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@RestController
@RequestMapping("api/breeds")
public class MessageController {
    @RequestMapping(value = "list/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Message> getAll(){
        // Read Data from Json
        Map<String, List<String>> data = readJson();
        if (data != null){
            TreeMap<String, List<String>> sorted = new TreeMap<>(data);
            Message mess = new Message();
            mess.setMess(sorted);
            mess.setStatus("success");
            return new ResponseEntity<>(mess, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_EXTENDED);
    }

    private Map<String, List<String>> readJson(){
        ObjectMapper mapper = new ObjectMapper();
        // InputStream inputStream = TypeReference.class.getResourceAsStream("json/apidata.json");
        
        // read JSON file and map/convert to java POJO
        try(InputStream in=Thread.currentThread().getContextClassLoader().getResourceAsStream("json/apidata.json")) {
            return mapper.readValue(in, Map.class);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
