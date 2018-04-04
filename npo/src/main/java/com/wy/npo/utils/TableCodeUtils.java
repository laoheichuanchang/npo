package com.wy.npo.utils;

/**
 * 获取不同表对应的code编码 工具类
 * @author wangy
 *
 */
public class TableCodeUtils {
	
	/**
	 * 订单号长度
	 * */
	public static final int ORDER_NO_LENGTH = 10;

	
	public static String getCode(int id){
		String code = "";
		String idStr = String.valueOf(id);
		//获取当前的日期
		String nowDate = DateUtil.getDateNoLine();
		if(idStr.length()<ORDER_NO_LENGTH){
			//如果长度不够，补0
			int distance = ORDER_NO_LENGTH - idStr.length(); //计算相差的位数
			String zeroStr = "";
			for(int i=0;i<distance;i++){
				zeroStr = zeroStr+"0";
			}
			code = nowDate + zeroStr + idStr;
		}else{
			code = nowDate + idStr;
		}
		return code;
	}
	
	public static void main(String[] args) {
		System.out.println(getCode(02));
	}

}
