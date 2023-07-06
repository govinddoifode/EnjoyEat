package com.app.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.entity.Menu;

@Transactional
@Repository
public interface MenuRepository extends JpaRepository<Menu, Integer>{
	
	@Modifying
	@Query("UPDATE Menu m SET m.menuName = :menuName, m.category = :category, m.rate = :rate, m.imagePath = :imagePath WHERE m.menuId = :menuId")
	public void update(@Param("menuId") Integer menuId, @Param("menuName") String menuName, @Param("category") String category, @Param("imagePath") String imagePath, @Param("rate") double rate);

//	@Modifying
//	@Query(value="update menus set menu_name=:menuName, category=:category,rate=:rate,image=:image where menu_id=:menuId",nativeQuery = true)
//	public void update( Integer menuId,String menuName,String category,double rate,String imagePath);
	
	
	@Query("select m from Menu m")
	public List<Menu> getMenu();

}
 

	 
