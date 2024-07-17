package com.diversitech.courseService.service;

import com.diversitech.courseService.model.Course;
import org.springframework.web.multipart.MultipartFile;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ExcelService {
    public List<Course> readExcelFile(MultipartFile file) throws IOException {
        List<Course> courses = new ArrayList<>();

        Workbook workbook = new XSSFWorkbook(file.getInputStream());
        Sheet sheet = workbook.getSheetAt(0);

        for (Row row : sheet) {
            if (row.getRowNum() == 0) { // Skip header row
                continue;
            }

            String name = row.getCell(0).getStringCellValue();
            String description = row.getCell(1).getStringCellValue();
            System.out.println(name + " " + description);
            courses.add(new Course(0, name, description));
        }

        workbook.close();
        return courses;
    }
}
