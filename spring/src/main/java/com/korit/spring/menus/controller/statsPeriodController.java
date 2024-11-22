package com.korit.spring.menus.controller;

import com.korit.spring.common.ApiMappingPattern;
import com.korit.spring.menus.dto.response.DailySalesResponseDto;
import com.korit.spring.menus.dto.response.MonthSalesResponseDto;
import com.korit.spring.menus.dto.response.ResponseDto;
import com.korit.spring.menus.dto.response.YearSalesResponseDto;
import com.korit.spring.menus.service.StatsPeriodService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.YearMonth;
import java.util.List;

@RestController
@RequestMapping(ApiMappingPattern.STATS)
@RequiredArgsConstructor
public class statsPeriodController {
    private final StatsPeriodService statsPeriodService;

    public static final String GET_STATS_PERIOD_DAILY = "/daily/{orderDate}";
    public static final String GET_STATS_PERIOD_MONTH = "/month/{orderDate}";
    public static final String GET_STATS_PERIOD_YEAR = "/year/{orderDate}";

    @GetMapping(GET_STATS_PERIOD_DAILY)
    public ResponseEntity<ResponseDto<List<DailySalesResponseDto>>> findDailySales(
            @PathVariable String orderDate
    ) {
        ResponseDto<List<DailySalesResponseDto>> response = statsPeriodService.findDailySales(orderDate);
        HttpStatus status = response.isResult() ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
        return ResponseEntity.status(status).body(response);
    }

    @GetMapping(GET_STATS_PERIOD_MONTH)
    public ResponseEntity<ResponseDto<List<MonthSalesResponseDto>>> findMonthSales(
            @PathVariable String orderDate
    ) {
        ResponseDto<List<MonthSalesResponseDto>> response = statsPeriodService.findMonthSales(orderDate);
        HttpStatus status = response.isResult() ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
        return ResponseEntity.status(status).body(response);
    }

    @GetMapping(GET_STATS_PERIOD_YEAR)
    public ResponseEntity<ResponseDto<List<YearSalesResponseDto>>> findYearSales(
            @PathVariable String orderDate
    ) {
        ResponseDto<List<YearSalesResponseDto>> response = statsPeriodService.findYearSales(orderDate);
        HttpStatus status = response.isResult() ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
        return ResponseEntity.status(status).body(response);
    }
}