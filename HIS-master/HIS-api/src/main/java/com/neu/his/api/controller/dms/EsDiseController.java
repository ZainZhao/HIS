package com.neu.his.api.controller.dms;

import com.neu.his.common.api.CommonPage;
import com.neu.his.common.api.CommonResult;

import com.neu.his.dms.model.EsDise;
import com.neu.his.dms.service.EsDiseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 搜索疾病管理Controller
 * Created by wang on 2019/6/19.
 */
@Controller
@Api(tags = "EsDiseController", description = "搜索诊断")
@RequestMapping("/esDise")
public class EsDiseController {
    @Autowired
    private EsDiseService esDiseService;

    @ApiOperation(value = "从数据库中导出诊断到ES")
    @RequestMapping(value = "/importAll", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<Integer> importAllList() {
        int count = esDiseService.importAll();
        return CommonResult.success(count);
    }

    @ApiOperation(value = "根据id删除诊断")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<Object> delete(@PathVariable Long id) {
        esDiseService.delete(id);
        return CommonResult.success(null);
    }

    @ApiOperation(value = "根据ids删除诊断")
    @RequestMapping(value = "/delete/batch", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<Object> delete(@RequestParam("ids") List<Long> ids) {
        esDiseService.delete(ids);
        return CommonResult.success(null);
    }

    @ApiOperation(value = "根据id新增诊断")
    @RequestMapping(value = "/create/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<EsDise> create(@PathVariable Long id) {
        EsDise esDise = esDiseService.create(id);
        if (esDise != null) {
            return CommonResult.success(esDise);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation(value = "简单搜索")
    @RequestMapping(value = "/search/simple", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<EsDise>> search(@RequestParam(required = false) String keyword,
                                                   @RequestParam(required = false, defaultValue = "0") Integer pageNum,
                                                   @RequestParam(required = false, defaultValue = "5") Integer pageSize) {
        Page<EsDise> esDisePage = esDiseService.search(keyword, pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(esDisePage));
    }


    @ApiOperation(value = "模糊搜索")
    @RequestMapping(value = "/search/fuzzy", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<EsDise>> searchFuzzy(@RequestParam(required = false) String keyword,
                                                        @RequestParam(required = false, defaultValue = "0") Integer pageNum,
                                                        @RequestParam(required = false, defaultValue = "5") Integer pageSize) {
        Page<EsDise> esDisePage = esDiseService.searchFuzzy(keyword, pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(esDisePage));
    }
}
