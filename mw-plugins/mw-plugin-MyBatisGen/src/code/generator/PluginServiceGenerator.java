package code.generator;

import static org.mybatis.generator.internal.util.StringUtility.stringHasValue;
import static org.mybatis.generator.internal.util.messages.Messages.getString;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.mybatis.generator.api.GeneratedJavaFile;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.JavaVisibility;
import org.mybatis.generator.api.dom.java.TopLevelClass;

/**
 * 自定义service层生成策略
 * 以表 user表生成策略为例
 */
public class PluginServiceGenerator extends PluginAdapter {
	/**
	 * 目标位置
	 */
	private String targetProject = null;
	/**
	 * service层接口生成位置
	 */
	private String serveicePackge = null;
	/**
	 * service层 实现类生成位置
	 */
	private String serveiceImplPackge = null;
	/**
	 * 实体类User名称,例如：User
	 */
	private String modelName = null ;
	/**
	 * 实体类user名称首字母小写，例如： user
	 */
	private String modelNameLow = null;
	/**
	 * Mapper类首字母小写,例如：userMapper
	 */
	private String mapperNameLow = null;
	/**
	 * 分页类，Service分页方法返回的分页类
	 */
	private String paginationClass= null;

	
	public boolean validate(List<String> warnings) {
		
		targetProject = properties.getProperty("targetProject");
		serveicePackge = properties.getProperty("serveicePackge");
		serveiceImplPackge = properties.getProperty("serveiceImplPackge");
		paginationClass = properties.getProperty("paginationClass");
		
		if (!stringHasValue(targetProject)) {
			warnings.add(getString("ValidationError.18", "PluginServiceGenerator", "targetProject"));
			return false;
		}
		if (!stringHasValue(serveicePackge)) {
			warnings.add(getString("ValidationError.18", "PluginServiceGenerator", "serveicePackge"));
			return false;
		}
		if (!stringHasValue(serveiceImplPackge)) {
			warnings.add(getString("ValidationError.18", "PluginServiceGenerator", "serveiceImplPackge"));
			return false;
		}
		if (!stringHasValue(paginationClass)) {
			warnings.add(getString("ValidationError.18", "PluginServiceGenerator", "paginationClass"));
			return false;
		}
		return true;
	}
	
	
	
	
	/**
	 * 生成 service接口 和 service实现类
	 */
	public List<GeneratedJavaFile> contextGenerateAdditionalJavaFiles(IntrospectedTable introspectedTable) {
		
		// 1.取得生成类的必要信息
		String recordFulltype = introspectedTable.getBaseRecordType(); // 获得表的实体对象类  xxx.xxx.Model
		if (recordFulltype.lastIndexOf(".") != -1) {
			modelName = recordFulltype.substring(recordFulltype.lastIndexOf(".") + 1);
		} else {
			modelName = recordFulltype;
		}
		modelNameLow = modelName.substring(0, 1).toLowerCase()+ modelName.substring(1);
		mapperNameLow = modelNameLow + "Mapper";
		
		
		
		// 生成service 接口 IUserService
		Interface serviceInterface = generatorServiceInterface(introspectedTable);
		
		// 生成service 接口实现类 XXXServiceImpl
		TopLevelClass serviceImpl = generatorServiceImpl(introspectedTable);
		

		
		org.mybatis.generator.api.dom.DefaultJavaFormatter formatter=new org.mybatis.generator.api.dom.DefaultJavaFormatter();
		
		GeneratedJavaFile file_interface = new GeneratedJavaFile(serviceInterface, targetProject, formatter);
		GeneratedJavaFile file_class = new GeneratedJavaFile(serviceImpl,targetProject, formatter);
		
		List<GeneratedJavaFile> generatedJavaFiles = new ArrayList<GeneratedJavaFile>();
		generatedJavaFiles.add(file_interface);
		generatedJavaFiles.add(file_class);
		return generatedJavaFiles;
	}

	
	
	
	
	
	
	
	/*----------------------------------------------------------------------------------------*/
	
	/**
	 * 生成service接口的具体方法
	 * @param introspectedTable
	 * @return 
	 */
	private Interface generatorServiceInterface(IntrospectedTable introspectedTable){
		
		// 1.创建一个新接口，接口位置和命名：xxx.xxx.UserService
		Interface serviceInterface = new Interface(new FullyQualifiedJavaType(serveicePackge + "."+ modelName + "Service"));
		serviceInterface.setVisibility(JavaVisibility.PUBLIC);
		
		return serviceInterface;
	}
	
	
	
	
	/*----------------------------------------------------------------------------------------*/
	
