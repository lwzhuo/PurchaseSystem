package purchasesystem.controller;

import purchasesystem.model.Form.OrderForm;
import purchasesystem.model.Goods.DetailItem;
import purchasesystem.service.IorderFormService;
import purchasesystem.util.ReturnJson;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/orderform")
public class OrderFormController {
    @Resource
    IorderFormService orderFormService;
    @PostMapping(value = "/insert",consumes = "application/json",produces = "application/json")
    public @ResponseBody
    String addOrderForm(@RequestBody OrderForm form){
        long num = orderFormService.addOF(form);
        if(num<0) return ReturnJson.returnError();
        else return ReturnJson.returnOKWithExtraData("formId",num);
    }

    @GetMapping(value = "/delete")
    public @ResponseBody String deleteOrderForm(@RequestParam int id){
        int num = orderFormService.deleteOF(id);
        if(num<0) return ReturnJson.returnError();
        else return ReturnJson.returnOK();
    }

    @PostMapping(value = "deletebatch",consumes = "application/json",produces = "application/json")
    public @ResponseBody String deleteOrderFormBatch(@RequestBody HashMap hashMap){
        List deleteList = (List)hashMap.get("deleteList");
        int num = orderFormService.deleteOFBatch(deleteList);
        if(num<0) return ReturnJson.returnError();
        else return ReturnJson.returnOK();
    }

    @PostMapping(value = "update",consumes = "application/json",produces = "application/json")
    public @ResponseBody String updateOrderForm(@RequestBody HashMap<String,OrderForm> hashMap){
        OrderForm form = hashMap.get("Form");
        int num = orderFormService.updateOF(form);
        if(num<0) return ReturnJson.returnError();
        else return ReturnJson.returnOK();
    }

    @PostMapping(value = "updatebatch",consumes = "application/json",produces = "application/json")
    public @ResponseBody String updateOrderFormBatch(@RequestBody HashMap<String,List<OrderForm>> hashMap){
        List<OrderForm> formlist = hashMap.get("formlist");
        int num = orderFormService.updateOFBatch(formlist);
        if(num<0) return ReturnJson.returnError();
        else return ReturnJson.returnOK();
    }
    @GetMapping(value = "/getlist",produces = "application/json")
    public @ResponseBody HashMap getOrderFormBatch(@RequestParam int base,@RequestParam int offset){
        HashMap hashMap = (HashMap) orderFormService.getBriefOFBatch(base,offset);
        hashMap.put("sum",orderFormService.getCount());
        return hashMap;
    }
    @GetMapping(value = "/detail/get",produces = "application/json")
    public @ResponseBody HashMap getOrderFormDetail(@RequestParam int id){
        return (HashMap) orderFormService.getOFDetailById(id);
    }
    @PostMapping(value = "/detail/insert",consumes = "application/json",produces = "application/json")
    public @ResponseBody String insertDetailItem(@RequestBody HashMap hashMap){
        int formid = (int)hashMap.get("formId");
        List<DetailItem> detailItems = (List<DetailItem>)hashMap.get("detailList");
        int num = orderFormService.addOFDetailItem(formid,detailItems);
        if(num<0) return ReturnJson.returnError();
        else return ReturnJson.returnOK();
    }
    @PostMapping(value = "/detail/delete",consumes = "application/json",produces = "application/json")
    public @ResponseBody String deleteDetailItem(@RequestBody HashMap hashMap){
        List<Integer> detailItems = (List<Integer>)hashMap.get("deleteList");
        int num = orderFormService.deleteOFDetailItem(detailItems);
        if(num<0) return ReturnJson.returnError();
        else return ReturnJson.returnOK();
    }
}
