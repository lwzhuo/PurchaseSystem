package purchasesystem.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;

import java.util.HashMap;

public class returnJson {
    private static Logger logger = Logger.getLogger(returnJson.class);
    private returnJson(){}
    public static String returnMsgandStatus(int status,String msg){
        String string="{\"status\":"+status+",\"msg\":"+"\""+msg+"\"}";
        return string;
    }
    public static String returnOK(){
        return returnMsgandStatus(200,"OK");
    }
    public static String returnError(){
        return returnMsgandStatus(500,"ERROR");
    }

    public static String returnJsonData(Object obj){
        ObjectMapper mapper = new ObjectMapper();
        String string = returnError();
        try {
            string = mapper.writeValueAsString(obj);
        }catch (Exception e){
            logger.error(e);
            logger.info(e);
        }
        return string;
    }

    public static String returnOKWithExtraData(String key,Object obj){
        ObjectMapper mapper = new ObjectMapper();
        String string = returnError();
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("status",200);
            hashMap.put("msg","OK");
            hashMap.put(key,obj);
            string = mapper.writeValueAsString(hashMap);
        }catch (Exception e){
            logger.error(e);
            logger.info(e);
        }
        return string;
    }
}
