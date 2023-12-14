package com.bou.wyj.controller;

import com.bou.wyj.domain.AjaxResult;
import com.bou.wyj.domain.SysRole;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

/**
 * 测试控制器
 *
 * @Author xiaoquan
 * @Date 2023/7/12 9:47
 */
@RestController
@Tag(name = "测试")
@RequestMapping("/test")
public class TestController {

    @Operation(summary = "测试接口", description = "用于演示接口的测试")
    @GetMapping("/testParam")
    public AjaxResult<SysRole> testApi(
            @Parameter(description = "用户ID", example = "123") @RequestParam Long userId,
            @Parameter(description = "商店ID", example = "456") @RequestParam Long shopId) {
        // 在这里编写你的业务逻辑，根据传递的userId和shopId生成响应
        String response = "Received userId: " + userId + ", shopId: " + shopId;
        SysRole sysRole = new SysRole();
        sysRole.setId(1L);
        sysRole.setName("name");
        sysRole.setRemark("remark");
        return AjaxResult.success(sysRole);
    }

}
