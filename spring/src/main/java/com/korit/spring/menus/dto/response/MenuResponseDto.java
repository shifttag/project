package com.korit.spring.menus.dto.response;

import com.korit.spring.menus.dto.MenuAllResponseDto;
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

    public MenuResponseDto(MenuAllResponseDto menu) {
        this.menuName = menu.getMenuName();
        this.imageUrl = menu.getImageUrl();
        this.menuDescription = menu.getMenuDescription();
        this.menuPrice = menu.getMenuPrice();
        this.isAvailable = menu.isAvailable();
        this.menuCategory = menu.getMenuCategory();
    }

}

