package com.gcash.exam.gcash.services.client;

import com.gcash.exam.gcash.dto.VoucherResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.cloud.openfeign.FeignClient(value = "voucher", url = "https://c36a022a-4705-4b10-ae11-3155e49d578c.mock.pstmn.io")
public interface MyntFeignClient {
    @GetMapping(value = "/voucher/{voucherCode}", headers = {"accept:application/json"
    })
    VoucherResponse getVoucher(@RequestParam("key") String key, @PathVariable("voucherCode") String code);
}
