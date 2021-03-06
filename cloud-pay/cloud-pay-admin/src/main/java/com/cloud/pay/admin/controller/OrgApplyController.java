package com.cloud.pay.admin.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cloud.pay.admin.controller.base.BaseController;
import com.cloud.pay.admin.entity.Const;
import com.cloud.pay.admin.entity.ResponseModel;
import com.cloud.pay.admin.entity.ResultEnum;
import com.cloud.pay.admin.entity.User;
import com.cloud.pay.admin.util.Jurisdiction;
import com.cloud.pay.admin.util.ParameterMap;
import com.cloud.pay.common.mapper.ProvincialMapper;
import com.cloud.pay.common.service.BankService;
import com.cloud.pay.merchant.entity.MerchantApplyBankInfo;
import com.cloud.pay.merchant.entity.MerchantApplyBaseInfo;
import com.cloud.pay.merchant.entity.MerchantApplyFeeInfo;
import com.cloud.pay.merchant.service.MerchantApplyService;

@Controller
@RequestMapping("/orgApply")
public class OrgApplyController extends BaseController{
	
	private Logger log = LoggerFactory.getLogger(OrgApplyController.class);
	
	@Autowired
	private MerchantApplyService merchantApplyService;
	
	@Autowired
	private BankService bankService;
	
	private String menuUrl = "orgApply/list";
	
	@Autowired
	private ProvincialMapper provincialMapper;
	
	/**
	 * 机构申请列表
	 * @return
	 */
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public Object list(Model model, Integer type, String code, String name, Integer status, String createDateBegin,
			String createDateEnd){
		if(!Jurisdiction.buttonJurisdiction(menuUrl,"query", this.getSession())){return ResponseModel.getModel(ResultEnum.NOT_AUTH, null);}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date startTime = null;
		Date endTime = null;
		try {
			if(StringUtils.isNotBlank(createDateBegin)) {
				startTime = sdf.parse(createDateBegin);
			}
			if(StringUtils.isNotBlank(createDateEnd)) {
				endTime = sdf.parse(createDateEnd);
			}
		} catch(Exception e) {
		}
		User user = ((User) this.getSession().getAttribute(Const.SESSION_USER));
		model.addAttribute("merchantApplys", merchantApplyService.getOrgDTOs(type, code, name, status, 
				startTime, endTime, user.getMerchantId(), user.getMerchantType()));
		model.addAttribute("banks", bankService.getBankList(null, null));
		model.addAttribute("provincials", provincialMapper.selectList());
		return "page/org/orgApplyList";
	}
	
