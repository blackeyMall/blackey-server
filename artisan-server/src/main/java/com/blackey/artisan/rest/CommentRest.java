package com.blackey.artisan.rest;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.artisan.component.domain.Comment;
import com.blackey.artisan.component.service.CommentService;
import com.blackey.artisan.component.service.PictureInfoService;
import com.blackey.artisan.dto.bo.CommentBo;
import com.blackey.artisan.dto.form.CommentForm;
import com.blackey.artisan.global.constants.PicTypeStatus;
import com.blackey.common.rest.BaseRest;
import com.blackey.common.result.Result;
import com.blackey.mybatis.utils.PageUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 *  API REST
 *
 * @author kaven
 * @date 2019-01-02 09:47:38
 */
@RestController
@RequestMapping("/artisan/comment")
public class CommentRest extends BaseRest {

    private static final Logger LOGGER = LoggerFactory.getLogger(CommentRest.class);

    @Autowired
    private CommentService commentService;

    @Autowired
    private PictureInfoService pictureInfoService;


    /**
    * 分页列表
    */
    @GetMapping("/list/page")
    public Result list(String openid,Page page) {

        return success(commentService.getByOpenid(openid, page));
    }

    /**
     * 列表
     */
    @PostMapping("/list")
    public Result list(@RequestBody CommentForm commentForm){

        return success();
    }


    /**
     * 查看详情信息
     */
    @GetMapping("/info")
    public Result info(@RequestParam("orderid") String orderid){
        CommentBo comment = null;
        try {
            comment = commentService.getByServiceId(orderid);
        } catch (Exception e) {
            logger.error("error from query detail!",e);
        }
        return success(comment);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public Result save(@RequestBody CommentForm commentForm){
        Comment comment = new Comment();
        //Form --> domain
        BeanUtils.copyProperties(commentForm,comment);
        commentService.save(comment);

        pictureInfoService.savePic(comment.getId(),commentForm.getPicUrl(), PicTypeStatus.COMMENT);
        return success();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    public Result update(@RequestBody Comment comment){

        commentService.updateById(comment);//全部更新
        
        return success();
    }

    /**
     * 根据主键id删除
     */
    @GetMapping("/delete/{comment}")
    public Result delete(@PathVariable("comment") Integer comment){

        commentService.removeById(comment);

        return success();
    }

}
