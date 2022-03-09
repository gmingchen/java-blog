package com.slipper.modules.praise.controller;

import com.slipper.common.utils.R;
import com.slipper.common.validator.group.Create;
import com.slipper.common.validator.group.Update;
import com.slipper.modules.praise.service.PraiseService;
import com.slipper.modules.tag.entity.TagEntity;
import com.slipper.modules.tag.model.vo.TagPageVo;
import com.slipper.modules.tag.service.TagService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 文章点赞
 *
 * @author gumingchen
 * @email 1240235512@qq.com
 * @date 1995-08-30 00:00:00
 */
@RestController
public class PraiseController {
    @Resource
    private PraiseService praiseService;

//    /**
//     * 分页列表
//     *
//     * @api {GET} /slipper/console/tag/page page
//     * @apiDescription 标签分页列表
//     * @apiVersion 1.0.0
//     * @apiGroup Tag
//     * @apiName page
//     * @apiParamExample 请求参数示例
//     * {
//     *     page: 1, // 当前页
//     *     size: 10, // 页面大小
//     *     name: '', // 名称
//     * }
//     * @apiSuccessExample 响应结果示例
//     * {
//     *     code: 0,
//     *     status: 'success',
//     *     message: '成功!',
//     *     data: {
//     *         current: 1, // 当前页
//     *         size: 1, // 页面大小
//     *         total: 1, // 总条数
//     *         pages: 1, // 总页数
//     *         list: [{
//     *         	   id: '', // ID
//     *         	   name: '', // 用户名
//     *             created_at: '', // 创建时间
//     *             updated_at: '' // 更新时间
//     *         }]
//     *     }
//     * }
//     */
//    @GetMapping("/console/tag/page")
//    public R page(TagPageVo tagPageVo){
//        return R.success(tagService.queryPage(tagPageVo));
//    }
//
//    /**
//     * 信息
//     *
//     * @api {GET} /slipper/console/tag/info info
//     * @apiDescription 标签信息
//     * @apiVersion 1.0.0
//     * @apiGroup Tag
//     * @apiName info
//     * @apiParamExample 请求参数示例
//     * {
//     *     id: '', // ID
//     * }
//     * @apiSuccessExample 响应结果示例
//     * {
//     *     code: 0,
//     *     status: 'success',
//     *     message: '成功!',
//     *     data: {
//     *         id: '', // ID
//     *         name: '', // 名称
//     *         created_at: '', // 创建时间
//     *         updated_at: '' // 更新时间
//     *     }
//     * }
//     */
//    @GetMapping("/console/tag/info")
//    public R info(Integer id){
//        return R.success(tagService.getById(id));
//    }
//
//    /**
//     * 新增
//     *
//     * @api {POST} /slipper/console/tag/create create
//     * @apiDescription 标签新增
//     * @apiVersion 1.0.0
//     * @apiGroup Tag
//     * @apiName create
//     * @apiParamExample 请求参数示例
//     * {
//     *     name: '', // 名称
//     * }
//     * @apiSuccessExample 响应结果示例
//     * {
//     *     code: 0,
//     *     status: 'success',
//     *     message: '成功!'
//     * }
//     */
//    @PostMapping("/console/tag/create")
//    public R create(@RequestBody @Validated(Create.class) TagEntity tagEntity){
//        tagService.create(tagEntity);
//        return R.success();
//    }
//
//    /**
//     * 编辑
//     *
//     * @api {POST} /slipper/console/tag/update update
//     * @apiDescription 标签编辑
//     * @apiVersion 1.0.0
//     * @apiGroup Tag
//     * @apiName update
//     * @apiParamExample 请求参数示例
//     * {
//     *     id: '', // ID
//     *     name: '', // 名称
//     * }
//     * @apiSuccessExample 响应结果示例
//     * {
//     *     code: 0,
//     *     status: 'success',
//     *     message: '成功!'
//     * }
//     */
//    @PostMapping("/console/tag/update")
//    public R update(@RequestBody @Validated(Update.class) TagEntity tagEntity){
//        tagService.update(tagEntity);
//        return R.success();
//    }
//
//    /**
//     * 批量删除
//     *
//     * @api {POST} /slipper/console/tag/delete delete
//     * @apiDescription 标签批量删除
//     * @apiVersion 1.0.0
//     * @apiGroup Tag
//     * @apiName delete
//     * @apiParamExample 请求参数示例
//     * {
//     *     ids: '' // ID
//     * }
//     * @apiSuccessExample 响应结果示例
//     * {
//     *     code: 0,
//     *     status: 'success',
//     *     message: '成功!'
//     * }
//     */
//    @PostMapping("/console/tag/delete")
//    public R delete(@RequestBody List<Integer> ids) {
//        tagService.removeBatchByIds(ids);
//        return R.success();
//    }
//
//    /**
//     * 所有列表
//     *
//     * @api {GET} /slipper/console/tag/list
//     * @apiDescription 所有标签列表
//     * @apiVersion 1.0.0
//     * @apiGroup Tag
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
//    @GetMapping("/console/tag/list")
//    public R list(){
//        return R.success(tagService.list());
//    }

}
