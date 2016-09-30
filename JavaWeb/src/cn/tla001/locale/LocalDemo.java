/*    */package cn.tla001.locale;

/*    */
/*    *//*    */import java.util.Locale;
/*    */
import java.util.ResourceBundle;

import org.junit.Test;

/*    */
/*    */
/*    */public class LocalDemo
/*    */{
	/*    */@Test
	/*    */public void test1()
	/*    */{
		/* 13 */Locale locale = Locale.getDefault();
		/* 14 */System.out.println(locale.getCountry());
		/* 15 */System.out.println(locale.getDisplayCountry());
		/* 16 */System.out.println(locale.getLanguage());
		/*    */}

	/*    */
	/*    */@Test
	/*    */public void test2()
	/*    */{
		/* 23 */Locale locale = Locale.US;
		/*    */
		/* 26 */ResourceBundle bundle = ResourceBundle.getBundle(
		/* 27 */"cn.tla001.locale.msg", locale);
		/* 28 */System.out.println(bundle.getString("username"));
		/* 29 */System.out.println(bundle.getString("age"));
		/*    */}
	/*    */
}
