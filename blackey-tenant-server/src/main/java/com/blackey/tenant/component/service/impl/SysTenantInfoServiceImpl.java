package com.blackey.tenant.component.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.blackey.tenant.component.domain.SysTenantMenu;
import com.blackey.tenant.component.domain.SysUserEntity;
import com.blackey.tenant.component.service.SysTenantMenuService;
import com.blackey.tenant.component.service.SysUserService;
import com.blackey.tenant.dto.form.SysTenantInfoForm;
import com.blackey.tenant.global.constants.RoleEnum;
import com.blackey.tenant.global.constants.StatusEnum;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.mybatis.service.impl.BaseServiceImpl;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.mybatis.utils.Query;

import com.blackey.tenant.component.mapper.SysTenantInfoMapper;
import com.blackey.tenant.component.domain.SysTenantInfo;
import com.blackey.tenant.component.service.SysTenantInfoService;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 租户信息 SysTenantInfoServiceImpl
 *
 * @author kaven
 * @date 2018-12-12 11:23:05
 */
@Service
public class SysTenantInfoServiceImpl extends BaseServiceImpl<SysTenantInfoMapper, SysTenantInfo> implements SysTenantInfoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SysTenantInfoServiceImpl.class);

    @Autowired
    SysTenantMenuService sysTenantMenuService;
    @Autowired
    SysUserService sysUserService;
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<SysTenantInfo> page = (Page<SysTenantInfo>) this.page(
                new Query<SysTenantInfo>(params).getPage(),
                new QueryWrapper<SysTenantInfo>()
        );

        return new PageUtils(page);
    }

    /**
     * 分页查询
     *
     * @param form
     * @param page
     * @return
     */
    @Override
    public IPage<SysTenantInfo> listPage(SysTenantInfoForm form, Page<SysTenantInfo> page) {
        SysTenantInfo sysTenantInfo = new SysTenantInfo();
        BeanUtils.copyProperties(form,sysTenantInfo);

        return this.page(page, new QueryWrapper<SysTenantInfo>().setEntity(sysTenantInfo));


    }

    /**
     * 创建租户
     *
     * @param sysTenantInfo
     */
    @Override
    public void saveTenant(SysTenantInfo sysTenantInfo) {

        baseMapper.insert(sysTenantInfo);
        /**
         * 保存租户和菜单关联关系
         */
        sysTenantMenuService.saveOrUpdateTenantMenu(sysTenantInfo.getId(),sysTenantInfo.getMenuIdList());
        //初始化租户管理员
        SysUserEntity user = new SysUserEntity();
        user.setCreateTime(new Date());
        //sha256加密
        String salt = RandomStringUtils.randomAlphanumeric(20);
        user.setPassword(new Sha256Hash(sysTenantInfo.getUserName(), salt).toHex());
        user.setSalt(salt);
        user.setMobile(sysTenantInfo.getTelephone());
        user.setEmail(sysTenantInfo.getEmail());
        user.setUsername(sysTenantInfo.getUserName());
        user.setTenantId(sysTenantInfo.getId());
        user.setRoleType(RoleEnum.ROLE_ADMIN.getCode());
        user.setStatus(StatusEnum.SATUS_EANBLE.getCode());
        sysUserService.save(user);

    }

    /**
     * 更新租户信息
     *
     * @param sysTenantInfo
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void updateTenant(SysTenantInfo sysTenantInfo) {
        baseMapper.updateById(sysTenantInfo);
        /**
         * 保存租户和菜单关联关系
         */
        sysTenantMenuService.saveOrUpdateTenantMenu(sysTenantInfo.getId(),sysTenantInfo.getMenuIdList());
    }

    /**
     * 删除租户
     *
     * @param id
     */
    @Override
    public void deleteTenant(String id) {
        baseMapper.deleteById(id);

        //删除租户和菜单关联信息
        sysTenantMenuService.remove(new QueryWrapper<SysTenantMenu>().eq("tenant_id",id));
        
    }

}
