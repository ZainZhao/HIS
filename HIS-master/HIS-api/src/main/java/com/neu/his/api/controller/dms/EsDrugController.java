package com.neu.his.api.controller.dms;

import com.neu.his.common.api.CommonPage;
import com.neu.his.common.api.CommonResult;
import com.neu.his.dms.model.EsDrug;
import com.neu.his.dms.service.EsDrugService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 搜索药品管理Controller
 * Created by wang on 2019/6/19.
 */
@Controller
@Api(tags = "EsDrugController", description = "搜索药品")
@RequestMapping("/esDrug")
public class EsDrugController {
    @Autowired
    private EsDrugService esDrugService;

    @ApiOperation(value = "从数据库中导出药品到ES")
    @RequestMapping(value = "/importAll", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<Integer> importAllList() {
        int count = esDrugService.importAll();
        return CommonResult.success(count);
    }

    @ApiOperation(value = "根据id删除药品")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<Object> delete(@PathVariable Long id) {
        esDrugService.delete(id);
        return CommonResult.success(null);
    }

    @ApiOperation(value = "根据ids删除药品")
    @RequestMapping(value = "/delete/batch", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<Object> delete(@RequestParam("ids") List<Long> ids) {
        esDrugService.delete(ids);
        return CommonResult.success(null);
    }

    @ApiOperation(value = "根据id新增药品")
    @RequestMapping(value = "/create/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<EsDrug> create(@PathVariable Long id) {
        EsDrug esDrug = esDrugService.create(id);
        if (esDrug != null) {
            return CommonResult.success(esDrug);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation(value = "简单搜索")
    @RequestMapping(value = "/search/simple", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<EsDrug>> search(@RequestParam(required = false) String keyword,
                                                   @RequestParam(required = false, defaultValue = "0") Integer pageNum,
                                                   @RequestParam(required = false, defaultValue = "5") Integer pageSize) {
        Page<EsDrug> esDrugPage = esDrugService.search(keyword, pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(esDrugPage));
    }


    @ApiOperation(value = "模糊搜索")
    @RequestMapping(value = "/search/fuzzy", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<EsDrug>> searchFuzzy(@RequestParam(required = false) String keyword,
                                                   @RequestParam(required = false, defaultValue = "0") Integer pageNum,
                                                   @RequestParam(required = false, defaultValue = "5") Integer pageSize) {
        Page<EsDrug> esDrugPage = esDrugService.searchFuzzy(keyword, pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(esDrugPage));
    }
}
