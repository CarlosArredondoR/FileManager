package com.example.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Service
public class DemoService {
	
	 	@CrossOrigin
	    @RequestMapping(value = "/fileCreate", method = RequestMethod.GET)
	    public @ResponseBody String fileCreate() throws Exception {
	
	try {

        String content = "This is the content to write into file";

        File file = new File("C:\\Users\\CARLOS ARREDONDO\\Desktop\\Citi.txt");

        if (!file.exists()) {
            file.createNewFile();
        }

        FileWriter fw = new FileWriter(file.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(content);
        bw.close();

        return "done";

    } catch (IOException e) {
        return e.getMessage();
    }
	
}
}
