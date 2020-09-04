package org.analysis.controller;

import api.AjaxResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ChenDehua  597701764@qq.com
 * @date 2020/8/28 10:51
 */
@RestController
public class TestController {

    @PostMapping("sdsd")
    public AjaxResult test() {
        return AjaxResult.success();
    }
}
