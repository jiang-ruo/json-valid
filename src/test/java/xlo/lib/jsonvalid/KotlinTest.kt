package xlo.lib.jsonvalid

import kotlin.test.Test

/**
 * @author XiaoLOrange
 * @time 2023.06.29
 * @title
 */

class KotlinTest{
	@Test
	fun MapTest(){
		val map = HashMap<String, String>();
		val m2 = map + Pair("1", "2");
		println(map);
		println(m2);
		val m3 = HashMap<String, String>();
		m3.put("3", "4");
		println(m3);
	}

}
