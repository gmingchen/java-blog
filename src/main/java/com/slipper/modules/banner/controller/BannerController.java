package com.slipper.modules.banner.controller;

import com.slipper.common.utils.R;
import com.slipper.common.validator.group.Create;
import com.slipper.common.validator.group.Update;
import com.slipper.common.vo.StatusVo;
import com.slipper.modules.banner.entity.BannerEntity;
import com.slipper.modules.banner.service.BannerService;
import com.slipper.modules.banner.model.vo.BannerPageVo;
import com.slipper.modules.user.entity.UserEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 轮播图
 *
 * @author gumingchen
 * @email 1240235512@qq.com
 * @date 1995-08-30 00:00:00
 */
@RestController
public class BannerController {
    @Resource
    private BannerService bannerService;

    /**
     * 分页列表
     *
     * @api {GET} /slipper/console/banner/page page
     * @apiDescription 轮播图分页列表
     * @apiVersion 1.0.0
     * @apiGroup Banner
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
     *         	   title: '', // 标题
     *         	   image: '', // 图片
     *         	   watermark: '', // 水印图片
     *         	   url: '', // 跳转路径
     *         	   type: '', // 类型 0-http 1-路由
     *         	   sort: '', // 排序
     *         	   status: '', // 状态 0-禁用 1-启用
     *             created_at: '', // 创建时间
     *             updated_at: '' // 更新时间
     *         }]
     *     }
     * }
     */
    @GetMapping("/console/banner/page")
    public R page(BannerPageVo bannerPageVo){
        return R.success(bannerService.queryPage(bannerPageVo));
    }

    /**
     * 信息
     *
     * @api {GET} /slipper/console/banner/info info
     * @apiDescription 轮播图信息
     * @apiVersion 1.0.0
     * @apiGroup Banner
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
     *         image: '', // 图片
     *         watermark: '', // 水印图片
     *         url: '', // 跳转路径
     *         type: '', // 类型 0-http 1-路由
     *         sort: '', // 排序
     *         status: '', // 状态 0-禁用 1-启用
     *         created_at: '', // 创建时间
     *         updated_at: '' // 更新时间
     *     }
     * }
     */
    @GetMapping("/console/banner/info")
    public R info(Integer id){
        return R.success(bannerService.getById(id));
    }

    /**
     * 新增
     *
     * @api {POST} /slipper/console/banner/create create
     * @apiDescription 轮播图新增
     * @apiVersion 1.0.0
     * @apiGroup Banner
     * @apiName create
     * @apiParamExample 请求参数示例
     * {
     *     title: '', // 标题
     *     image: '', // 图片
     *     watermark: '', // 水印图片
     *     url: '', // 跳转路径
     *     type: '', // 类型 0-http 1-路由
     *     sort: '', // 排序
     *     status: '', // 状态 0-禁用 1-启用
     * }
     * @apiSuccessExample 响应结果示例
     * {
     *     code: 0,
     *     status: 'success',
     *     message: '成功!'
     * }
     */
    @PostMapping("/console/banner/create")
    public R create(@RequestBody @Validated(Create.class) BannerEntity bannerEntity){
        bannerService.create(bannerEntity);
        return R.success();
    }

    /**
     * 编辑
     *
     * @api {POST} /slipper/console/banner/update update
     * @apiDescription 轮播图编辑
     * @apiVersion 1.0.0
     * @apiGroup Banner
     * @apiName update
     * @apiParamExample 请求参数示例
     * {
     *     id: '', // ID
     *     title: '', // 标题
     *     image: '', // 图片
     *     watermark: '', // 水印图片
     *     url: '', // 跳转路径
     *     type: '', // 类型 0-http 1-路由
     *     sort: '', // 排序
     *     status: '', // 状态 0-禁用 1-启用
     * }
     * @apiSuccessExample 响应结果示例
     * {
     *     code: 0,
     *     status: 'success',
     *     message: '成功!'
     * }
     */
    @PostMapping("/console/banner/update")
    public R update(@RequestBody @Validated(Update.class) BannerEntity bannerEntity){
        bannerService.update(bannerEntity);
        return R.success();
    }

    /**
     * 批量删除
     *
     * @api {POST} /slipper/console/banner/delete delete
     * @apiDescription 轮播图批量删除
     * @apiVersion 1.0.0
     * @apiGroup Banner
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
    @PostMapping("/console/banner/delete")
    public R delete(@RequestBody List<Integer> ids) {
        bannerService.removeBatchByIds(ids);
        return R.success();
    }

    /**
     * 启用 / 禁用
     *
     * @api {POST} /slipper/console/banner/status status
     * @apiDescription 是否禁用
     * @apiVersion 1.0.0
     * @apiGroup Banner
     * @apiName status
     * @apiParamExample 请求参数示例
     * {
     *     key: '', // ID
     *     value: '' // 0：禁用 1：启用
     * }
     * @apiSuccessExample 响应结果示例
     * {
     *     code: 0,
     *     status: 'success',
     *     message: '成功!'
     * }
     */
    @PostMapping("/console/banner/status")
    public R status(@RequestBody @Validated StatusVo<Integer, Integer> statusVo){
        BannerEntity banner = new BannerEntity();
        banner.setId(statusVo.getKey());
        banner.setStatus(statusVo.getValue());

        bannerService.updateById(banner);

        return R.success();
    }

//    /**
//     * 所有列表
//     *
//     * @api {GET} /slipper/console/banner/list
//     * @apiDescription 所有轮播图列表
//     * @apiVersion 1.0.0
//     * @apiGroup Banner
//     * @apiName list
//     * @apiParamExample 请求参数示例
//     * {
//     * }
//     * @apiSuccessExample 响应结果示例
//     * {
//     *     code: 0,
//     *     status: 'success',
//     *     message: '成功!',
//     *     data: [{
//     *         id: '', // ID
//     *         name: '', // 用户名
//     *         created_at: '', // 创建时间
//     *         updated_at: '' // 更新时间
//     *     }
//     * }
//     */
//    @GetMapping("/client/banner/list")
//    public R list(){
//        return R.success(bannerService.list());
//    }
}
