package com.slipper.modules.category.controller;

import com.slipper.common.utils.R;
import com.slipper.common.validator.group.Create;
import com.slipper.common.validator.group.Update;
import com.slipper.modules.category.entity.CategoryEntity;
import com.slipper.modules.category.service.CategoryService;
import com.slipper.modules.category.model.vo.CategoryPageVo;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 分类
 *
 * @author gumingchen
 * @email 1240235512@qq.com
 * @date 1995-08-30 00:00:00
 */
@RestController
public class CategoryController {
    @Resource
    private CategoryService categoryService;

    /**
     * 分页列表
     *
     * @api {GET} /slipper/console/category/page page
     * @apiDescription 分类分页列表
     * @apiVersion 1.0.0
     * @apiGroup Category
     * @apiName page
     * @apiParamExample 请求参数示例
     * {
     *     page: 1, // 当前页
     *     size: 10, // 页面大小
     *     name: '', // 名称
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
     *         	   name: '', // 用户名
     *             created_at: '', // 创建时间
     *             updated_at: '' // 更新时间
     *         }]
     *     }
     * }
     */
    @GetMapping("/console/category/page")
    public R page(CategoryPageVo categoryPageVo){
        return R.success(categoryService.queryPage(categoryPageVo));
    }

    /**
     * 信息
     *
     * @api {GET} /slipper/console/category/info info
     * @apiDescription 分类信息
     * @apiVersion 1.0.0
     * @apiGroup Category
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
     *         name: '', // 名称
     *         created_at: '', // 创建时间
     *         updated_at: '' // 更新时间
     *     }
     * }
     */
    @GetMapping("/console/category/info")
    public R info(Integer id){
        return R.success(categoryService.getById(id));
    }

    /**
     * 新增
     *
     * @api {POST} /slipper/console/category/create create
     * @apiDescription 分类新增
     * @apiVersion 1.0.0
     * @apiGroup Category
     * @apiName create
     * @apiParamExample 请求参数示例
     * {
     *     name: '', // 名称
     * }
     * @apiSuccessExample 响应结果示例
     * {
     *     code: 0,
     *     status: 'success',
     *     message: '成功!'
     * }
     */
    @PostMapping("/console/category/create")
    public R create(@RequestBody @Validated(Create.class) CategoryEntity categoryEntity){
        categoryService.create(categoryEntity);
        return R.success();
    }

    /**
     * 编辑
     *
     * @api {POST} /slipper/console/category/update update
     * @apiDescription 分类编辑
     * @apiVersion 1.0.0
     * @apiGroup Category
     * @apiName update
     * @apiParamExample 请求参数示例
     * {
     *     id: '', // ID
     *     name: '', // 名称
     * }
     * @apiSuccessExample 响应结果示例
     * {
     *     code: 0,
     *     status: 'success',
     *     message: '成功!'
     * }
     */
    @PostMapping("/console/category/update")
    public R update(@RequestBody @Validated(Update.class) CategoryEntity categoryEntity){
        categoryService.update(categoryEntity);
        return R.success();
    }

    /**
     * 批量删除
     *
     * @api {POST} /slipper/console/category/delete delete
     * @apiDescription 分类批量删除
     * @apiVersion 1.0.0
     * @apiGroup Category
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
    @PostMapping("/console/category/delete")
    public R delete(@RequestBody List<Integer> ids) {
        categoryService.removeBatchByIds(ids);
        return R.success();
    }

    /**
     * 所有列表
     *
     * @api {GET} /slipper/console/category/list
     * @apiDescription 所有分类列表
     * @apiVersion 1.0.0
     * @apiGroup Category
     * @apiName list
     * @apiParamExample 请求参数示例
     * {
     * }
     * @apiSuccessExample 响应结果示例
     * {
     *     code: 0,
     *     status: 'success',
     *     message: '成功!',
     *     data: [{
     *         id: '', // ID
     *         name: '', // 用户名
     *         created_at: '', // 创建时间
     *         updated_at: '' // 更新时间
     *     }
     * }
     */
    @GetMapping("/console/category/list")
    public R list(){
        return R.success(categoryService.list());
    }

    /**
     * 所有列表
     *
     * @api {GET} /slipper/client/category/list
     * @apiDescription 所有分类列表
     * @apiVersion 1.0.0
     * @apiGroup Category
     * @apiName list
     * @apiParamExample 请求参数示例
     * {
     * }
     * @apiSuccessExample 响应结果示例
     * {
     *     code: 0,
     *     status: 'success',
     *     message: '成功!',
     *     data: [{
     *         id: '', // ID
     *         name: '', // 用户名
     *         created_at: '', // 创建时间
     *         updated_at: '' // 更新时间
     *     }
     * }
     */
    @GetMapping("/client/category/list")
    public R allList(){
        return R.success(categoryService.list());
    }

    /**
     * 信息
     *
     * @api {GET} /slipper/client/category/info info
     * @apiDescription 分类信息
     * @apiVersion 1.0.0
     * @apiGroup Category
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
     *         name: '', // 名称
     *         created_at: '', // 创建时间
     *         updated_at: '' // 更新时间
     *     }
     * }
     */
    @GetMapping("/client/category/info")
    public R queryInfo(Integer id){
        return R.success(categoryService.getById(id));
    }

}
