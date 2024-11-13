package com.korit.spring.menus.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MenuResponseDto {
    private String menuName;
    private String imageUrl;
    private String menuDescription;
    private int menuPrice;
    private Boolean isAvailable;
    private String menuCategory;
}

