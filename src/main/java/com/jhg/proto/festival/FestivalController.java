package com.jhg.proto.festival;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

// 애노테이션에서 클래스 레벨에 경로를 지정한 경우, 클래스 내의 모든 메서드의 경로에 그 경로가 접두사로 적용
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/festival")
@Controller
@RequiredArgsConstructor
public class FestivalController {
    private final FestivalService festivalService;

    @GetMapping("/list")
    public String showFestivalList(Model model) {
        List<Festival> festivals = this.festivalService.getList();
        model.addAttribute("festivals", festivals);
        return "festivalList"; // 템플릿 파일 이름은 "festivalList.html"로 일치
    }
}
