package com.store.service;

import java.util.ArrayList;
import java.util.List;

import com.store.dao.DaoFactory;
import com.store.dao.UserDao;
import com.store.json.JsonContext;
import com.store.model.Product;

import net.sf.json.JSON;
import net.sf.json.JSONObject;

public class UserService {
	DaoFactory factory=DaoFactory.getInstance();
	UserDao userDao=factory.creatUserDao();
	
	
	public JSONObject paySingle(String username,Product product) {
        String payResult=userDao.paySingle(username, product);
        JsonContext jsonContext=new JsonContext();
        JSONObject json=new JSONObject();
        if(payResult.contains("支付成功！！！")) {
        	json=jsonContext.getSuccessObject(payResult, null, null);
        }
        else {
            json=jsonContext.getFailedObject(payResult);
        }
		return json;
	}
	
	
	public JSONObject payCart(String username,ArrayList<Product> productList) {
		String payResult=userDao.payCart(username, productList);
        JsonContext jsonContext=new JsonContext();
        JSONObject json=new JSONObject();
        if(payResult.contains("支付成功！！！")) {
        	json=jsonContext.getSuccessObject(payResult, null, null);
        }
        else {
            json=jsonContext.getFailedObject(payResult);
        }
		return json;
	}
	
	public JSONObject addOrder(String username,Product product) {
		String result=userDao.addOrder(username, product);
		JsonContext jsonContext=new JsonContext();
        JSONObject json=new JSONObject();
        if(result.contains("添加成功！！！")) {
        	json=jsonContext.getSuccessObject(result, null, null);
        }
        else {
            json=jsonContext.getFailedObject(result);
        }
		return json;
		
	}
	
	public JSONObject deleteOrder(String username,Product product) {
		String result=userDao.deleteOrder(username, product);
		JsonContext jsonContext=new JsonContext();
        JSONObject json=new JSONObject();
        if(result.contains("删除成功！！！")) {
        	json=jsonContext.getSuccessObject(result, null, null);
        }
        else {
            json=jsonContext.getFailedObject(result);
        }
		return json;
		
	}
	
	
	
	public JSONObject repassword(String username,String newPassword){
		String result=userDao.repassword(username, newPassword);
		JsonContext jsonContext=new JsonContext();
        JSONObject json=new JSONObject();
        if(result.contains("密码修改成功！！！")) {
        	json=jsonContext.getSuccessObject(result, null, null);
        }
        else {
            json=jsonContext.getFailedObject(result);
        }
		return json;
		
		
	}
	
	public JSONObject getValidationProblem(String username){
		String result=userDao.getValidationProblem(username);
		JsonContext jsonContext=new JsonContext();
        JSONObject json=new JSONObject();
        if(!result.contains("未登录")) {
        	json=jsonContext.getSuccessObject(result, null, null);
        }
        else {
            json=jsonContext.getFailedObject(result);
        }
		return json;
				
	}
	
	public JSONObject validationProblemComfire(String username,String answer){
		String result=userDao.validationProblemComfire(username,answer);
		JsonContext jsonContext=new JsonContext();
        JSONObject json=new JSONObject();
        if(result.contains("验证成功")) {
        	json=jsonContext.getSuccessObject(result, null, null);
        }
        else {
            json=jsonContext.getFailedObject(result);
        }
		return json;
				
	}
	

}
