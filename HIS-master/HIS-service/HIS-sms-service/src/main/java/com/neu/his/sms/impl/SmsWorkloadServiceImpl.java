package com.neu.his.sms.impl;

import com.neu.his.common.dto.sms.SmsWorkloadResult;
import com.neu.his.mbg.mapper.*;
import com.neu.his.mbg.model.*;
import com.neu.his.sms.SmsWorkloadService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;
/**
 * 工作量
 */
@Service
public class SmsWorkloadServiceImpl implements SmsWorkloadService {

    @Autowired
    private SmsStaffMapper smsStaffMapper;

    @Autowired
    private SmsDeptMapper smsDeptMapper;

    @Autowired
    private DmsMedicinePrescriptionRecordMapper dmsMedicinePrescriptionRecordMapper;

    @Autowired
    private DmsHerbalPrescriptionRecordMapper dmsHerbalPrescriptionRecordMapper;

    @Autowired
    private DmsNonDrugItemRecordMapper dmsNonDrugItemRecordMapper;

    @Autowired
    private SmsSkdMapper smsSkdMapper;

    @Autowired
    private DmsRegistrationMapper dmsRegistrationMapper;

    @Autowired
    private SmsRegistrationRankMapper smsRegistrationRankMapper;

    @Autowired
    private SmsWorkloadRecordMapper smsWorkloadRecordMapper;

