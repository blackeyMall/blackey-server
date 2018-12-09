package com.blackey.finance.dto.form;

import com.blackey.finance.global.constants.AddCancelEnum;
import lombok.Getter;
import lombok.Setter;

/**
 * 关注或取消
 * creat_user: kaven
 *
 * @date: 2018/12/9 17:40
 **/
@Setter
@Getter
public class AddOrCancelFollowForm {

    /**
     * 用户id
     */
    private String openId;
    /**
     * 关注的项目/需求
     */
    private String objectId;
    /**
     * add 关注  cancel 取消
     */
    private AddCancelEnum addCancel = AddCancelEnum.ADD;
}
