package com.unilever.commonservice.profile.export;

import com.unilever.commonservice.profile.dto.CandidateDto;
import com.unilever.commonservice.profile.model.Candidate;
import com.unilever.commonservice.profile.repository.CodeRepository;
import com.unilever.commonservice.profile.repository.RoleRepository;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Service
public class UserExcelExporter {

    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private List<CandidateDto> listUsers;


    public UserExcelExporter(List<CandidateDto> listUsers) {
        this.listUsers = listUsers;
        workbook = new XSSFWorkbook();
    }
        private void writeHeaderLine() {
            sheet = workbook.createSheet("Users");

            Row row = sheet.createRow(0);

            CellStyle style = workbook.createCellStyle();
            XSSFFont font = workbook.createFont();
            font.setBold(true);
            font.setFontHeight(16);
            style.setFont(font);

            createCell(row, 0, "Sr No.", style);
            createCell(row, 1, "Candidate Name", style);
            createCell(row, 2, "Current Designation", style);
            createCell(row, 3, "Current Employer", style);
            createCell(row, 4, "Worked in Unilever Before", style);
            createCell(row, 5, "Gender", style);
            createCell(row, 6, "Sourced By Headhunter", style);
            createCell(row, 7, "Role", style);
            createCell(row, 8, "Comments", style);
            createCell(row, 9, "Hiring Status", style);
            createCell(row, 10, "Profile Url", style);
            createCell(row, 11, "Has been Interviewed", style);
    }

    private void createCell(Row row, int columnCount, Object value, CellStyle style) {
        sheet.autoSizeColumn(columnCount);
        Cell cell = row.createCell(columnCount);
        if (value instanceof Integer) {
            cell.setCellValue((Integer) value);
        } else if (value instanceof Boolean) {
            cell.setCellValue((Boolean) value);
        } else {
            cell.setCellValue((String) value);

            cell.setCellStyle(style);
        }
    }
        private void writeDataLines() {
            int rowCount = 1;

            CellStyle style = workbook.createCellStyle();
            XSSFFont font = workbook.createFont();
            font.setFontHeight(14);
            style.setFont(font);

            int index =1;
            for (CandidateDto user : listUsers) {

                Row row = sheet.createRow(rowCount++);
                int columnCount = 0;


                createCell(row, columnCount++, index, style);
                createCell(row, columnCount++, user.getCandidateName(), style);
                createCell(row, columnCount++, user.getCurrentDesignation(), style);
                createCell(row, columnCount++, user.getEmployerName(), style);
                createCell(row, columnCount++, user.getIsUnileverBefore(), style);
                createCell(row, columnCount++, user.getGender()  ,style);
                createCell(row, columnCount++, user.getIsSourcedByHeadHunter(), style);
                createCell(row, columnCount++, user.getRole(), style);
                createCell(row, columnCount++, user.getComments(), style);
                createCell(row, columnCount++, user.getHiringStatus(), style);
                createCell(row, columnCount++, user.getProfileUrl(), style);
                createCell(row, columnCount++, user.getIsInterviewed(), style);
                index++;
        }
    }

        public void export(HttpServletResponse response) throws IOException {
            writeHeaderLine();
            writeDataLines();

            ServletOutputStream outputStream = response.getOutputStream();
            workbook.write(outputStream);
            workbook.close();
            outputStream.close();

        }
}
