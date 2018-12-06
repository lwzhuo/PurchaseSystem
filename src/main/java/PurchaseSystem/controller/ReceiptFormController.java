package PurchaseSystem.controller;

import PurchaseSystem.model.Form.ReceiptForm;
import PurchaseSystem.service.IreceiptFormService;
import PurchaseSystem.util.returnJson;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/receiptform")
public class ReceiptFormController {
    @Resource
    IreceiptFormService receiptFormService;
    @PostMapping(value = "/insert",consumes = "application/json",produces = "application/json")
    public @ResponseBody
    String addReceiptForm(@RequestBody ReceiptForm form){
        int num = receiptFormService.addRF(form);
        if(num<0) return returnJson.returnError();
        else return returnJson.returnOK();
    }

    @GetMapping(value = "/delete")
    public @ResponseBody String deleteReceiptForm(@RequestParam int id){
        int num = receiptFormService.deleteRF(id);
        if(num<0) return returnJson.returnError();
        else return returnJson.returnOK();
    }

    @PostMapping(value = "deletebatch",consumes = "application/json",produces = "application/json")
    public @ResponseBody String deleteReceiptFormBatch(@RequestBody HashMap hashMap){
        List deleteList = (List)hashMap.get("deleteList");
        int num = receiptFormService.deleteRFBatch(deleteList);
        if(num<0) return returnJson.returnError();
        else return returnJson.returnOK();
    }

    @PostMapping(value = "update",consumes = "application/json",produces = "application/json")
    public @ResponseBody String updateReceiptForm(@RequestBody HashMap<String,ReceiptForm> hashMap){
        ReceiptForm form = hashMap.get("form");
        int num = receiptFormService.updateRF(form);
        if(num<0) return returnJson.returnError();
        else return returnJson.returnOK();
    }

    @PostMapping(value = "updatebatch",consumes = "application/json",produces = "application/json")
    public @ResponseBody String updateReceiptFormBatch(@RequestBody HashMap<String,List<ReceiptForm>> hashMap){
        List<ReceiptForm> formlist = hashMap.get("formlist");
        int num = receiptFormService.updateRFBatch(formlist);
        if(num<0) return returnJson.returnError();
        else return returnJson.returnOK();
    }
    @GetMapping(value = "/getlist",produces = "application/json")
    public @ResponseBody HashMap getReceiptFormBatch(@RequestParam int base,@RequestParam int offset){
        HashMap hashMap = (HashMap) receiptFormService.getBriefRFBatch(base,offset);
        hashMap.put("sum",receiptFormService.getCount());
        return hashMap;
    }
    @GetMapping(value = "/detail/get",produces = "application/json")
    public @ResponseBody HashMap getReceiptFormDetail(@RequestParam int id){
        return (HashMap) receiptFormService.getRFDetailById(id);
    }
}