    //个人工作量统计
    @Override
    public SmsWorkloadResult workloadPersonalStatistic(Long staffId, Date date){
        SmsWorkloadResult workload = new SmsWorkloadResult();
        workload.setWorkloadId(null);
        workload.setCreateTime(new Date());
        workload.setDate(date);

        //查询员工和挂号级别信息
        SmsStaff staff = smsStaffMapper.selectByPrimaryKey(staffId);
        if(staff == null){
            return null;
        }
        workload.setStaffId(staffId);
        workload.setStaffName(staff.getName());
        SmsRegistrationRank rank = smsRegistrationRankMapper.selectByPrimaryKey(staff.getRegistrationRankId());
        if(rank == null){
            return null;
        }

        //查询部门信息
        SmsDept dept = smsDeptMapper.selectByPrimaryKey(staff.getDeptId());
        if(dept == null){
            return null;
        }
        workload.setDeptId(dept.getId());
        workload.setDeptName(dept.getName());

        //设置处方单状态
        List<Integer> statusList = new ArrayList<>();
        statusList.add(2);
        statusList.add(3);
        //设置起始时间
        Date startDate = getBeginDate(date);
        //查询开立成药
        DmsMedicinePrescriptionRecordExample medicineExample = new DmsMedicinePrescriptionRecordExample();
        medicineExample.createCriteria().andCreateTimeBetween(startDate,date)
                .andCreateStaffIdEqualTo(staffId)
                .andStatusIn(statusList);
        List<DmsMedicinePrescriptionRecord> medicineList = dmsMedicinePrescriptionRecordMapper.selectByExample(medicineExample);
        BigDecimal medicineAmount = new BigDecimal(0);
        for(DmsMedicinePrescriptionRecord record : medicineList){
            medicineAmount = medicineAmount.add(record.getAmount());
        }
        workload.setMedicineAmount(medicineAmount);
        //查询开立草药
        DmsHerbalPrescriptionRecordExample herbalExample = new DmsHerbalPrescriptionRecordExample();
        herbalExample.createCriteria().andCreateTimeBetween(startDate,date)
                .andStatusIn(statusList)
                .andCreateStaffIdEqualTo(staffId);
        List<DmsHerbalPrescriptionRecord> herbalList = dmsHerbalPrescriptionRecordMapper.selectByExample(herbalExample);
        BigDecimal herbalAmount = new BigDecimal(0);
        for(DmsHerbalPrescriptionRecord record : herbalList){
            herbalAmount = herbalAmount.add(record.getAmount());
        }
        workload.setHerbalAmount(herbalAmount);

        //设置处方单状态
        List<Integer> nonDrugStatus = new ArrayList<>();
        nonDrugStatus.add(2);
        nonDrugStatus.add(3);
        nonDrugStatus.add(4);
        //查询检查
        DmsNonDrugItemRecordExample createCheckExample = new DmsNonDrugItemRecordExample();
        createCheckExample.createCriteria().andCreateTimeBetween(startDate,date)
                .andCreateStaffIdEqualTo(staffId)
                .andStatusIn(nonDrugStatus)
                .andTypeEqualTo(0);
        List<DmsNonDrugItemRecord> checkList = dmsNonDrugItemRecordMapper.selectByExample(createCheckExample);
        BigDecimal checkAmount = new BigDecimal(0);
        for(DmsNonDrugItemRecord record : checkList){
            checkAmount = checkAmount.add(record.getAmount());
        }
        workload.setCheckAmount(checkAmount);
        //查询检验
        DmsNonDrugItemRecordExample createTestExample = new DmsNonDrugItemRecordExample();
        createTestExample.createCriteria().andCreateTimeBetween(startDate,date)
                .andCreateStaffIdEqualTo(staffId)
                .andStatusIn(nonDrugStatus)
                .andTypeEqualTo(1);
        List<DmsNonDrugItemRecord> testList = dmsNonDrugItemRecordMapper.selectByExample(createTestExample);
        BigDecimal testAmount = new BigDecimal(0);
        for(DmsNonDrugItemRecord record : testList){
            testAmount = testAmount.add(record.getAmount());
        }
        workload.setTestAmount(testAmount);
        //查询处置
        DmsNonDrugItemRecordExample createDispositionExample = new DmsNonDrugItemRecordExample();
        createDispositionExample.createCriteria().andCreateTimeBetween(startDate,date)
                .andCreateStaffIdEqualTo(staffId)
                .andStatusIn(nonDrugStatus)
                .andTypeEqualTo(2);
        List<DmsNonDrugItemRecord> dispositionList = dmsNonDrugItemRecordMapper.selectByExample(createDispositionExample);
        BigDecimal dispositionAmount = new BigDecimal(0);
        for(DmsNonDrugItemRecord record : dispositionList){
            dispositionAmount = dispositionAmount.add(record.getAmount());
        }
        workload.setDispositionAmount(dispositionAmount);

        //查询挂号:通过医生id和日期，在sms-skd中找出skd_id（一天、可能为2个skd）,根据skd_id查询挂号表（count，status=2 or 3）
        SmsSkdExample skdExample = new SmsSkdExample();
        skdExample.createCriteria().andDateBetween(startDate,date).andStaffIdEqualTo(staffId);
        List<SmsSkd> skdList = smsSkdMapper.selectByExample(skdExample);
        List<Long> skdIdList = new ArrayList<>();
        for(SmsSkd skd : skdList){
            skdIdList.add(skd.getId());
        }
        if(skdIdList.isEmpty()){
            workload.setRegistrationAmount(new BigDecimal(0));
            workload.setRegistrationNum(new Long(0));
        }else{
            DmsRegistrationExample registrationExample = new DmsRegistrationExample();
            //设置挂号表状态
            List<Integer> registrationStatus = new ArrayList<>();
            registrationStatus.add(2);
            registrationStatus.add(3);
            registrationExample.createCriteria()
                    .andStatusIn(registrationStatus)
                    .andSkdIdIn(skdIdList)
                    .andAttendanceDateBetween(startDate,date);
            int size = dmsRegistrationMapper.countByExample(registrationExample);
            workload.setRegistrationNum(new Long(size));
            workload.setRegistrationAmount(rank.getPrice().multiply(new BigDecimal(size)));
        }

        //开立总钱数
        BigDecimal sum = medicineAmount.add(herbalAmount).add(checkAmount).add(testAmount).add(dispositionAmount).add(workload.getRegistrationAmount());
        workload.setAmount(sum);

        //执行检查总钱数
        DmsNonDrugItemRecordExample excuteCheckExample = new DmsNonDrugItemRecordExample();
        excuteCheckExample.createCriteria().andExcuteTimeBetween(startDate,date)
                .andExcuteStaffIdEqualTo(staffId)
                .andStatusEqualTo(4)
                .andTypeEqualTo(0);
        List<DmsNonDrugItemRecord> excuteCkeckList = dmsNonDrugItemRecordMapper.selectByExample(excuteCheckExample);
        BigDecimal excuteCkeckAmount = new BigDecimal(0);
        for(DmsNonDrugItemRecord record : excuteCkeckList){
            excuteCkeckAmount = excuteCkeckAmount.add(record.getAmount());
        }
        workload.setExcuteCheckAmount(excuteCkeckAmount);
        //执行检验总钱数
        DmsNonDrugItemRecordExample excuteTestExample = new DmsNonDrugItemRecordExample();
        excuteTestExample.createCriteria().andExcuteTimeBetween(startDate,date)
                .andExcuteStaffIdEqualTo(staffId)
                .andStatusEqualTo(4)
                .andTypeEqualTo(1);
        List<DmsNonDrugItemRecord> excuteTestList = dmsNonDrugItemRecordMapper.selectByExample(excuteTestExample);
        BigDecimal excuteTestAmount = new BigDecimal(0);
        for(DmsNonDrugItemRecord record : excuteTestList){
            excuteTestAmount = excuteTestAmount.add(record.getAmount());
        }
        workload.setExcuteTestAmount(excuteTestAmount);
        //执行处置总钱数
        DmsNonDrugItemRecordExample excuteDispositionExample = new DmsNonDrugItemRecordExample();
        excuteDispositionExample.createCriteria().andExcuteTimeBetween(startDate,date)
                .andExcuteStaffIdEqualTo(staffId)
                .andStatusEqualTo(4)
                .andTypeEqualTo(2);
        List<DmsNonDrugItemRecord> excuteDispositionList = dmsNonDrugItemRecordMapper.selectByExample(excuteDispositionExample);
        BigDecimal excuteDispositionAmount = new BigDecimal(0);
        for(DmsNonDrugItemRecord record : excuteDispositionList){
            excuteDispositionAmount = excuteDispositionAmount.add(record.getAmount());
        }
        workload.setExcuteDispositionAmount(excuteDispositionAmount);

        //执行人次
        DmsNonDrugItemRecordExample countExample = new DmsNonDrugItemRecordExample();
        countExample.createCriteria().andExcuteTimeBetween(startDate,date)
                .andExcuteStaffIdEqualTo(staffId)
                .andStatusEqualTo(4);
        workload.setExcuteNum(new Long(dmsNonDrugItemRecordMapper.countByExample(countExample)));

        //type设置为 0(个人)
        workload.setType(0);
        workload.setStatus(1);

        return workload;
    }

