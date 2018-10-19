package com.example.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.service.*;

@Controller
public class DemoController {
	@Autowired
	DemoService DemoService;
	
	 
	 @CrossOrigin
	 @RequestMapping(value = "/fileRead", method = RequestMethod.GET)
	    public @ResponseBody String fileRead() throws Exception{
		 File file = new File("C:\\Users\\CARLOS ARREDONDO\\Desktop\\Citi.txt");
		 FileInputStream fis = null;
	        try {
	            fis = new FileInputStream(file);
	            System.out.println(file.getAbsolutePath());
	            System.out.println(file.getPath());

	            int content;
	            while ((content = fis.read()) != -1) {
	                // convert to char and display it
	                System.out.print((char) content);
	            }

	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                if (fis != null)
	                    fis.close();
	            } catch (IOException ex) {
	                ex.printStackTrace();
	                return ex.getMessage();
	            }

	        }

	        return "done";

	    }
		
	
}
