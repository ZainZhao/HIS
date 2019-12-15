package com.neu.his.api.app.controller;

import com.neu.his.common.api.CommonResult;
import com.neu.his.common.dto.app.AppDocSkdResult;
import com.neu.his.common.dto.app.AppRegistrationParam;
import com.neu.his.common.dto.app.AppStaffDescriptionResult;
import com.neu.his.common.dto.pms.PmsPatientResult;
import com.neu.his.common.dto.sms.SmsDeptResult;
import com.neu.his.common.dto.sms.SmsSkdParam;
import com.neu.his.common.dto.sms.SmsSkdResult;
import com.neu.his.dms.service.DmsRegistrationService;
import com.neu.his.pms.service.PmsPatientService;
import com.neu.his.sms.SmsDeptService;
import com.neu.his.sms.SmsDescriptionService;
import com.neu.his.sms.SmsSkdService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
@Api(tags = "AppRegistrationController", description = "APP 挂号管理")
@RequestMapping("/appRegistration")
@CrossOrigin(allowCredentials = "true")
public class AppRegistrationController {

    @Autowired
    private SmsDeptService smsDeptService;

    @Autowired
    private SmsSkdService smsSkdService;

    @Autowired
    private DmsRegistrationService dmsRegistrationService;

    @Autowired
    private PmsPatientService pmsPatientService;

    @Autowired
    private SmsDescriptionService smsDescriptionService;
    /**
     * 描述:患者手机端登录
     * <p>author: ma
     */
    @ApiOperation("患者 手机端登录")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<PmsPatientResult> login(@RequestParam("identificationNo") String identificationNo,
                                                @RequestParam("medicalRecordNo") String medicalRecordNo){
        PmsPatientResult result = pmsPatientService.patientLogin(identificationNo ,medicalRecordNo);
        if(result == null){
            return  CommonResult.failed("登录失败");
        }else {
            return CommonResult.success(result,"登录成功");
        }
    }

    /**
     * 描述:查询所有科室
     * <p>author: ma
     */
    @ApiOperation("查询所有科室")
    @RequestMapping(value = "/listAllDept", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<SmsDeptResult>> listAllDept(){
        List<SmsDeptResult> list = smsDeptService.selectAll();
        return CommonResult.success(list);
    }

    /**
     * 描述:查询对应科室所有专家
     * <p>author: ma
     */
    @ApiOperation("查询某个科室所有专家")
    @RequestMapping(value = "/listDeptDoctor", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<List<AppStaffDescriptionResult>> listDeptDoctor(@RequestParam("deptId") Long deptId){
        List<AppStaffDescriptionResult> list = smsDescriptionService.getDetailListByDept(deptId);
        return CommonResult.success(list);
    }

    /**
     * 描述:查询对应专家所有排班及描述信息
     * <p>author: ma
     */
    @ApiOperation("查询某个专家所有排班及描述信息")
    @RequestMapping(value = "/listDoctorSkd", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<AppDocSkdResult> listDoctorSkd(@RequestParam("staffId") Long staffId,
                                                       @RequestParam(value = "endDate",required = false) Date endDate){
        SmsSkdParam smsSkdParam = new SmsSkdParam();
        smsSkdParam.setStaffId(staffId);
        Calendar calendar = Calendar.getInstance();
        //设置起始时间为当天00:00:00.0
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        smsSkdParam.setStartDate(calendar.getTime());

        //设置截止时间为最后一天23:59:59.0
        if(endDate != null){
            calendar.setTime(endDate);
            calendar.set(Calendar.HOUR_OF_DAY, 23);
            calendar.set(Calendar.MINUTE, 59);
            calendar.set(Calendar.SECOND, 59);
            calendar.set(Calendar.MILLISECOND, 0);
            smsSkdParam.setEndDate(calendar.getTime());
        }

        List<SmsSkdResult> skdResultList = smsSkdService.listSkd(smsSkdParam);
        AppDocSkdResult result = smsDescriptionService.getDetailById(staffId);
        if(result != null){
            result.setSkdResultList(skdResultList);
        }

        return CommonResult.success(result);
    }

    /**
     * 描述:手机端挂号
     * <p>author: ma
     */
    @ApiOperation("挂号")
    @RequestMapping(value = "/appReg", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult registration(@RequestBody AppRegistrationParam appRegistrationParam, BindingResult result){
        int count = dmsRegistrationService.appRegistration(appRegistrationParam);
        if(count > 0){
            return CommonResult.success(count, "挂号成功");
        }
        return CommonResult.failed("挂号失败");
    }
}
