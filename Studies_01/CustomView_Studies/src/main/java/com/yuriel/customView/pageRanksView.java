package com.yuriel.customView;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.yuriel.domain.PageRanks;

@Component(value="pageRanks")
public class pageRanksView extends AbstractXlsxView {
	@Override
	protected void buildExcelDocument(
				Map<String, Object> model,
				Workbook workbook,
				HttpServletRequest request,
				HttpServletResponse response
			) throws Exception {
		// 1. 시트 만들기
		Sheet sheet = createFirstSheet(workbook);
		// 2. 라벨 만들기
		createColumnLabel(sheet);
		// 3. 각 행의 셀 만들기
		@SuppressWarnings("unchecked")
		List<PageRanks> pageRanks = (List<PageRanks>) model.get("pageRanks");
		int rowNum = 1;
		for(PageRanks rank : pageRanks) {
			createPageRankRow(sheet, rank, rowNum++);
		}
	}
	
	private Sheet createFirstSheet(Workbook workbook) {
		Sheet sheet = workbook.createSheet();
		workbook.setSheetName(0, "페이지 순위");
		sheet.setColumnWidth(1, 256 * 20);
		return sheet;
	}
	
	private void createColumnLabel(Sheet sheet) {
		Row firstRow = sheet.createRow(0);
		Cell cell = firstRow.createCell(0);
		cell.setCellValue("순위");
		
		cell = firstRow.createCell(1);
		cell.setCellValue("페이지");
	}
	
	private void createPageRankRow(Sheet sheet, PageRanks rank, int rowNum) {
		Row row = sheet.createRow(rowNum);
		Cell cell = row.createCell(0);
		cell.setCellValue(rank.getRank());
		
		cell = row.createCell(1);
		cell.setCellValue(rank.getPage());
	}	
}