    //个人工作量时间段查询
    @Override
    public SmsWorkloadResult queryPersonalWorkloadPeriod(Long staffId ,Date startDatetime,Date endDatetime){
        //最后一天之前的，使用between,并累加
        SmsWorkloadRecordExample workloadRecordExample = new SmsWorkloadRecordExample();
        workloadRecordExample.createCriteria().andDateBetween(getBeginDate(startDatetime),getBeginDate(endDatetime))
                .andStaffIdEqualTo(staffId)
                .andStatusEqualTo(1)
                .andTypeEqualTo(0);
        List<SmsWorkloadRecord> workloadRecordList = smsWorkloadRecordMapper.selectByExample(workloadRecordExample);

        //添加最后一天的
        SmsWorkloadResult lastResult = workloadPersonalStatistic(staffId,endDatetime);
        SmsWorkloadRecord beforeRecord = addAll(workloadRecordList);

        //合并两个
        lastResult.setMedicineAmount(lastResult.getMedicineAmount().add(beforeRecord.getMedicineAmount()));
        lastResult.setHerbalAmount(lastResult.getHerbalAmount().add(beforeRecord.getHerbalAmount()));
        lastResult.setCheckAmount(lastResult.getCheckAmount().add(beforeRecord.getCheckAmount()));
        lastResult.setTestAmount(lastResult.getTestAmount().add(beforeRecord.getTestAmount()));
        lastResult.setDispositionAmount(lastResult.getDispositionAmount().add(beforeRecord.getDispositionAmount()));
        lastResult.setRegistrationAmount(lastResult.getRegistrationAmount().add(beforeRecord.getRegistrationAmount()));
        lastResult.setAmount(lastResult.getAmount().add(beforeRecord.getAmount()));

        lastResult.setRegistrationNum(lastResult.getRegistrationNum() + beforeRecord.getRegistrationNum());
        lastResult.setExcuteCheckAmount(lastResult.getExcuteCheckAmount().add(beforeRecord.getExcuteCheckAmount()));
        lastResult.setExcuteTestAmount(lastResult.getExcuteTestAmount().add(beforeRecord.getExcuteTestAmount()));
        lastResult.setExcuteDispositionAmount(lastResult.getExcuteDispositionAmount().add(beforeRecord.getExcuteDispositionAmount()));
        lastResult.setExcuteNum(lastResult.getExcuteNum() + beforeRecord.getExcuteNum());

        return lastResult;
    }