	private TopLevelClass generatorServiceImpl(IntrospectedTable introspectedTable){
		
		TopLevelClass serviceImpl = new TopLevelClass(new FullyQualifiedJavaType(serveiceImplPackge + "." + modelName+ "ServiceImpl"));
		
		
		// 1.添加接口引用类
		// 引用：接口类
		FullyQualifiedJavaType javaType_serviceInterface = new FullyQualifiedJavaType(serveicePackge + "."+ modelName + "Service");
		// 引用：Service注解类
		FullyQualifiedJavaType javaType_serviceAnnotation = new FullyQualifiedJavaType("org.springframework.stereotype.Service");
		// 引用：Resource注解
		FullyQualifiedJavaType javaType_resource = new FullyQualifiedJavaType("javax.annotation.Resource");
		// 引用：rowBounds分页类
		FullyQualifiedJavaType javaType_RowBounds = new FullyQualifiedJavaType("org.apache.ibatis.session.RowBounds");
		// 引用：Mapper类
		FullyQualifiedJavaType javaType_mapper = new FullyQualifiedJavaType(introspectedTable.getMyBatis3JavaMapperType());
		// 引用：Model类
		FullyQualifiedJavaType javaType_model = new FullyQualifiedJavaType(introspectedTable.getBaseRecordType());
		// 引用：modelCriteria类型
		FullyQualifiedJavaType javaType_modelCriteria = new FullyQualifiedJavaType(introspectedTable.getExampleType());
		// 引用：list<model>类型
		FullyQualifiedJavaType javaType_list = FullyQualifiedJavaType.getNewListInstance(); 
		javaType_list.addTypeArgument(new FullyQualifiedJavaType(introspectedTable.getBaseRecordType()));
		// 引用：Map<String,Object>类型
		FullyQualifiedJavaType javaType_map = FullyQualifiedJavaType.getNewMapInstance();
		javaType_map.addTypeArgument(FullyQualifiedJavaType.getStringInstance());
		javaType_map.addTypeArgument(FullyQualifiedJavaType.getObjectInstance());
		// 引用：Pagination类型
		//FullyQualifiedJavaType javaType_pagination = new FullyQualifiedJavaType(paginationClass);
		
		Set<FullyQualifiedJavaType> importedTypes = new TreeSet<FullyQualifiedJavaType>();
		importedTypes.add(javaType_serviceInterface);
		importedTypes.add(javaType_serviceAnnotation);
		importedTypes.add(javaType_resource);
		importedTypes.add(javaType_RowBounds);
		importedTypes.add(javaType_mapper);
		importedTypes.add(javaType_model);
		importedTypes.add(javaType_modelCriteria);
		importedTypes.add(javaType_list);
		importedTypes.add(javaType_map);
		//importedTypes.add(javaType_pagination);
		
		
		
		// 2.serviceImpl实现
		serviceImpl.setVisibility(JavaVisibility.PUBLIC);
		serviceImpl.addSuperInterface(javaType_serviceInterface);
		serviceImpl.addAnnotation("@Service(\"" + modelNameLow+ "Service\")");
		

		// 3.资源引用，maaper类
		Field field = new Field();
		field.addAnnotation("@Resource");
		field.setVisibility(JavaVisibility.PRIVATE);
		field.setType(javaType_mapper);
		field.setName(mapperNameLow);
		serviceImpl.addField(field);
		
		
		
		
		// 查找分页
//		Method method_findPagination = new Method();
//		method_findPagination.addJavaDocLine("/**");
//		method_findPagination.addJavaDocLine(" * @param queryMap 查询实体类列表的条件");
//		method_findPagination.addJavaDocLine(" * @param currentPage 查询实体类列表的页码");
//		method_findPagination.addJavaDocLine(" * @param pageSize 查询实体类列表的每页记录条数");
//		method_findPagination.addJavaDocLine(" * @return 返回分页对象");
//		method_findPagination.addJavaDocLine(" */");
//		method_findPagination.setVisibility(JavaVisibility.PRIVATE);
//		method_findPagination.setReturnType(javaType_pagination);
//		method_findPagination.setName("findPagination");
//		method_findPagination.addParameter(new Parameter(javaType_map, "queryMap"));
//		method_findPagination.addParameter(new Parameter(FullyQualifiedJavaType.getIntInstance(), "currentPage")); // int currentPage
//		method_findPagination.addParameter(new Parameter(FullyQualifiedJavaType.getIntInstance(), "pageSize")); // int pageSize
//		method_findPagination.addBodyLine(modelName+"Criteria "+modelNameLow+"Criteria = new "+modelName+"Criteria();");
//		method_findPagination.addBodyLine("// Criteria criteria = "+modelNameLow+"Criteria.createCriteria();");
//		method_findPagination.addBodyLine("// criteria add the query conditions ");
//		method_findPagination.addBodyLine("int totalCount = (int) this." + mapperNameLow+ ".countByExample("+modelNameLow+"Criteria);");
//		method_findPagination.addBodyLine("List<" + modelName + "> items = this."+ mapperNameLow + ".selectByExampleWithRowbounds("+modelNameLow+"Criteria,new RowBounds((currentPage-1)*pageSize,pageSize));");
//		method_findPagination.addBodyLine("return new Pagination(pageSize, currentPage, totalCount, items);");
//		serviceImpl.addMethod(method_findPagination);
		
		serviceImpl.addImportedTypes(importedTypes);
		return serviceImpl;
	}



	

}