package xlo.lib.jsonvalid

import com.fasterxml.jackson.databind.JsonNode
import com.github.fge.jackson.JsonLoader
import com.github.fge.jsonschema.core.report.DevNullProcessingReport
import com.github.fge.jsonschema.core.report.ProcessingMessage
import com.github.fge.jsonschema.core.tree.SimpleJsonTree
import com.github.fge.jsonschema.core.util.ValueHolder
import com.github.fge.jsonschema.main.JsonSchemaFactory
import kotlin.test.Test
import kotlin.test.assertTrue

/**
 * @author XiaoLOrange
 * @time 2023.07.04
 * @title json-schema-validator test
 */

class JsvTest {

	@Test
	fun jt() {
		val validator = JsonSchemaFactory.byDefault().validator;
		val schema = JsonLoader.fromResource("/schema2.json");
		val json = JsonLoader.fromString("""[
    {
        "id": "5aacaa7e-15f5-4798-9857-7c34a0d8fda0",
        "name": "foo"
    },
    {
        "id": "not-an-uuid",
        "name": "bar"
    }
]""");
		val report = validator.validate(schema, json);
		println(report.isSuccess);
//		println(report);
		val list = report.map {
			val info = it.asJson();
			val path = info["instance"]["pointer"].asText();
			val msg = it.message;
//			RestrictResult(path, null, null, null, msg);
		}
		println(list);
	}

}