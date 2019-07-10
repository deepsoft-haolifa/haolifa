package com.deepsoft.haolifa.controller;

import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.service.SysUserService;
import com.deepsoft.haolifa.validator.ValidateCode;
import com.deepsoft.haolifa.validator.ValidateCodeGenerator;
import com.deepsoft.haolifa.validator.image.ImageCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Api(tags = {"登录登出"})
@RestController
public class LoginController {

    @Autowired
    private SysUserService userService;

    @Autowired
    ValidateCodeGenerator validateCodeGenerator;


    @GetMapping("/self/info")
    @ApiOperation("获取当前用户信息")
    public ResultBean index() {
        return ResultBean.success(userService.selectUserInfo());
    }

    @ApiOperation("登录")
    @PostMapping("/login")
    public ResultBean login(String username, String password, String imageCode){
        return ResultBean.success(userService.selectUserInfo());
    }

    @ApiOperation("登出")
    @PostMapping("/logout")
    public ResultBean logout(){
        return ResultBean.success("注销成功");
    }

    @ApiOperation("获取图片验证码")
    @GetMapping(value = "/code/image", produces = {"image/jpeg"})
    public void createCode(HttpServletRequest request, HttpServletResponse response,
                           HttpSession httpSession) throws Exception {
        ImageCode imageCode = (ImageCode)validateCodeGenerator.generate(new ServletWebRequest(request, response));
        ValidateCode validateCode = new ValidateCode(imageCode.getCode(), imageCode.getExpireTime());
        httpSession.removeAttribute(ValidateCode.IMAGE_VALIDATE_CODE);
        httpSession.setAttribute(ValidateCode.IMAGE_VALIDATE_CODE, validateCode);
        response.setContentType("image/jpeg");
        ImageIO.write(imageCode.getImage(), "JPEG", response.getOutputStream());
    }

}
