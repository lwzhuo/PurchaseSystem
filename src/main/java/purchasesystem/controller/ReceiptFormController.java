package purchasesystem.controller;

import purchasesystem.model.form.ReceiptForm;
import purchasesystem.model.goods.DetailItem;
import purchasesystem.service.IreceiptFormService;
import purchasesystem.util.ReturnJson;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/receiptform")
public class ReceiptFormController {
    @Resource
    IreceiptFormService receiptFormService;
    @PostMapping(value = "/insert",consumes = "application/json",produces = "application/json")
    public @ResponseBody
    String addReceiptForm(@RequestBody ReceiptForm form){
        long num = receiptFormService.addRF(form);
        if(num<0) return ReturnJson.returnError();
        else return ReturnJson.returnOKWithExtraData("formId",num);
    }

    @GetMapping(value = "/delete")
    public @ResponseBody String deleteReceiptForm(@RequestParam int id){
        int num = receiptFormService.deleteRF(id);
        if(num<0) return ReturnJson.returnError();
        else return ReturnJson.returnOK();
    }

    @PostMapping(value = "deletebatch",consumes = "application/json",produces = "application/json")
    public @ResponseBody String deleteReceiptFormBatch(@RequestBody Map map){
        List deleteList = (List)map.get("deleteList");
        int num = receiptFormService.deleteRFBatch(deleteList);
        if(num<0) return ReturnJson.returnError();
        else return ReturnJson.returnOK();
    }

    @PostMapping(value = "update",consumes = "application/json",produces = "application/json")
    public @ResponseBody String updateReceiptForm(@RequestBody Map<String,ReceiptForm> map){
        ReceiptForm form = map.get("form");
        int num = receiptFormService.updateRF(form);
        if(num<0) return ReturnJson.returnError();
        else return ReturnJson.returnOK();
    }

    @PostMapping(value = "updatebatch",consumes = "application/json",produces = "application/json")
    public @ResponseBody String updateReceiptFormBatch(@RequestBody Map<String,List<ReceiptForm>> map){
        List<ReceiptForm> formlist = map.get("formlist");
        int num = receiptFormService.updateRFBatch(formlist);
        if(num<0) return ReturnJson.returnError();
        else return ReturnJson.returnOK();
    }
    @GetMapping(value = "/getlist",produces = "application/json")
    public @ResponseBody Map getReceiptFormBatch(@RequestParam int base,@RequestParam int offset){
        HashMap hashMap = (HashMap) receiptFormService.getBriefRFBatch(base,offset);
        hashMap.put("sum",receiptFormService.getCount());
        return hashMap;
    }
    @GetMapping(value = "/detail/get",produces = "application/json")
    public @ResponseBody Map getReceiptFormDetail(@RequestParam int id){
        return receiptFormService.getRFDetailById(id);
    }
    @PostMapping(value = "/detail/insert",consumes = "application/json",produces = "application/json")
    public @ResponseBody String insertDetailItem(@RequestBody Map map){
        int formid = (int)map.get("formId");
        List<DetailItem> detailItems = (List<DetailItem>)map.get("detailList");
        int num = receiptFormService.addRFDetailItem(formid,detailItems);
        if(num<0) return ReturnJson.returnError();
        else return ReturnJson.returnOK();
    }
    @PostMapping(value = "/detail/delete",consumes = "application/json",produces = "application/json")
    public @ResponseBody String deleteDetailItem(@RequestBody Map map){
        List<Integer> detailItems = (List<Integer>)map.get("deleteList");
        int num = receiptFormService.deleteRFDetailItem(detailItems);
        if(num<0) return ReturnJson.returnError();
        else return ReturnJson.returnOK();
    }
}
