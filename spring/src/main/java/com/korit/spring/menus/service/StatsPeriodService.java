package com.korit.spring.menus.service;

import com.korit.spring.menus.dto.response.DailySalesResponseDto;
import com.korit.spring.menus.dto.response.MonthSalesResponseDto;
import com.korit.spring.menus.dto.response.ResponseDto;
import com.korit.spring.menus.dto.response.YearSalesResponseDto;

import java.time.LocalDate;
import java.util.List;

public interface StatsPeriodService {
    ResponseDto<List<DailySalesResponseDto>> findDailySales(String orderDate);

    ResponseDto<List<MonthSalesResponseDto>> findMonthSales(String orderDate);

    ResponseDto<List<YearSalesResponseDto>> findYearSales(String orderDate);

}
