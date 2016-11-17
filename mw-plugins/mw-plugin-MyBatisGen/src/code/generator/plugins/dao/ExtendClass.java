package code.generator.plugins.dao;
import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.JavaVisibility;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.api.dom.xml.Document;

/**
 * DAO继承Extend类
 */
public class ExtendClass extends PluginAdapter {
	
	private final String EXTEND_PACKAGE = "extend";
	private final String EXTEND_SUFFIX = "Extend";
	
	/**
	 * 验证插件的配置是否正确
	 */
	public boolean validate(List<String> warnings) {
		return true;
	}
	
	
	/**
	 * 在接口中添加方法
	 */
	@Override
	public boolean clientGenerated(Interface interfaze, TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
		
		// 对象名称
		//String modelName = introspectedTable.getTableConfiguration().getDomainObjectName(); 
		// 表名称
		//String tableName = introspectedTable.getTableConfiguration().getTableName(); 
		// dao包位置
		String daoPackage = interfaze.getType().getPackageName();
		// dao名称
		String daoName = interfaze.getType().getShortName();
		
		String daoExtendPackage = daoPackage+"."+EXTEND_PACKAGE;
		
		String daoExtendName = daoName+EXTEND_SUFFIX;
		
		String daoExtendFull = daoExtendPackage+"."+daoExtendName;
		
		Interface daoExtend = new Interface(new FullyQualifiedJavaType(daoExtendFull)); 
		daoExtend.setVisibility(JavaVisibility.PUBLIC);
		
		// 创建xml目录
		File directory = new File("src");
		directory = new File(directory,StringUtils.replace(daoExtendPackage,".", File.separator));
		if (!directory.isDirectory()) {
            boolean rc = directory.mkdirs();
            if(rc) {
            	// System.out.println("创建文件夹成功:"+directory.getPath());
            }
		}
		// 创建java文件
		File xmlFile = new File(directory,daoExtendName+".java");
		try {
			FileUtils.write(xmlFile, daoExtend.getFormattedContent());
			FullyQualifiedJavaType extendClass = new FullyQualifiedJavaType(daoExtendFull);
			interfaze.addImportedType(extendClass);
			interfaze.addSuperInterface(extendClass);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return super.clientGenerated(interfaze, topLevelClass, introspectedTable);
	}
	
	
	
	
	@Override
	public boolean sqlMapDocumentGenerated(Document document,IntrospectedTable introspectedTable) {
		try {
			org.dom4j.Document doc = DocumentHelper.parseText(document.getFormattedContent());
			Element rootEl =  doc.getRootElement();
			rootEl.clearContent();
			rootEl.addComment("扩展方法");
			
			String val = rootEl.attributeValue("namespace");
			String daoPackage = val.substring(0, val.lastIndexOf("."));
			String daoName = val.substring(val.lastIndexOf(".")+1,val.length());
			
			String daoExtendPackage = daoPackage+"."+EXTEND_PACKAGE;
			String daoExtendName = daoName+EXTEND_SUFFIX;
			rootEl.addAttribute("namespace", daoExtendPackage+"."+daoExtendName);
			doc.setRootElement(rootEl);
			
			// 创建xml目录
			File directory = new File("src");
			directory = new File(directory,StringUtils.replace(daoExtendPackage,".", File.separator));
			if (!directory.isDirectory()) {
	            boolean rc = directory.mkdirs();
	            if(rc) {
	            	// System.out.println("创建文件夹成功:"+directory.getPath());
	            }
			}
			// 创建xml文件
			File xmlFile = new File(directory,daoExtendName+".xml");
			FileUtils.write(xmlFile, doc.asXML());
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return super.sqlMapDocumentGenerated(document, introspectedTable);
	}
	
}