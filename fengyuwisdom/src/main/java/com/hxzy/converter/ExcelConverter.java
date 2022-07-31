package com.hxzy.converter;


import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.property.ExcelContentProperty;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class ExcelConverter  implements Converter<Date> {

    @Override
    public Class supportJavaTypeKey() {
        return Date.class;
    }

    @Override
    public CellDataTypeEnum supportExcelTypeKey() {
        return CellDataTypeEnum.STRING;
    }

    @Override
    public Date convertToJavaData(
            CellData cellData,
            ExcelContentProperty contentProperty,
            GlobalConfiguration globalConfiguration) {
        return Date.valueOf(LocalDate.parse(cellData.getStringValue(), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
    }

    @Override
    public CellData convertToExcelData(
            Date value,
            ExcelContentProperty contentProperty,
            GlobalConfiguration globalConfiguration) {
        if (contentProperty == null || contentProperty.getDateTimeFormatProperty() == null) {
            return new CellData(value);
        } else {
            return new CellData(value);
        }
    }

}
