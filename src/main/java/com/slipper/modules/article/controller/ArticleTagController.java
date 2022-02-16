package com.slipper.modules.article.controller;

import com.slipper.modules.article.service.ArticleTagService;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 文章--标签
 *
 * @author gumingchen
 * @email 1240235512@qq.com
 * @date 1995-08-30 00:00:00
 */
@RestController
public class ArticleTagController {
    @Resource
    private ArticleTagService articleTagService;

}
