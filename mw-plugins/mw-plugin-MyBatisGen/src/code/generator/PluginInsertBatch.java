package code.generator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.OutputUtilities;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.Parameter;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.Document;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.codegen.mybatis3.MyBatis3FormattingUtilities;

public class PluginInsertBatch extends PluginAdapter {
	
	private String item = "item";
	
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
		String objectName = introspectedTable.getTableConfiguration().getDomainObjectName();//对象名称
		
		interfaze.addImportedType(new FullyQualifiedJavaType("java.util.List"));
		
		Method method_insertBatch = new Method();
		//method_insertBatch.addJavaDocLine("/**");
		//method_insertBatch.addJavaDocLine(" * Batch insert. Parameters can not be more than 2100");
		//method_insertBatch.addJavaDocLine(" * list of size not greater than 1000");
		//method_insertBatch.addJavaDocLine(" */");
		method_insertBatch.setReturnType(new FullyQualifiedJavaType("int"));
		method_insertBatch.setName("insertBatch");
		method_insertBatch.addParameter(new Parameter(new FullyQualifiedJavaType("java.util.List<" + objectName + ">"), "list"));
		interfaze.addMethod(method_insertBatch);

		
		/*该行代码的作用：当commentGenerator配置为false时，接口可以生成注释代码。没有意义，所以注释，其他新加的方法已经删除*/
		// context.getCommentGenerator().addGeneralMethodComment(method, introspectedTable);
		return super.clientGenerated(interfaze, topLevelClass, introspectedTable);
	}
	
	
	/**
	 * 在xml文件中添加需要的元素
	 */
	@Override
	public boolean sqlMapDocumentGenerated(Document document, IntrospectedTable introspectedTable) {
		XmlElement parentElement = document.getRootElement();
		
		String tableName = introspectedTable.getAliasedFullyQualifiedTableNameAtRuntime();//数据库表名
		// 批量插入
		parentElement.addElement(getInsertBatchElement(introspectedTable, tableName));
		
		return super.sqlMapDocumentGenerated(document, introspectedTable);
	}
	
	/**
	 * 批量添加
	 * @param introspectedTable
	 * @param tableName
	 * @return
	 */
	public XmlElement getInsertBatchElement(IntrospectedTable introspectedTable, String tableName) {
        XmlElement insertBatchElement = new XmlElement("insert");
        insertBatchElement.addAttribute(new Attribute("id", "insertBatch"));
        XmlElement foreachElement = NewForeachElement();
        StringBuilder insertClause = new StringBuilder();
        StringBuilder valuesClause = new StringBuilder();
        List<String> valuesClauses = new ArrayList<String>();
        insertClause.append("insert into "); 
        insertClause.append(tableName);
        insertClause.append(" (");
        valuesClause.append("(");
        Iterator<IntrospectedColumn> iter = introspectedTable.getAllColumns().iterator();
        while (iter.hasNext()) {
            IntrospectedColumn introspectedColumn = iter.next();
            insertClause.append(MyBatis3FormattingUtilities.getEscapedColumnName(introspectedColumn));
            valuesClause.append(MyBatis3FormattingUtilities.getParameterClause(introspectedColumn, item + "."));
            
            if (iter.hasNext()) {
                insertClause.append(", ");
                valuesClause.append(", ");
            }
            if (valuesClause.length() > 80) {
                // insertBatchElement.addElement(new TextElement(insertClause.toString()));insertClause.setLength(0);OutputUtilities.xmlIndent(insertClause, 1);
                valuesClauses.add(valuesClause.toString());valuesClause.setLength(0);OutputUtilities.xmlIndent(valuesClause, 1);
            }
        }
        insertClause.append(") values ");insertBatchElement.addElement(new TextElement(insertClause.toString()));
        valuesClause.append(")");
        valuesClauses.add(valuesClause.toString());

        for (String clause : valuesClauses) {
        	foreachElement.addElement(new TextElement(clause));
        }
        insertBatchElement.addElement(foreachElement);
        return insertBatchElement;
    }
	
	
	/**
	 * 获得一个循环list的节点
	 * @return
	 */
	public XmlElement NewForeachElement(){
		XmlElement foreachElement = new XmlElement("foreach");
		foreachElement.addAttribute(new Attribute("collection", "list"));
		foreachElement.addAttribute(new Attribute("item", item));
		foreachElement.addAttribute(new Attribute("index", "index"));
		foreachElement.addAttribute(new Attribute("separator", ","));
		return foreachElement;
	}
	
}