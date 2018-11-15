package ad.cass.poc;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JSR310Module;

public class ExerciserSerializeDateTime {

	static String request ="{\n" + 
			"		\"numeroTiquet\":\"TQ2018ATM\",\n" + 
			"		\"codiTramit\": \"ALEMEDIGEN\",\n" + 
			"		\"ultimEstat\": null,\n" + 
			"		\"numeroIdCASS\": null,\n" + 
			"		\"numeroIdCASS2\": null,\n" + 
			"		\"documentRelacionat\": null,\n" + 
			"		\"dataPagament\": null,\n" + 
			"		\"quantitat\": 1,\n" + 
			"		\"importTramit\": 0,\n" + 
			"		\"facturaTramit\": null,\n" + 
			"		\"usuariCreacio\":\"C127USU\",\"dataHoraCreacio\":null,\n" + 
			"		\"dataHoraModificacio\": null,\n" + 
			"		\"usuariModificacio\": \"C127USU\",\n" + 
			"		\"nomIdCASS\": null,\n" + 
			"		\"nomIdCASS2\": null,\n" + 
			"		\"dataNaixementIdCASS\": null,\n" + 
			"		\"dataNaixementIdCASS2\": null\n" + 
			"}";

	static String response ="{\n" + 
			"	\"quantitat\": 1,\n" + 
			"	\"nomIdCASS\": null,\n" + 
			"	\"codiTramit\": \"ALEMEDIGEN\",\n" + 
			"	\"numeroTiquet\": \"TQ2018ATM\",\n" + 
			"	\"documentRelacionat\": \"\",\n" + 
			"	\"dataNaixementIdCASS\": null,\n" + 
			"	\"ultimEstat\": \"PND\",\n" + 
			"	\"numeroIdCASS2\": \"\",\n" + 
			"	\"usuariModificacio\": \"C127USU\",\n" + 
			"	\"dataNaixementIdCASS2\": null,\n" + 
			"	\"importTramit\": 0,\n" + 
			"	\"dataHoraCreacio\": \"2018-10-29T11:26:31.037\",\n" + 
			"	\"numeroTramit\": \"TA201800700657\",\n" + 
			"	\"nomIdCASS2\": null,\n" + 
			"	\"usuariCreacio\": \"C127USU\",\n" + 
			"	\"dataPagament\": \"0001-01-01\",\n" + 
			"	\"facturaTramit\": \"\",\n" + 
			"	\"dataHoraModificacio\": \"2018-10-29T11:26:31.037\"\n" + 
			"}";

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		//SimpleModule module = new SimpleModule();
		//module.addSerializer(LocalDateTimeSerializer.INSTANCE);
		//module.addDeserializer(LocalDateTimeDeserializer.class, LocalDateTimeDeserializer.INSTANCE);
	    //mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
		mapper.registerModule(new JSR310Module());

		TramitDTO tramitDTO;
		tramitDTO = mapper.readValue(request, TramitDTO.class);
		System.out.println("Request:");
		System.out.println(tramitDTO);
		System.out.println("Response:");
		tramitDTO = mapper.readValue(response, TramitDTO.class);
		System.out.println(tramitDTO);
	}

}
