package com.korit.spring.menus.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
public class DailySalesResponseDto {
    private LocalDate orderDay;
    private int dailySales;


}