    //计算某个科室某一天
    @Override
    public SmsWorkloadResult workloadDeptStatistic(Long deptId,Date date){
        //在staff表中中根据科室id查找staffIds
        SmsStaffExample staffExample = new SmsStaffExample();
        staffExample.createCriteria().andDeptIdEqualTo(deptId).andStatusEqualTo(1);
        List<SmsStaff> staffList = smsStaffMapper.selectByExample(staffExample);
        List<Long> staffIdList = new ArrayList<>();
        for(SmsStaff staff : staffList){
            staffIdList.add(staff.getId());
        }
        List<SmsWorkloadRecord> workloadRecordList;
        if(staffIdList.isEmpty()){
            //当部门没有员工
            workloadRecordList = new ArrayList<>();
        }else{
            //根据staffIds、date、type为0，查找工作记录表中的记录，并求和(注：先查找type为0  个人的)
            SmsWorkloadRecordExample workloadRecordExample = new SmsWorkloadRecordExample();
            workloadRecordExample.createCriteria().andStatusEqualTo(1)
                    .andStaffIdIn(staffIdList)
                    .andDateBetween(getBeginDate(date),getEndDate(date))
                    .andTypeEqualTo(0);
            workloadRecordList = smsWorkloadRecordMapper.selectByExample(workloadRecordExample);
        }
        SmsWorkloadRecord workloadRecordSum = addAll(workloadRecordList);

        //数据封装成result
        SmsWorkloadResult result = new SmsWorkloadResult();
        BeanUtils.copyProperties(workloadRecordSum,result);
        result.setWorkloadId(null);
        result.setCreateTime(new Date());
        result.setDate(date);
        SmsDept dept = smsDeptMapper.selectByPrimaryKey(deptId);
        if(dept == null){
            return null;
        }
        result.setDeptName(dept.getName());
        result.setStatus(1);
        result.setType(1);
        result.setDeptId(dept.getId());

        return result;
    }

