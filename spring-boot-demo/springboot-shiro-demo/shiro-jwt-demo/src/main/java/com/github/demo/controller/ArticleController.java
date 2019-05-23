package com.github.demo.controller;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.github.demo.dto.ArticleDto;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @GetMapping("/list")
    @RequiresPermissions("")
    public String list(){
        return "hello world!!!";
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArticleDto> read(@PathVariable Long id){
        return null;
    }


}
