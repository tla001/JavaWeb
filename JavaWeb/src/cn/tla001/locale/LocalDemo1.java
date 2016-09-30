/*    */package cn.tla001.locale;

/*    */
/*    *//*    */import java.text.DateFormat;
/*    */
import java.text.NumberFormat;
/*    */
import java.text.ParseException;
/*    */
import java.util.Date;
/*    */
import java.util.Locale;

/*    */
import org.junit.Test;

/*    */
/*    */public class LocalDemo1
/*    */{
	/*    */@Test
	/*    */public void test1()
	/*    */{
		/* 17 */Locale locale = Locale.CHINA;
		/*    */
		/* 19 */double number = 100.0D;
		/*    */
		/* 22 */NumberFormat nf = NumberFormat.getCurrencyInstance(locale);
		/* 23 */String m = nf.format(number);
		/*    */
		/* 25 */System.out.println(m);
		/*    */}

	/*    */
	/*    */@Test
	/*    */public void test2()
	/*    */throws ParseException
	/*    */{
		/* 32 */Locale locale = Locale.US;
		/*    */
		/* 34 */String str = "$1000";
		/*    */
		/* 37 */NumberFormat nf = NumberFormat.getCurrencyInstance(locale);
		/* 38 */Number m = nf.parse(str);
		/*    */
		/* 40 */System.out.println(m);
		/*    */}

	/*    */
	/*    */@Test
	/*    */public void test3()
	/*    */throws ParseException
	/*    */{
		/* 47 */Locale locale = Locale.US;
		/*    */
		/* 49 */NumberFormat nf = NumberFormat.getNumberInstance(locale);
		/* 50 */String str = nf.format(10000000L);
		/*    */
		/* 52 */System.out.println(str);
		/*    */}

	/*    */
	/*    */@Test
	/*    */public void test4()
	/*    */throws ParseException
	/*    */{
		/* 59 */Locale locale = Locale.CHINA;
		/*    */
		/* 61 */int dateStyle = 0;
		/*    */
		/* 63 */int timeStyle = 0;
		/*    */
		/* 65 */DateFormat df = DateFormat.getDateTimeInstance(dateStyle,
				timeStyle,
				/* 66 */locale);
		/* 67 */String str = df.format(new Date());
		/*    */
		/* 69 */System.out.println(str);
		/*    */}
	/*    */
}
