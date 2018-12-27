package com.blackey.finance.component.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.finance.component.domain.AuditDetail;
import com.blackey.finance.dto.bo.AuditDetailBo;
import com.blackey.finance.dto.form.AuditDetailForm;
import com.blackey.mybatis.dao.BaseDAO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;


/**
 * 审批详情表 AuditDetailMapper
 * 
 * @author kaven
 * @date 2018-12-07 09:48:54
 */

public interface AuditDetailMapper extends BaseDAO<AuditDetail> {

    /**
     * 分页查询需求审批记录
     * @param form
     * @param page
     * @return
     */
    @Select("<script>" +
            "SELECT\n" +
            " ad.*,r.title as name,u.name as userName\t\n" +
            "FROM\n" +
            " t_audit_detail ad,\n" +
            " t_requirement_info r,\n" +
            " t_user_info u \n" +
            " WHERE\n" +
            " ad.object_id = r.id \n" +
            " AND r.open_id = u.open_id"+
            "<if test=\"form.auditStatus.value != 'DEFAULT' and form.auditStatus != null \">\n" +
            " AND r.audit_status = #{form.auditStatus.value} \n" +
            "</if>"+
            " order by r.created_date desc" +
            "</script>"
    )
    List<AuditDetailBo> queryRequireAuditListPage(@Param("form") AuditDetailForm form, Page<AuditDetailBo> page);

    /**
     * 分页查询项目审批记录
     * @param form
     * @param page
     * @return
     */
    @Select("<script>" +
            "SELECT\n" +
            " ad.*,p.name,u.name as userName\n" +
            "FROM\n" +
            " t_audit_detail ad,\n" +
            " t_project_info p,\n" +
            " t_user_info u \n" +
            " WHERE\n" +
            " ad.object_id = p.id \n" +
            " AND p.open_id = u.open_id"+
            "<if test=\"form.auditStatus != null and form.auditStatus.value != 'DEFAULT' \">" +
            " and p.audit_status = #{form.auditStatus.value}\n" +
            "</if>" +
            " order by p.created_date desc" +
            "</script>"
    )
    List<AuditDetailBo> queryProjectAuditListPage(@Param("form") AuditDetailForm form, Page<AuditDetailBo> page);

}
