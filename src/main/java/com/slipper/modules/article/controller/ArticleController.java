package com.slipper.modules.article.controller;

import com.slipper.common.utils.R;
import com.slipper.common.validator.group.Create;
import com.slipper.common.validator.group.Update;
import com.slipper.common.vo.StatusVo;
import com.slipper.modules.article.entity.ArticleEntity;
import com.slipper.modules.article.model.vo.ArticlePageVo;
import com.slipper.modules.article.model.vo.ArticleVo;
import com.slipper.modules.article.service.ArticleService;
import com.slipper.modules.category.entity.CategoryEntity;
import com.slipper.modules.category.model.vo.CategoryPageVo;
import com.slipper.modules.category.service.CategoryService;
import com.slipper.modules.user.entity.UserEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 文章
 *
 * @author gumingchen
 * @email 1240235512@qq.com
 * @date 1995-08-30 00:00:00
 */
@RestController
public class ArticleController {
    @Resource
    private ArticleService articleService;

    /**
     * 分页列表
     *
     * @api {POST} /slipper/console/article/page page
     * @apiDescription 文章分页列表
     * @apiVersion 1.0.0
     * @apiGroup Article
     * @apiName page
     * @apiParamExample 请求参数示例
     * {
     *     page: 1, // 当前页
     *     size: 10, // 页面大小
     *     start: '', // 开始时间
     *     end: '', // 结束时间
     *     title: '', // 标题
     *     category_ids: [], // 分类ID列表
     *     recommended: '', // 是否推荐：0-否 1-是
     *     commentable: '', // 是否可以评论：0-否 1-是
     *     published: '', // 是否发布：0-否 1-是
     * }
     * @apiSuccessExample 响应结果示例
     * {
     *     code: 0,
     *     status: 'success',
     *     message: '成功!',
     *     data: {
     *         current: 1, // 当前页
     *         size: 1, // 页面大小
     *         total: 1, // 总条数
     *         pages: 1, // 总页数
     *         list: [{
     *         	   id: '', // ID
     *         	   title: '', // 标题
     *         	   describe: '', // 简介描述
     *         	   cover: '', // 封面图
     *         	   category_id: '', // 分类ID
     *         	   category_name: '', // 分类名称
     *         	   tags: [{
     *         	       id: '', // 标签ID
     *         	       name: '', // 标签名称
     *         	   }],
     *         	   praise: '', // 点赞数量
     *         	   comment: '', // 评论数量
     *         	   read: '', // 阅读量
     *         	   recommended: '', // 是否推荐：0-否 1-是
     *         	   commentable: '', // 是否可以评论：0-否 1-是
     *         	   published: '', // 是否发布：0-否 1-是
     *             published_at: '', // 发布时间
     *             created_at: '', // 创建时间
     *             updated_at: '' // 更新时间
     *         }]
     *     }
     * }
     */
    @PostMapping("/console/article/page")
    public R page(@RequestBody ArticlePageVo articlePageVo){
        return R.success(articleService.queryPage(articlePageVo));
    }

    /**
     * 信息
     *
     * @api {GET} /slipper/console/article/info info
     * @apiDescription 文章信息
     * @apiVersion 1.0.0
     * @apiGroup Article
     * @apiName info
     * @apiParamExample 请求参数示例
     * {
     *     id: '', // ID
     * }
     * @apiSuccessExample 响应结果示例
     * {
     *     code: 0,
     *     status: 'success',
     *     message: '成功!',
     *     data: {
     *         id: '', // ID
     *         title: '', // 标题
     *         content: '', // 内容
     *         describe: '', // 简介描述
     *         cover: '', // 封面图
     *         category_id: '', // 分类ID
     *         category_name: '', // 分类名称
     *         tags: [{
     *             id: '', // 标签ID
     *             name: '', // 标签名称
     *         }],
     *         praise: '', // 点赞数量
     *         comment: '', // 评论数量
     *         read: '', // 阅读量
     *         recommended: '', // 是否推荐：0-否 1-是
     *         commentable: '', // 是否可以评论：0-否 1-是
     *         published: '', // 是否发布：0-否 1-是
     *         published_at: '', // 发布时间
     *         created_at: '', // 创建时间
     *         updated_at: '' // 更新时间
     *     }
     * }
     */
    @GetMapping("/console/article/info")
    public R info(Integer id){
        return R.success(articleService.queryInfo(id));
    }

