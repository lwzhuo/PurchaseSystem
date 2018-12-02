package PurchaseSystem.util;

public class returnJson {
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
}
