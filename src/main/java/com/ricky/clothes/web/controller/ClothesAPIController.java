package com.ricky.clothes.web.controller;

import com.ricky.clothes.constant.EnumLocation;
import com.ricky.clothes.vo.ClothesVo;
import com.ricky.clothes.vo.TagVo;
import com.ricky.clothes.vo.TypeVo;
import com.ricky.clothes.vo.UserVo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by caiqing on 16/3/16.
 */
@RestController
@RequestMapping("/clothesApi")
public class ClothesAPIController extends BaseAppController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ClothesVo selectClothes() {

        ClothesVo clothesVo = new ClothesVo();
        TagVo tagVo = new TagVo();
        TypeVo typeVo = new TypeVo();
        UserVo userVo = new UserVo();

        tagVo.setName("test");
        clothesVo.setName("clothes");
        clothesVo.setLocation(EnumLocation.KAIKAI);
        clothesVo.setImageName("image");
        userVo.setName("ricky");
        clothesVo.setUser(userVo);

        return clothesVo;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public void saveClothes(@RequestBody ClothesVo clothesVo) {
        ClothesVo vo = clothesVo;

        System.out.print(vo);

    }

}