    //某个科室工作量时间段查询
    @Override
    public SmsWorkloadResult queryDeptWorkloadPeriod(Long deptId,Date startDatetime,Date endDatetime){
        //今日之前的，使用between,并累加
        SmsWorkloadRecordExample workloadRecordExample = new SmsWorkloadRecordExample();
        workloadRecordExample.createCriteria().andStatusEqualTo(1)
                .andTypeEqualTo(1)
                .andDeptIdEqualTo(deptId)
                .andDateBetween(getBeginDate(startDatetime),getBeginDate(endDatetime));
        List<SmsWorkloadRecord> workloadRecordList = smsWorkloadRecordMapper.selectByExample(workloadRecordExample);
        SmsWorkloadRecord workloadRecordSum = addAll(workloadRecordList);

        //封装result
        SmsWorkloadResult result = new SmsWorkloadResult();
        BeanUtils.copyProperties(workloadRecordSum,result);
        result.setWorkloadId(null);
        result.setCreateTime(new Date());
        result.setDate(null);
        SmsDept dept = smsDeptMapper.selectByPrimaryKey(deptId);
        if(dept == null){
            return null;
        }
        result.setDeptName(dept.getName());
        result.setStatus(1);
        result.setType(1);
        result.setDeptId(dept.getId());

        return result;
    }

    //所有科室工作量时间段统计
    @Override
    public List<SmsWorkloadResult> queryDeptWorkloadList(Date startDatetime,Date endDatetime){
        //在科室表中查询List<科室(Id,name)>遍历
        SmsDeptExample deptExample = new SmsDeptExample();
        deptExample.createCriteria().andStatusEqualTo(1);
        List<SmsDept> deptList = smsDeptMapper.selectByExample(deptExample);
        Map<Long, String> deptMap = new Hashtable<>();
        for(SmsDept dept : deptList){
            deptMap.put(dept.getId(),dept.getName());
        }

        //对每个科室Id调用科室工作量时间段统计(queryDeptWorkloadPeriod)
        List<SmsWorkloadResult> resultList = new ArrayList<>();
        for(Long key : deptMap.keySet()){
            resultList.add(queryDeptWorkloadPeriod(key,startDatetime,endDatetime));
        }

        return resultList;
    }

    //查询某个科室所有员工工作量时间段统计
    @Override
    public List<SmsWorkloadResult> queryDeptPersonalWorkloadList(Long deptId, Date startDatetime,Date endDatetime){
        //根据科室id查询List<员工(id，name)>
        SmsStaffExample staffExample = new SmsStaffExample();
        staffExample.createCriteria().andDeptIdEqualTo(deptId).andStatusEqualTo(1);
        List<SmsStaff> staffList = smsStaffMapper.selectByExample(staffExample);
        List<Long> staffIdList = new ArrayList<>();
        for(SmsStaff staff : staffList){
            staffIdList.add(staff.getId());
        }

        //遍历 调用个人工作量时间段查询
        List<SmsWorkloadResult> resultList = new ArrayList<>();
        for(Long id : staffIdList){
            SmsWorkloadResult result = queryPersonalWorkloadPeriod(id,startDatetime,endDatetime);
            resultList.add(result);
        }

        return resultList;
    }

    //工作量插入
    @Override
    public int insertWorkload(SmsWorkloadResult smsWorkLoadResult){
        //数据封装
        SmsWorkloadRecord record = new SmsWorkloadRecord();
        BeanUtils.copyProperties(smsWorkLoadResult,record);
        record.setId(null);
        record.setCreateTime(new Date());

        //结果插入统计表中
        return smsWorkloadRecordMapper.insertSelective(record);
    }

    //每日个人统计插入
    @Override
    public int dailyPersonalStatistic(Date date){
        SmsStaffExample staffExample = new SmsStaffExample();
        staffExample.createCriteria().andStatusEqualTo(1);
        List<SmsStaff> staffList = smsStaffMapper.selectByExample(staffExample);
        int countSum = 0;
        for(SmsStaff staff : staffList){
            SmsWorkloadResult result = workloadPersonalStatistic(staff.getId(),getEndDate(date));
            result.setDeptId(null);     //部门id设置为空
            countSum += insertWorkload(result);
        }

        return countSum;
    }

