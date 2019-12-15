package com.neu.his.sms;

import com.neu.his.common.dto.sms.SmsDeptParam;
import com.neu.his.common.dto.sms.SmsDeptResult;

import java.util.List;

/**
 *  科室
 */
public interface SmsDeptService {

    /**
     * 描述：新增科室
     */
    int create(SmsDeptParam smsDeptParam);

    /**
     * 描述：删除科室
     */
    int delete(List<Long> ids);

    /**
     * 描述：更新科室
     */
    int update(Long id, SmsDeptParam smsDeptParam);

    /**
     * 描述：查询科室
     */
    List<SmsDeptResult> select(SmsDeptParam smsDeptQueryParam);

    /**
     * 描述：列出所有科室
     */
    List<SmsDeptResult> selectAll();


}
