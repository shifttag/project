package com.korit.spring.menus.repository;

import com.korit.spring.menus.dto.response.MenuResponseDto;
import com.korit.spring.menus.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MenuRepository extends JpaRepository<Menu, Long> {
    @Query("SELECT a.menuName, a.imageUrl, a.menuDescription, a.menuPrice, a.isAvailable, b.menuCategory " +
    "from Menu as a  " +
    "join MenuCategory as b on a.categoryId = b.id"
    )
    List<MenuResponseDto> findAllMenu();

}
