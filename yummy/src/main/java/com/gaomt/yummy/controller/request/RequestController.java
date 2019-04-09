package com.gaomt.yummy.controller.request;

import com.gaomt.yummy.constant.CommonResult;
import com.gaomt.yummy.service.request.RequestService;
import com.gaomt.yummy.vo.RequestVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * @Author： MengtingGao
 * @Date： Create in 20:57 2019/3/6
 * @Description:
 */
@RestController
@RequestMapping("/request")
@CrossOrigin("http://localhost:8010")
public class RequestController {

  @Autowired
  private RequestService requestService;

  @RequestMapping(value = "/inbox")
  ArrayList<RequestVO> getInboxRequests() {
    return requestService.getInboxRequests();
  }

  @RequestMapping(value = "/accept", method = RequestMethod.POST)
  CommonResult acceptRequest(@RequestParam(value = "reqID") int reqID) {
    return requestService.acceptRequest(reqID);
  }

  @RequestMapping(value = "/reject", method = RequestMethod.POST)
  CommonResult rejectRequest(@RequestParam(value = "reqID") int reqID) {
    return requestService.rejectRequest(reqID);
  }

  @RequestMapping(value = "/restaurant", method = RequestMethod.POST)
  ArrayList<RequestVO> getRequestByResID(@RequestParam(value = "resID") int resID) {
    return requestService.getRequestByResID(resID);
  }

  @RequestMapping(value = "/restaurant/current", method = RequestMethod.POST)
  ArrayList<RequestVO> getCurrentRequestByResID(@RequestParam(value = "resID") int resID) {
    return requestService.getCurrentRequestByResID(resID);
  }

}
