package com.blackey.tenant.rest;

import com.blackey.common.result.Result;
import com.blackey.tenant.component.domain.SysUserEntity;
import com.blackey.tenant.component.domain.SysUserTokenEntity;
import com.blackey.tenant.component.service.SysCaptchaService;
import com.blackey.tenant.component.service.SysUserService;
import com.blackey.tenant.component.service.SysUserTokenService;
import com.blackey.tenant.dto.form.JWTInfoForm;
import com.blackey.tenant.dto.form.SysLoginForm;
import com.blackey.tenant.global.constants.TenantResultEnum;
import com.blackey.tenant.util.JWTUtil;
import org.apache.commons.io.IOUtils;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * 登录相关
 * 
 * @author kavenW
 *
 * @date 2016年11月10日 下午1:15:31
 */
@RestController
public class SysLoginController extends AbstractController {
	@Autowired
	private SysUserService sysUserService;
	@Autowired
	private SysUserTokenService sysUserTokenService;
	@Autowired
	private SysCaptchaService sysCaptchaService;

	@Value(value = "${application.captcha.enabled:true}")
	private boolean captchaEnabled;

	/**
	 * 验证码
	 */
	@GetMapping("/sys/captcha.jpg")
	public void captcha(HttpServletResponse response, String uuid)throws IOException {
		response.setHeader("Cache-Control", "no-store, no-cache");
		response.setContentType("image/jpeg");

		//获取图片验证码
		BufferedImage image = sysCaptchaService.getCaptcha(uuid);

		ServletOutputStream out = response.getOutputStream();
		ImageIO.write(image, "jpg", out);
		IOUtils.closeQuietly(out);
	}

	/**
	 * 登录
	 */
	@PostMapping("/sys/login")
	public Result login(@RequestBody SysLoginForm form)throws IOException {

	    if(captchaEnabled){
            boolean captcha = sysCaptchaService.validate(form.getUuid(), form.getCaptcha());
            if(!captcha){
                return failure(TenantResultEnum.CAPTCHA_VALID_ERROR);
            }
        }

		//用户信息
		SysUserEntity user = sysUserService.queryByUserName(form.getUsername());

		//账号不存在、密码错误
		if(user == null || !user.getPassword().equals(new Sha256Hash(form.getPassword(), user.getSalt()).toHex())) {
			return failure(TenantResultEnum.PASSWORD_ACCOUNT_ERROR);
		}

		//账号锁定
		if(user.getStatus() == 0){
			return failure(TenantResultEnum.USER_UNENABLE_ERROR);
		}

		JWTInfoForm infoForm = new JWTInfoForm();
		infoForm.setUserId(String.valueOf(user.getUserId()));
		infoForm.setUserName(user.getUsername());
		infoForm.setSecret(user.getPassword());
		infoForm.setExpireTime(5*60*1000);

		//生成token，并保存到数据库
        //SysUserTokenEntity sysUserTokenEntity = sysUserTokenService.createToken(user.getUserId());
		return success(JWTUtil.generToken(infoForm));
	}


	/**
	 * 退出
	 */
	@PostMapping("/sys/logout")
	public Result logout() {
		//sysUserTokenService.logout(getUserId());
		return success();
	}
	
}