	/**
	 * 添加机构申请
	 * @return
	 */
	@RequestMapping(value="/add",method=RequestMethod.POST)
	@ResponseBody
	public Object add(){
		if(!Jurisdiction.buttonJurisdiction(menuUrl,"add", this.getSession())){return ResponseModel.getModel(ResultEnum.NOT_AUTH, null);}
		try {
			ParameterMap map = this.getParameterMap();
			String bank = map.getString("bankInfo");
			String base = map.getString("baseInfo");
			String fee = map.getString("feeInfo");
			String attachementInfo = map.getString("attachementInfo");
			MerchantApplyBaseInfo baseInfo = JSON.parseObject(base, MerchantApplyBaseInfo.class);
			String userId = ((User) this.getSession().getAttribute(Const.SESSION_USER)).getUsername();
			baseInfo.setCreator(userId);
			baseInfo.setCreateTime(new Date());
			baseInfo.setModifer(userId);
			baseInfo.setModifyTime(new Date());
			MerchantApplyBankInfo bankInfo = JSON.parseObject(bank, MerchantApplyBankInfo.class);
			MerchantApplyFeeInfo feeInfo = JSON.parseObject(fee, MerchantApplyFeeInfo.class);
			JSONObject json = JSON.parseObject(attachementInfo);
			merchantApplyService.save(baseInfo, bankInfo, feeInfo, json,null,false);
		} catch (Exception e) {
			log.error("error:{}", e);
			return ResponseModel.getModel("提交失败:"+e.getMessage(), "failed", null);
		}
		return ResponseModel.getModel("ok", "success", null);
	}
	
	
	/**
	 * 编辑机构申请
	 * @return
	 */
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	@ResponseBody
	public Object edit(){
		if(!Jurisdiction.buttonJurisdiction(menuUrl,"edit", this.getSession())){return ResponseModel.getModel(ResultEnum.NOT_AUTH, null);}
		try {
			ParameterMap map = this.getParameterMap();
			String bank = map.getString("bankInfo");
			String base = map.getString("baseInfo");
			String fee = map.getString("feeInfo");
			MerchantApplyBaseInfo baseInfo = JSON.parseObject(base, MerchantApplyBaseInfo.class);
			String userId = ((User) this.getSession().getAttribute(Const.SESSION_USER)).getUsername();
			baseInfo.setModifer(userId);
			baseInfo.setModifyTime(new Date());
			MerchantApplyBankInfo bankInfo = JSON.parseObject(bank, MerchantApplyBankInfo.class);
			MerchantApplyFeeInfo feeInfo = JSON.parseObject(fee, MerchantApplyFeeInfo.class);
			String attachementInfo = map.getString("attachementInfo");
			JSONObject json = JSON.parseObject(attachementInfo);
			merchantApplyService.update(baseInfo, bankInfo, feeInfo, json,null,false);
		} catch (Exception e) {
			log.error("error:{}", e);
			return ResponseModel.getModel("提交失败:"+e.getMessage(), "failed", null);
		}
		return ResponseModel.getModel("ok", "success", null);
	}
	
	
	/**
	 * 审核机构申请
	 * @return
	 */
	@RequestMapping(value="/audit",method=RequestMethod.POST)
	@ResponseBody
	public Object audit(){
		if(!Jurisdiction.buttonJurisdiction(menuUrl,"edit", this.getSession())){return ResponseModel.getModel(ResultEnum.NOT_AUTH, null);}
		try {
			Integer id = Integer.parseInt(this.getParameterMap().getString("id"));
			Integer status = Integer.parseInt(this.getParameterMap().getString("status"));
			String auditOptinion = this.getParameterMap().getString("auditOptinion");
			String userId = ((User) this.getSession().getAttribute(Const.SESSION_USER)).getUsername();
			merchantApplyService.audit(id, status, auditOptinion, userId);
		} catch (Exception e) {
			log.error("error:{}", e);
			return ResponseModel.getModel("提交失败:"+e.getMessage(), "failed", null);
		}
		return ResponseModel.getModel("ok", "success", null);
	}
	
	/**
	 * 获取机构申请
	 * @return
	 */
	@RequestMapping(value="/get",method=RequestMethod.GET)
	@ResponseBody
	public Object get(){
		if(!Jurisdiction.buttonJurisdiction(menuUrl,"query", this.getSession())){return ResponseModel.getModel(ResultEnum.NOT_AUTH, null);}
		try {
			ParameterMap map = this.getParameterMap();
			Integer id = Integer.parseInt(map.getString("id"));
			return ResponseModel.getModel("ok", "success", merchantApplyService.select(id));
		} catch (Exception e) {
			log.error("error:{}", e);
			return ResponseModel.getModel("提交失败:"+e.getMessage(), "failed", null);
		}
	}
	
	/**
	 * 变更机构申请
	 * @return
	 */
	@RequestMapping(value="/change",method=RequestMethod.POST)
	@ResponseBody
	public Object change(){
		if(!Jurisdiction.buttonJurisdiction(menuUrl,"edit", this.getSession())){return ResponseModel.getModel(ResultEnum.NOT_AUTH, null);}
		try {
			ParameterMap map = this.getParameterMap();
			String bank = map.getString("bankInfo");
			String base = map.getString("baseInfo");
			String fee = map.getString("feeInfo");
			MerchantApplyBaseInfo baseInfo = JSON.parseObject(base, MerchantApplyBaseInfo.class);
			String userId = ((User) this.getSession().getAttribute(Const.SESSION_USER)).getUsername();
			baseInfo.setCreator(userId);
			baseInfo.setCreateTime(new Date());
			baseInfo.setModifer(userId);
			baseInfo.setModifyTime(new Date());
			MerchantApplyBankInfo bankInfo = JSON.parseObject(bank, MerchantApplyBankInfo.class);
			MerchantApplyFeeInfo feeInfo = JSON.parseObject(fee, MerchantApplyFeeInfo.class);
			String attachementInfo = map.getString("attachementInfo");
			JSONObject json = JSON.parseObject(attachementInfo);
			merchantApplyService.change(baseInfo, bankInfo, feeInfo, json,null,false);
		} catch (Exception e) {
			log.error("error:{}", e);
			return ResponseModel.getModel("提交失败:"+e.getMessage(), "failed", null);
		}
		return ResponseModel.getModel("ok", "success", null);
	}
	
}
