package com.korit.spring.menus.dto.response;

import com.korit.spring.menus.dto.MenuAllResponseDto;
import com.korit.spring.menus.entity.Menu;
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
    private Long storeId;
    private Long categoryId;

    public MenuResponseDto(Menu menu) {
        this.menuName = menu.getMenuName();
        this.imageUrl = menu.getImageUrl();
        this.menuDescription = menu.getMenuDescription();
        this.menuPrice = menu.getMenuPrice();
        this.isAvailable = menu.getIsAvailable();
        this.menuCategory = menu.getMenuCategory().getMenuCategory();
        this.storeId = menu.getStoreId();
        this.categoryId = menu.getMenuCategory().getId();
    }


}

