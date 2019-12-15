package com.neu.his.cloud.service.dms.service;



import com.neu.his.cloud.service.dms.dto.oss.OssCallbackResult;
import com.neu.his.cloud.service.dms.dto.oss.OssPolicyResult;

import javax.servlet.http.HttpServletRequest;

/**
 * oss上传管理Service
 */
public interface OssService {
    OssPolicyResult policy();
    OssCallbackResult callback(HttpServletRequest request);
}