    /**
     * 新增
     *
     * @api {POST} /slipper/console/article/create create
     * @apiDescription 文章新增
     * @apiVersion 1.0.0
     * @apiGroup Article
     * @apiName create
     * @apiParamExample 请求参数示例
     * {
     *     title: '', // 标题
     *     content: '', // 内容
     *     describe: '', // 简介描述
     *     cover: '', // 封面图
     *     category_id: '', // 分类ID
     *     tags: [], // 标签ID
     *     recommended: '', // 是否推荐：0-否 1-是
     *     commentable: '', // 是否可以评论：0-否 1-是
     *     published: '', // 是否发布：0-否 1-是
     * }
     * @apiSuccessExample 响应结果示例
     * {
     *     code: 0,
     *     status: 'success',
     *     message: '成功!'
     * }
     */
    @PostMapping("/console/article/create")
    public R create(@RequestBody @Validated(Create.class) ArticleVo articleVo){
        return R.success(articleService.create(articleVo));
    }

    /**
     * 编辑
     *
     * @api {POST} /slipper/console/article/update update
     * @apiDescription 文章编辑
     * @apiVersion 1.0.0
     * @apiGroup Article
     * @apiName update
     * @apiParamExample 请求参数示例
     * {
     *     id: '', // ID
     *     title: '', // 标题
     *     content: '', // 内容
     *     describe: '', // 简介描述
     *     cover: '', // 封面图
     *     category_id: '', // 分类ID
     *     tags: [], // 标签ID
     *     recommended: '', // 是否推荐：0-否 1-是
     *     commentable: '', // 是否可以评论：0-否 1-是
     *     published: '', // 是否发布：0-否 1-是
     * }
     * @apiSuccessExample 响应结果示例
     * {
     *     code: 0,
     *     status: 'success',
     *     message: '成功!'
     * }
     */
    @PostMapping("/console/article/update")
    public R update(@RequestBody @Validated(Update.class) ArticleVo articleVo){
        articleService.update(articleVo);
        return R.success();
    }

    /**
     * 批量删除
     *
     * @api {POST} /slipper/console/article/delete delete
     * @apiDescription 文章批量删除
     * @apiVersion 1.0.0
     * @apiGroup Article
     * @apiName delete
     * @apiParamExample 请求参数示例
     * {
     *     ids: '' // ID
     * }
     * @apiSuccessExample 响应结果示例
     * {
     *     code: 0,
     *     status: 'success',
     *     message: '成功!'
     * }
     */
    @PostMapping("/console/article/delete")
    public R delete(@RequestBody List<Integer> ids) {
        articleService.removeBatchByIds(ids);
        return R.success();
    }

    /**
     * 是否推荐
     *
     * @api {POST} /slipper/console/article/recommended recommended
     * @apiDescription 文章是否推荐
     * @apiVersion 1.0.0
     * @apiGroup Article
     * @apiName recommended
     * @apiParamExample 请求参数示例
     * {
     *     key: '', // ID
     *     value: '' // 0：不推荐 1：推荐
     * }
     * @apiSuccessExample 响应结果示例
     * {
     *     code: 0,
     *     status: 'success',
     *     message: '成功!'
     * }
     */
    @PostMapping("/console/article/recommended")
    public R recommended(@RequestBody @Validated StatusVo<Integer, Integer> statusVo){
        ArticleEntity article = new ArticleEntity();
        article.setId(statusVo.getKey());
        article.setRecommended(statusVo.getValue());

        articleService.updateById(article);
        return R.success();
    }

    /**
     * 是否可评论
     *
     * @api {POST} /slipper/console/article/commentable commentable
     * @apiDescription 文章是否可评论
     * @apiVersion 1.0.0
     * @apiGroup Article
     * @apiName commentable
     * @apiParamExample 请求参数示例
     * {
     *     key: '', // ID
     *     value: '' // 0：不可评论 1：可评论
     * }
     * @apiSuccessExample 响应结果示例
     * {
     *     code: 0,
     *     status: 'success',
     *     message: '成功!'
     * }
     */
    @PostMapping("/console/article/commentable")
    public R commentable(@RequestBody @Validated StatusVo<Integer, Integer> statusVo){
        ArticleEntity article = new ArticleEntity();
        article.setId(statusVo.getKey());
        article.setCommentable(statusVo.getValue());

        articleService.updateById(article);
        return R.success();
    }

