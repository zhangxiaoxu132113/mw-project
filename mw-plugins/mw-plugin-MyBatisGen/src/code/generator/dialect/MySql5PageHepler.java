package code.generator.dialect;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MySql5PageHepler {
	/**
	 * 寰楀埌鏌ヨ鎬绘暟鐨剆ql
	 */
	public static String getCountString(String querySelect) {
		
		querySelect		= getLineSql(querySelect);
		int orderIndex  = getLastOrderInsertPoint(querySelect);
		
		int formIndex   = getAfterFormInsertPoint(querySelect);
		String select   = querySelect.substring(0, formIndex);
		
		//濡傛灉SELECT 涓寘鍚�DISTINCT 鍙兘鍦ㄥ灞傚寘鍚獵OUNT
		if (select.toLowerCase().indexOf("select distinct") != -1 || querySelect.toLowerCase().indexOf("group by")!=-1) {
			return new StringBuffer(querySelect.length()).append(
					"select count(1) count from (").append(
					querySelect.substring(0, orderIndex)).append(" ) t")
					.toString();
		} else {
			return new StringBuffer(querySelect.length()).append(
					"select count(1) count ").append(
					querySelect.substring(formIndex, orderIndex)).toString();
		}
	}
	
	/**
	 * 寰楀埌鏈�悗涓�釜Order By鐨勬彃鍏ョ偣浣嶇疆
	 * @return 杩斿洖鏈�悗涓�釜Order By鎻掑叆鐐圭殑浣嶇疆
	 */
	private static int getLastOrderInsertPoint(String querySelect){
		int orderIndex = querySelect.toLowerCase().lastIndexOf("order by");
		if (orderIndex == -1
				|| !isBracketCanPartnership(querySelect.substring(orderIndex,querySelect.length()))) {
			throw new RuntimeException("My SQL 鍒嗛〉蹇呴』瑕佹湁Order by 璇彞!");
		}
		return orderIndex;
	}
	/**
	 * 寰楀埌鍒嗛〉鐨凷QL
	 * @param offset 	鍋忕Щ閲�
	 * @param limit		浣嶇疆
	 * @return	鍒嗛〉SQL
	 */
	public static String getLimitString(String querySelect,int offset, int limit) {
		querySelect	= getLineSql(querySelect);
		//String sql =  querySelect.replaceAll("[^\\s,]+\\.", "") +" limit "+ offset +" ,"+ limit;
		String sql =  querySelect +" limit "+ offset +" ,"+ limit;
		return sql;
		
	}

	/**
	 * 灏哠QL璇彞鍙樻垚涓�潯璇彞锛屽苟涓旀瘡涓崟璇嶇殑闂撮殧閮芥槸1涓┖鏍�
	 * 
	 * @param sql SQL璇彞
	 * @return 濡傛灉sql鏄疦ULL杩斿洖绌猴紝鍚﹀垯杩斿洖杞寲鍚庣殑SQL
	 */
	private static String getLineSql(String sql) {
		return sql.replaceAll("[\r\n]", " ").replaceAll("\\s{2,}", " ");
	}

	/**
	 * 寰楀埌SQL绗竴涓纭殑FROM鐨勭殑鎻掑叆鐐�
	 */
	private static int getAfterFormInsertPoint(String querySelect) {
		String regex = "\\s+FROM\\s+";
		Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(querySelect);
		while (matcher.find()) {
			int fromStartIndex = matcher.start(0);
			String text = querySelect.substring(0, fromStartIndex);
			if (isBracketCanPartnership(text)) {
				return fromStartIndex;
			}
		}
		return 0;
	}

	/**
	 * 鍒ゆ柇鎷彿"()"鏄惁鍖归厤,骞朵笉浼氬垽鏂帓鍒楅『搴忔槸鍚︽纭�
	 * 
	 * @param text
	 *            瑕佸垽鏂殑鏂囨湰
	 * @return 濡傛灉鍖归厤杩斿洖TRUE,鍚﹀垯杩斿洖FALSE
	 */
	private static boolean isBracketCanPartnership(String text) {
		if (text == null
				|| (getIndexOfCount(text, '(') != getIndexOfCount(text, ')'))) {
			return false;
		}
		return true;
	}

	/**
	 * 寰楀埌涓�釜瀛楃鍦ㄥ彟涓�釜瀛楃涓蹭腑鍑虹幇鐨勬鏁�
	 * @param text	鏂囨湰
	 * @param ch    瀛楃
	 */
	private static int getIndexOfCount(String text, char ch) {
		int count = 0;
		for (int i = 0; i < text.length(); i++) {
			count = (text.charAt(i) == ch) ? count + 1 : count;
		}
		return count;
	}
}
