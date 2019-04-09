package com.gaomt.yummy.service.request;

import com.gaomt.yummy.constant.CommonResult;
import com.gaomt.yummy.constant.RequestState;
import com.gaomt.yummy.constant.RequestType;
import com.gaomt.yummy.domain.Inbox;
import com.gaomt.yummy.domain.Request;
import com.gaomt.yummy.domain.Resaurant;
import com.gaomt.yummy.repository.InboxDAO;
import com.gaomt.yummy.repository.RequestDAO;
import com.gaomt.yummy.service.resaurant.ResaurantService;
import com.gaomt.yummy.service.resaurant.ResaurantTypeService;
import com.gaomt.yummy.vo.RequestVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author： MengtingGao
 * @Date： Create in 9:28 2019/2/26
 * @Description:
 */
@Service
public class RequestServiceImpl implements RequestService {

  @Autowired
  private RequestDAO requestDAO;
  @Autowired
  private InboxDAO inboxDAO;
  @Autowired
  private ResaurantService resaurantService;
  @Autowired
  private ResaurantTypeService resaurantTypeService;

  @Override
  public CommonResult sendNewRequest(int resID, RequestType requestType, String newInfo) {
    Request request = new Request();
    Resaurant resaurant = resaurantService.getResaurantByID(resID);

    request.setReqTime(new Timestamp(new Date().getTime()));
    request.setResID(resID);
    request.setNewInfo(newInfo);
    request.setReqType(requestType.toString());
    request.setState(RequestState.PENDING.toString());

    switch (requestType) {
      case NAME:
        request.setOldInfo(resaurant.getName());
        break;
      case LOCATE:
        request.setOldInfo(resaurant.getLocate());
        break;
      case TYPE:
        request.setOldInfo(resaurantTypeService.getResaurantTypeNameByID(resaurant.getResTypeID()));
        break;
      default:
        return CommonResult.FAIL;
    }

    requestDAO.save(request);

    int reqID = request.getReqID();
    Inbox inbox = new Inbox();
    inbox.setReqID(reqID);
    inboxDAO.save(inbox);

    return CommonResult.SUCCESS;
  }

  @Override
  public ArrayList<RequestVO> getInboxRequests() {
    ArrayList<RequestVO> requestVOS = new ArrayList<>();
    List<Inbox> inboxes = inboxDAO.findAll();
    RequestVO requestVO;

    for (Inbox inbox: inboxes) {
      int reqID = inbox.getReqID();

      if (requestDAO.findById(reqID).isPresent()) {
        Request request = requestDAO.findById(reqID).get();
        int resID = request.getResID();
        Resaurant resaurant = resaurantService.getResaurantByID(resID);
        String resName = resaurant.getName();

        requestVO = new RequestVO();
        requestVO.initByRequest(request, resName);
        requestVOS.add(requestVO);
      }
      else return requestVOS;
    }
    return requestVOS;
  }

  @Override
  @Transactional
  public CommonResult acceptRequest(int reqID) {
    if (requestDAO.findById(reqID).isPresent()) {
      Request request = requestDAO.findById(reqID).get();
      request.setState(RequestState.AGREE.toString());
      request.setApprTime(new Timestamp(new Date().getTime()));

      switch (RequestType.valueOf(request.getReqType())) {
        case NAME:
          resaurantService.setResName(request.getResID(), request.getNewInfo());
          break;
        case TYPE:
          resaurantService.setResType(request.getResID(), request.getNewInfo());
          break;
        case LOCATE:
          resaurantService.setResLocate(request.getResID(), request.getNewInfo());
          break;
      }
      inboxDAO.deleteByReqID(reqID);
      return CommonResult.SUCCESS;
    }
    else return CommonResult.FAIL;
  }

  @Override
  @Transactional
  public CommonResult rejectRequest(int reqID) {
    if (requestDAO.findById(reqID).isPresent()) {
      Request request = requestDAO.findById(reqID).get();
      request.setState(RequestState.REJECT.toString());
      request.setApprTime(new Timestamp(new Date().getTime()));
      inboxDAO.deleteByReqID(reqID);
      return CommonResult.SUCCESS;
    }
    else return CommonResult.FAIL;
  }

  @Override
  public ArrayList<RequestVO> getRequestByResID(int resID) {
    ArrayList<RequestVO> requestVOS = new ArrayList<>();
    List<Request> requests = requestDAO.findAllByResID(resID);

    for (Request request: requests) {
      RequestVO requestVO = new RequestVO();
      requestVO.initByRequest(request, "");
      requestVOS.add(requestVO);
    }

    return requestVOS;
  }

  @Override
  public ArrayList<RequestVO> getCurrentRequestByResID(int resID) {
    ArrayList<RequestVO> requestVOS = new ArrayList<>();
    List<Request> requests = requestDAO.findAllByResIDAndState(resID, RequestState.PENDING.toString());

    for (Request request: requests) {
      RequestVO requestVO = new RequestVO();
      requestVO.initByRequest(request, "");
      requestVOS.add(requestVO);
    }

    return requestVOS;
  }
}
