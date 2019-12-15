package com.neu.his.cloud.api.pc.controller.sms;

import com.neu.his.cloud.api.pc.common.CommonPage;
import com.neu.his.cloud.api.pc.common.CommonResult;
import com.neu.his.cloud.api.pc.dto.sms.SmsDeptParam;
import com.neu.his.cloud.api.pc.dto.sms.SmsDeptResult;
import com.neu.his.cloud.api.pc.service.sms.SmsDeptService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "SmsDeptController", description = "科室管理")
@RequestMapping("/dept")
@CrossOrigin(allowCredentials = "true")
public class SmsDeptController {

    @Autowired
    private SmsDeptService smsDeptService;


    @ApiOperation("新增科室")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@RequestBody SmsDeptParam smsDeptParam, BindingResult result){
            return smsDeptService.create(smsDeptParam);
    }


    @ApiOperation("根据ids删除科室")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@RequestParam("ids") List<Long> ids){
        return   smsDeptService.delete(ids);
    }

    /**
     * 描述:更新一个科室的全部信息
     * <p>author: ma
     */
    @ApiOperation("更新科室信息")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@PathVariable("id") Long id,@RequestBody SmsDeptParam smsDeptParam, BindingResult result){
        return  smsDeptService.update(id,smsDeptParam);
    }


    @ApiOperation("模糊查询科室、且分页")
    @RequestMapping(value = "/select", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<CommonPage<SmsDeptResult>> list(@RequestBody SmsDeptParam queryParam,
                                                        @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                        @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum){

        return smsDeptService.list(queryParam,pageSize,pageNum);
    }

    @ApiOperation("查询所有科室")
    @RequestMapping(value = "/selectAll", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<SmsDeptResult>> listAll(){
        return  smsDeptService.listAll();
    }
}
