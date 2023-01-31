package com.sch.shift3.admin.view;

import com.sch.shift3.admin.service.AdminShopService;
import com.sch.shift3.user.dto.SelectShopDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminView {

    private final AdminShopService adminShopService;

    @GetMapping("")
    public String mainPage(){
        return "admin/content/main";
    }

    @GetMapping("/contents/list")
    public String contentListPage(){
        return "admin/content/pages/contents/list";
    }

    @GetMapping("/contents/create")
    public String contentCreatePage(){
        return "admin/content/pages/contents/create";
    }

    @GetMapping("/shop/list")
    public String shopListPage(Model model){
        model.addAttribute("shops", adminShopService.getShopList());
        return "admin/content/pages/shop/list";
    }

    @GetMapping("/shop/create")
    public String shopCreatePage(Model model){
        SelectShopDto selectShopDto = new SelectShopDto();
        selectShopDto.setStreetAddress("서울특별시 강남구 역삼동 824-1");
        selectShopDto.setName("테스트");
        selectShopDto.setIntroduce("테스트");
        selectShopDto.setStreetAddressDetail("테스트");
        selectShopDto.setContactNumber("010-1234-5678");
        selectShopDto.setOperatingTime("09:00 ~ 18:00");

        model.addAttribute("SelectShopDto", selectShopDto);
        return "admin/content/pages/shop/create";
    }
}
