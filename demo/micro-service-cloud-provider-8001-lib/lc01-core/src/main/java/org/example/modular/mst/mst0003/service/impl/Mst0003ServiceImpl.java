package org.example.modular.mst.mst0003.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.example.common.db.table.entity.SysDatabaseInfo;
import org.example.common.db.table.service.SysDatabaseInfoService;
import org.example.modular.mst.mst0003.data.Mst0003ToResult;
import org.example.modular.mst.mst0003.mapper.Mst0003Mapper;
import org.example.modular.mst.mst0003.param.paramIn.Mst0003InitParam;
import org.example.modular.mst.mst0003.param.paramOut.Mst0003InitResult;
import org.example.modular.mst.mst0003.service.Mst0003Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * <p>
 * Mst0001マスタ サービスImpl
 * </p>
 *
 * @author Li
 * @since 2025-07-01
 */
@Service
public class Mst0003ServiceImpl extends ServiceImpl<Mst0003Mapper, Object> implements Mst0003Service {

    @Autowired
    private SysDatabaseInfoService sysDatabaseInfoService;

    @Override
    public Mst0003InitResult excelExporter(Mst0003InitParam param) {

        SysDatabaseInfo sysDatabaseInfo = this.getBaseMapper().selectSysDatabaseInfo(param.getId());

        // 创建工作簿
        Workbook workbook = new XSSFWorkbook();

        // 创建工作表
        Sheet sheet = workbook.createSheet("示例Sheet");

        // 创建表头行
        Row headerRow = sheet.createRow(0);
        String[] headers = {"ID", "姓名", "年龄"};

        for (int i = 0; i < headers.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i]);
        }

        // 插入数据
        Object[][] data = {
                {1, "张三", 25},
                {2, "李四", 30},
                {3, "王五", 28}
        };

        for (int i = 0; i < data.length; i++) {
            Row row = sheet.createRow(i + 1);
            for (int j = 0; j < data[i].length; j++) {
                Cell cell = row.createCell(j);
                if (data[i][j] instanceof String) {
                    cell.setCellValue((String) data[i][j]);
                } else if (data[i][j] instanceof Integer) {
                    cell.setCellValue((Integer) data[i][j]);
                }
            }
        }

        // 自动调整列宽
        for (int i = 0; i < headers.length; i++) {
            sheet.autoSizeColumn(i);
        }

        // 输出文件
        try (FileOutputStream fileOut = new FileOutputStream("示例Excel.xlsx")) {
            workbook.write(fileOut);
            System.out.println("Excel 文件已成功导出！");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                workbook.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return Mst0003ToResult.toInitResult(sysDatabaseInfo);
    }

}
