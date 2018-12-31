package com.blackey.admin.rest;

import com.blackey.admin.component.domain.SysUser;
import com.blackey.admin.component.domain.SysUserToken;
import com.blackey.admin.component.service.SysCaptchaService;
import com.blackey.admin.component.service.SysUserService;
import com.blackey.admin.component.service.SysUserTokenService;
import com.blackey.admin.dto.form.SysLoginForm;
import com.blackey.common.result.Result;
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
public class SysLoginRest extends AbstractController {
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
	public void captcha(HttpServletResponse response, String uuid)throws ServletException, IOException {
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
	public Result login(@RequestBody SysLoginForm form) {

	    if(captchaEnabled){
            boolean captcha = sysCaptchaService.validate(form.getUuid(), form.getCaptcha());
            if(!captcha){
                return failure("验证码不正确");
            }
        }

		//用户信息
		SysUser user = sysUserService.queryByUserAccount(form.getUsername());
		//账号不存在、密码错误
		if(user == null || !user.getPassword().equals(new Sha256Hash(form.getPassword(), user.getSalt()).toHex())) {
			return failure("账号或密码不正确");
		}

		//账号锁定
		if(user.getStatus() == 0){
			return failure("账号已被锁定,请联系管理员");
		}

		//生成token，并保存到数据库
        SysUserToken sysUserTokenEntity = sysUserTokenService.createToken(user.getId());
		return success(sysUserTokenEntity);
	}


	/**
	 * 退出
	 */
	@PostMapping("/sys/logout")
	public Result logout() {
		sysUserTokenService.logout(getUserId());
		return success();
	}
	
}