    //每日科室统计插入
    @Override
    public int dailyDeptStatistic(Date date){
        SmsDeptExample deptExample = new SmsDeptExample();
        deptExample.createCriteria().andStatusEqualTo(1);
        List<SmsDept> deptList = smsDeptMapper.selectByExample(deptExample);
        int countSum = 0;
        for(SmsDept dept : deptList){
            SmsWorkloadResult result = workloadDeptStatistic(dept.getId(),getEndDate(date));
            countSum += insertWorkload(result);
        }

        return countSum;
    }

    //每日统计插入
    @Override
    public int statistic(Date date){
        int countSum = 0;
        countSum += dailyPersonalStatistic(date);
        countSum += dailyDeptStatistic(date);
        return countSum;
    }

    //求和
    public SmsWorkloadRecord addAll(List<SmsWorkloadRecord> recordList){
        SmsWorkloadRecord resultRecord = new SmsWorkloadRecord();

        resultRecord.setMedicineAmount(new BigDecimal(0));
        resultRecord.setHerbalAmount(new BigDecimal(0));
        resultRecord.setCheckAmount(new BigDecimal(0));
        resultRecord.setTestAmount(new BigDecimal(0));
        resultRecord.setDispositionAmount(new BigDecimal(0));
        resultRecord.setRegistrationAmount(new BigDecimal(0));
        resultRecord.setAmount(new BigDecimal(0));

        resultRecord.setRegistrationNum(new Long(0));
        resultRecord.setExcuteCheckAmount(new BigDecimal(0));
        resultRecord.setExcuteTestAmount(new BigDecimal(0));
        resultRecord.setExcuteDispositionAmount(new BigDecimal(0));
        resultRecord.setExcuteNum(new Long(0));
        for(SmsWorkloadRecord record : recordList){
            resultRecord.setMedicineAmount(resultRecord.getMedicineAmount().add(record.getMedicineAmount()));
            resultRecord.setHerbalAmount(resultRecord.getHerbalAmount().add(record.getHerbalAmount()));
            resultRecord.setCheckAmount(resultRecord.getCheckAmount().add(record.getCheckAmount()));
            resultRecord.setTestAmount(resultRecord.getTestAmount().add(record.getTestAmount()));
            resultRecord.setDispositionAmount(resultRecord.getDispositionAmount().add(record.getDispositionAmount()));
            resultRecord.setRegistrationAmount(resultRecord.getRegistrationAmount().add(record.getRegistrationAmount()));
            resultRecord.setAmount(resultRecord.getAmount().add(record.getAmount()));

            resultRecord.setRegistrationNum(resultRecord.getRegistrationNum() + record.getRegistrationNum());
            resultRecord.setExcuteCheckAmount(resultRecord.getExcuteCheckAmount().add(record.getExcuteCheckAmount()));
            resultRecord.setExcuteTestAmount(resultRecord.getExcuteTestAmount().add(record.getExcuteTestAmount()));
            resultRecord.setExcuteDispositionAmount(resultRecord.getExcuteDispositionAmount().add(record.getExcuteDispositionAmount()));
            resultRecord.setExcuteNum(resultRecord.getExcuteNum() + record.getExcuteNum());
        }
        return resultRecord;
    }

    //获取给定时间的零点
    public Date getBeginDate(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        // 设置时分秒毫秒为0:0:0.0
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    //获取给定时间的最后时间
    public Date getEndDate(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        // 设置时分秒毫秒为23:59:59.0
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

//    //定时任务测试
//    public int timeTest(){
//        Date date = new Date();
//        System.out.println("正在执行定时任务，当前时间" + date);
//        return 0;
//    }

//    public static void main(String[] args){
//        BigDecimal a = new BigDecimal(0);
//        System.out.println("1:" + a.toString());
//        a = a.add(new BigDecimal(10));
//        a.
//        System.out.println("2:" + a.toString());
//    }

}
