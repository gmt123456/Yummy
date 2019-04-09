package com.gaomt.yummy.service.request;

import com.gaomt.yummy.constant.CommonResult;
import com.gaomt.yummy.constant.RequestType;
import com.gaomt.yummy.vo.RequestVO;

import java.util.ArrayList;

/**
 * @Author： MengtingGao
 * @Date： Create in 9:17 2019/2/26
 * @Description:
 */
public interface RequestService {

  CommonResult sendNewRequest(int resID, RequestType requestType, String newInfo);

  ArrayList<RequestVO> getInboxRequests();

  CommonResult acceptRequest(int reqID);

  CommonResult rejectRequest(int reqID);

  ArrayList<RequestVO> getRequestByResID(int resID);

  ArrayList<RequestVO> getCurrentRequestByResID(int resID);

}
