package com.cloud.pay.admin.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ImgUtil {
	

	private static Logger log = LoggerFactory.getLogger(ImgUtil.class);
	
	 /**
	 * 上传文件
	 * @param filePath 文件名 
	 * @param in   io流
	 * @return  返回最终的路径
	 * @throws IOException 
	 */
	public static String uploadImg(String rootPATH,String filePath,InputStream in) throws IOException{
		System.out.println("rootPATH="+rootPATH);
		System.out.println("filePath="+filePath);
		String rusultPath = rootPATH+filePath;
		createFile(rusultPath);
		File realFile =new File(rusultPath);
		FileUtils.copyInputStreamToFile(in, realFile);
		return "/upload/show"+filePath;
	}
	
	
	 /**
     * 文件或文件夹不存在则创建
     * @param dir 文件夹
     * @param filepath 文件名
     */
	public static void createFile(String dir,String filepath){
		File file = new File(dir);
		if(!file.exists()){
			file.mkdirs();
		}
		file = new File(dir+filepath);
		if(!file.exists()){
			try {
				file.createNewFile();
			} catch (IOException e) {
				log.error("创建文件失败：{}",e);
			}
		}
	}
	
	/**
	 * 创建文件，如果文件夹不存在将被创建
	 * 
	 * @param destFileName
	 *            文件路径
	 */
	public static File createFile(String destFileName) {
		File file = new File(destFileName);
		if (file.exists())
			return null;
		if (destFileName.endsWith(File.separator))
			return null;
		if (!file.getParentFile().exists()) {
			if (!file.getParentFile().mkdirs())
				return null;
		}
		try {
			if (file.createNewFile())
				return file;
			return null;
		} catch (IOException e) {
			
			return null;
		}
	}
}
