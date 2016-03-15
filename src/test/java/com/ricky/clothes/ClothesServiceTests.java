package com.ricky.clothes;

import com.ricky.clothes.model.Clothes;
import com.ricky.clothes.service.ClothesService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by caiqing on 16/3/10.
 */
public class ClothesServiceTests extends ApplicationTests {
    @Autowired
    ClothesService clothesService;

    @Test
    public void testSelectClothes() {
//        List<Clothes> clothes = clothesService.selectClothes();

//        List<Clothes> clothes = clothesService.selectAllWithTag();

        clothesService.saveClothes();
//        Assert.assertNotNull(clothes);
    }


}