    /**
     * 是否发布
     *
     * @api {POST} /slipper/console/article/published published
     * @apiDescription 文章是否发布
     * @apiVersion 1.0.0
     * @apiGroup Article
     * @apiName published
     * @apiParamExample 请求参数示例
     * {
     *     key: '', // ID
     *     value: '' // 0：不发布 1：发布
     * }
     * @apiSuccessExample 响应结果示例
     * {
     *     code: 0,
     *     status: 'success',
     *     message: '成功!'
     * }
     */
    @PostMapping("/console/article/published")
    public R published(@RequestBody @Validated StatusVo<Integer, Integer> statusVo){
        ArticleEntity article = new ArticleEntity();
        article.setId(statusVo.getKey());
        article.setPublished(statusVo.getValue());
        if (statusVo.getValue() == 1) {
            article.setPublishedAt(new Date());
        }
        articleService.updateById(article);
        return R.success();
    }

    /**
     * 最新发布列表
     *
     * @api {POST} /slipper/client/article/latest latest
     * @apiDescription 文章最新发布列表
     * @apiVersion 1.0.0
     * @apiGroup Article
     * @apiName latest
     * @apiParamExample 请求参数示例
     * {
     *     limit: '' // 数量
     * }
     * @apiSuccessExample 响应结果示例
     * {
     *     code: 0,
     *     status: 'success',
     *     message: '成功!',
     *     data: [{
     *         id: '', // ID
     *         title: '', // 标题
     *         describe: '', // 简介描述
     *         cover: '', // 封面图
     *         category_id: '', // 分类ID
     *         category_name: '', // 分类名称
     *         tags: [{
     *             id: '', // 标签ID
     *             name: '', // 标签名称
     *         }],
     *         praise: '', // 点赞数量
     *         comment: '', // 评论数量
     *         read: '', // 阅读量
     *         recommended: '', // 是否推荐：0-否 1-是
     *         commentable: '', // 是否可以评论：0-否 1-是
     *         published: '', // 是否发布：0-否 1-是
     *         published_at: '', // 发布时间
     *         created_at: '', // 创建时间
     *         updated_at: '' // 更新时间
     *     }]
     * }
     */
    @GetMapping("/client/article/latest")
    public R latest(int limit){
        return R.success(articleService.queryLatestPublished(limit));
    }

    /**
     * 获取推荐的文章
     *
     * @api {GET} /slipper/client/article/recommended recommended
     * @apiDescription 获取推荐的文章
     * @apiVersion 1.0.0
     * @apiGroup Article
     * @apiName recommended
     * @apiParamExample 请求参数示例
     * {
     *     limit: '' // 数量
     * }
     * @apiSuccessExample 响应结果示例
     * {
     *     code: 0,
     *     status: 'success',
     *     message: '成功!',
     *     data: [{
     *         id: '', // ID
     *         title: '', // 标题
     *         describe: '', // 标题
     *         cover: '', // 封面图
     *         published_at: '', // 发布时间
     *         created_at: '', // 创建时间
     *         updated_at: '', // 更新时间
     *     }]
     * }
     */
    @GetMapping("/client/article/recommended")
    public R recommendedArticle(int limit){
        return R.success(articleService.queryRecommended(limit));
    }

    /**
     * 获取人气的文章
     *
     * @api {GET} /slipper/client/article/read read
     * @apiDescription 获取推荐的文章
     * @apiVersion 1.0.0
     * @apiGroup Article
     * @apiName read
     * @apiParamExample 请求参数示例
     * {
     *     limit: '' // 数量
     * }
     * @apiSuccessExample 响应结果示例
     * {
     *     code: 0,
     *     status: 'success',
     *     message: '成功!',
     *     data: [{
     *         id: '', // ID
     *         title: '', // 标题
     *         describe: '', // 标题
     *         cover: '', // 封面图
     *         published_at: '', // 发布时间
     *         created_at: '', // 创建时间
     *         updated_at: '', // 更新时间
     *     }]
     * }
     */
    @GetMapping("/client/article/read")
    public R readArticle(int limit){
        return R.success(articleService.queryRead(limit));
    }

}
