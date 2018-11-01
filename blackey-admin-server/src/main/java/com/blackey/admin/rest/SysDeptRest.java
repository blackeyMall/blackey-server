package com.blackey.admin.rest;

import com.blackey.common.result.Result;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.admin.component.domain.SysDept;
import com.blackey.admin.component.service.SysDeptService;
import com.blackey.admin.dto.form.SysDeptForm;
import com.blackey.admin.global.constants.RoleEnum;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 部门管理 API REST
 *
 * @author kavenW
 * @date 2018-06-29 14:18:31
 */
@RestController
@RequestMapping("/sys/dept")
public class SysDeptRest extends AbstractController{

    private static final Logger LOGGER = LoggerFactory.getLogger(SysDeptRest.class);

    @Autowired
    private SysDeptService sysDeptService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public Result list(@RequestParam Map<String, Object> params){
        PageUtils page  = sysDeptService.queryPage(params);

        return success(page);
    }

    /**
     * 选择部门(添加、修改菜单)
     */
    @RequestMapping("/select")
    @RequiresPermissions("sys:dept:select")
    public Result select(){
        List<SysDept> deptList = sysDeptService.queryList(new HashMap<String, Object>());

        //添加一级部门
        if(getUserId() == RoleEnum.ROLE_SUPER.getCode()){
            SysDept root = new SysDept();
            root.setDeptId(0L);
            root.setName("一级部门");
            root.setParentId(-1L);
            //root.setOpen(true);
            deptList.add(root);
        }

        return success(deptList);
    }

    /**
     * 上级部门Id(管理员则为0)
     */
    @RequestMapping("/info")
    @RequiresPermissions("sys:dept:list")
    public Result info(){
        long deptId = 0;
        if(getUserId() != RoleEnum.ROLE_SUPER.getCode()){
            List<SysDept> deptList = sysDeptService.queryList(new HashMap<String, Object>());
            Long parentId = null;
            for(SysDept sysDeptEntity : deptList){
                if(parentId == null){
                    parentId = sysDeptEntity.getParentId();
                    continue;
                }

                if(parentId > sysDeptEntity.getParentId().longValue()){
                    parentId = sysDeptEntity.getParentId();
                }
            }
            deptId = parentId;
        }

        return success(deptId);
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{deptId}")
    @RequiresPermissions("sys:dept:info")
    public Result info(@PathVariable("deptId") Long deptId){
        SysDept dept = sysDeptService.getById(deptId);

        return success(dept);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:dept:save")
    public Result save(@RequestBody SysDeptForm deptForm){

        SysDept dept = new SysDept();
        BeanUtils.copyProperties(dept,deptForm);
        sysDeptService.save(dept);

        return success();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:dept:update")
    public Result update(@RequestBody SysDeptForm deptForm){
        SysDept dept = new SysDept();
        BeanUtils.copyProperties(dept,deptForm);
        sysDeptService.updateById(dept);

        return success();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:dept:delete")
    public Result delete(long deptId){
        //判断是否有子部门
        List<Long> deptList = sysDeptService.queryDetpIdList(deptId);
        if(deptList.size() > 0){
            return failure("请先删除子部门");
        }

        sysDeptService.removeById(deptId);

        return success();
    }
}
