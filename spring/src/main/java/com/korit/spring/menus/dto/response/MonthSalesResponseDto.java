package com.korit.spring.menus.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class MonthSalesResponseDto {
    private int orderDateYear;
    private int orderDateMonth;
    private int monthSales;
}
