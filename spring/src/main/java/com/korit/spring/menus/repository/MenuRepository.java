package com.korit.spring.menus.repository;

import com.korit.spring.menus.dto.MenuAllResponseDto;
import com.korit.spring.menus.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {
//    @Query("SELECT a.menuName, a.imageUrl, a.menuDescription, a.menuPrice, a.isAvailable, b.menuCategory " +
//    "from Menu as a  " +
//    "join MenuCategory as b on a.categoryId = b.id"
//    )
//    List<MenuAllResponseDto> findAllMenu();


    @Query("SELECT new com.korit.spring.menus.dto.MenuAllResponseDto(" +
            "a.menuName, a.imageUrl, a.menuDescription, a.menuPrice, a.isAvailable, b.menuCategory) " +
            "FROM Menu a " +
            "JOIN MenuCategory b ON a.categoryId = b.id")
    List<MenuAllResponseDto> findAllMenu();

}
