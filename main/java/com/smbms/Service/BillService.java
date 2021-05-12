package com.smbms.Service;

import com.smbms.entity.Bill;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BillService {
    List<Bill> getBillById2(@Param("id") Integer id, @Param("isPayment") Integer isPayment, @Param("proName") String proName);
}
